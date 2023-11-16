package com.RestChessGame.service;

import com.RestChessGame.model.entity.Game;
import com.RestChessGame.model.entity.Move;
import com.RestChessGame.model.game.Piece;
import com.RestChessGame.model.game.PlayGame;
import com.RestChessGame.repository.GameRepository;
import com.RestChessGame.repository.MoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoveService {
    private final MoveRepository moveRepository;
    private final GameRepository gameRepository;

    private final PlayGame playGame;

    @Autowired
    public MoveService(MoveRepository moveRepository, GameRepository gameRepository) {
        this.moveRepository = moveRepository;
        this.gameRepository = gameRepository;
        playGame = new PlayGame();
    }

    public boolean gameMove(Long gameId, String from, String to) {
        Optional<Game> gameOptional = gameRepository.findById(gameId);
        /* Check if:
         *     1.'gameId' exists
         *     2. Game is not over
         *     3. The selected piece is not moved to the selected piece position
         *     4. Coordinates length equal to 2
         *     5. Coordinates and are not out of bounce
         */
        if(gameOptional.isPresent() &&
           !playGame.isGameOver() &&
           !from.equals(to) &&
           from.length() == 2 && to.length() == 2 &&
           !playGame.areCoordinatesOutOfBounds(from.charAt(0), from.charAt(1)) &&
           !playGame.areCoordinatesOutOfBounds(to.charAt(0), to.charAt(1))){

            String currentTurn = gameOptional.get().getCurrentTurn();
            int fromY = playGame.coordinateToY(from.charAt(1));
            int fromX = playGame.coordinateToX(from.charAt(0));
            int toY = playGame.coordinateToY(to.charAt(1));
            int toX = playGame.coordinateToX(to.charAt(0));
            int[] enemyKingPos = new int[2];
            boolean isMyKingBeingThreatened = playGame.isKingBeingThreatened(currentTurn);
            Piece fromPiece;
            Piece toPiece;

            try {
                // Maybe pieces will be null
                fromPiece = playGame.getPieceFromBoard(fromY, fromX);
                toPiece = playGame.getPieceFromBoard(toY, toX);

                /* Check if:
                 *     6. The player with the current turn selected his own piece
                 *     7. The player didn't select empty position in board
                 *     8. The position that the player wants to move his piece is empty or has an enemy piece
                 *     9. The player's move is valid
                 */
                if(currentTurn.equalsIgnoreCase(fromPiece.getColor()) &&
                   fromPiece != null &&
                   (toPiece == null || !toPiece.getColor().equalsIgnoreCase(currentTurn)) &&
                   fromPiece.checkMove(playGame.getBoard(), fromY, fromX, toY, toX)){

                    /* Check if:
                     *     10A. The player's king is not being threatened
                     */
                    if(!isMyKingBeingThreatened){
                        // Save move to database
                        Move newMove = new Move(currentTurn, fromPiece.getName(), from, to, gameId);
                        moveRepository.save(newMove);

                        // Make move to board
                        playGame.movePiece(fromY, fromX, toY, toX);

                        // Update player's turn in database
                        gameOptional.get().setCurrentTurn("white".equals(currentTurn) ? "black" : "white");
                        gameRepository.save(gameOptional.get());

                        /* Check if:
                         *     10A1.The player's move can threaten the enemy's king
                         */
                        if(playGame.getPieceFromBoard(toY, toX)
                                .checkMove(playGame.getBoard(), toY, toX, enemyKingPos[0], enemyKingPos[1])){
                            playGame.setKingBeingThreatened(gameOptional.get().getCurrentTurn(), true);
                        }
                        return true;
                    }
                    /* Check if:
                     *     10B. The player's king is being threatened
                     */
                    else{
                        /* Check if:
                         *     10B1.The player's king is in checkmate
                         */
                        if (playGame.isCheckmate(currentTurn)) {
                            playGame.setGameOver(true);

                            String winner = (currentTurn.equalsIgnoreCase("Black")) ? "white" : "black";

                            // Save Results to Database
                            gameRepository.updateWinnerById(gameId, winner);
                            gameRepository.updateCurrentTurnById(gameId, "");

                            return false;
                        }
                        /* Check if:
                         *     10B2.The player's king is not in checkmate
                         */
                        else {
                            int[] kingPos = ("white".equalsIgnoreCase(currentTurn))
                                            ? playGame.getWhiteKingPosition(playGame.getBoard())
                                            : playGame.getBlackKingPosition(playGame.getBoard());

                            for (int i = 0; i < playGame.getBoard().getBoard().length; i++) {
                                for (int j = 0; j < playGame.getBoard().getBoard()[i].length; j++) {
                                    Piece piece = playGame.getBoard().getPieceFromBoard(i, j);
                                    if (piece != null && piece.getColor().equalsIgnoreCase(currentTurn)) {
                                        for (int x = kingPos[0] - 1; x <= kingPos[0] + 1; x++) {
                                            for (int y = kingPos[1] - 1; y <= kingPos[1] + 1; y++) {
                                                if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                                                    if (piece.checkMove(playGame.getBoard(), i, j, x, y)
                                                            && !playGame.isSquareUnderThreat(currentTurn, x, y)) {

                                                        // Save Results to Database
                                                        Move newMove = new Move(currentTurn, fromPiece.getName(), from, to, gameId);
                                                        moveRepository.save(newMove);

                                                        // Move piece
                                                        playGame.movePiece(i, j, x, y);

                                                        // Update player's turn in database
                                                        gameOptional.get().setCurrentTurn("white".equals(currentTurn) ? "black" : "white");
                                                        gameRepository.save(gameOptional.get());

                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            } catch (Exception e) {
                return false;
            }
        }

        return false;
    }

    public List<Move> getAllMoves() {
        return moveRepository.findAll();
    }

    public List<Move> getAllMovesById(Long gameId) {
        return moveRepository.findByGameId(gameId);
    }

    public Optional<Move> getMoveByGameId(Long gameId, Long moveId) {
        Optional<Game> gameOptional = gameRepository.findById(gameId);
        Optional<Move> moveOptional = moveRepository.findByGameIdAndId(gameId, moveId);

        if(gameOptional.isPresent()){
            if(moveOptional.isPresent()){
                return moveRepository.findByGameIdAndId(gameId, moveId);
            }
            else {
                throw new IllegalStateException("Move with ID " + moveId + " not found.");
            }
        }
        else {
            throw new IllegalStateException("Game with ID " + gameId + " not found.");
        }
    }

    public List<Move> getAllWhitePlayerMovesByGameId(Long gameId) {
        Optional<Game> gameOptional = gameRepository.findById(gameId);
        if(gameOptional.isPresent()){
            return moveRepository.findByGameIdAndCurrentTurn(gameId, "white");
        }
        throw new IllegalStateException("Game with ID " + gameId + " not found.");
    }

    public List<Move> getAllBlackPlayerMovesByGameId(Long gameId) {
        Optional<Game> gameOptional = gameRepository.findById(gameId);
        if(gameOptional.isPresent()){
            return moveRepository.findByGameIdAndCurrentTurn(gameId, "black");
        }
        throw new IllegalStateException("Game with ID " + gameId + " not found.");
    }
}
