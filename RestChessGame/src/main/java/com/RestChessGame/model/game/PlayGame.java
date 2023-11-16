package com.RestChessGame.model.game;


import java.util.List;
import java.util.Arrays;

public class PlayGame {
    private Board board;
    private boolean isWhiteKingAlive;
    private boolean isBlackKingAlive;
    private boolean isWhiteKingBeingThreatened ;
    private boolean isBlackKingBeingThreatened;
    private boolean isGameOver;

    public PlayGame(){
        board = new Board();
        isWhiteKingAlive = true;
        isBlackKingAlive = true;
        isWhiteKingBeingThreatened = false;
        isBlackKingBeingThreatened = false;
        isGameOver = false;
    }

    public Board getBoard(){
        return board;
    }

    public boolean isWhiteKingAlive() {
        return isWhiteKingAlive;
    }

    public boolean isBlackKingAlive() {
        return isBlackKingAlive;
    }

    public boolean isWhiteKingBeingThreatened() {
        return isWhiteKingBeingThreatened;
    }

    public boolean isBlackKingBeingThreatened() {
        return isBlackKingBeingThreatened;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setWhiteKingAlive(boolean whiteKingAlive) {
        isWhiteKingAlive = whiteKingAlive;
    }

    public void setBlackKingAlive(boolean blackKingAlive) {
        isBlackKingAlive = blackKingAlive;
    }

    public void setWhiteKingBeingThreatened(boolean whiteKingBeingThreatened) {
        isWhiteKingBeingThreatened = whiteKingBeingThreatened;
    }

    public void setBlackKingBeingThreatened(boolean blackKingBeingThreatened) {
        isBlackKingBeingThreatened = blackKingBeingThreatened;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public boolean canKingMove(String color){
        if(color.equalsIgnoreCase("White")){
            int[] whiteKingPos = getWhiteKingPosition(board);
            int fromY = whiteKingPos[0];
            int fromX = whiteKingPos[1];
            Piece whiteKing = board.getPieceFromBoard(fromY, fromX);
            if(whiteKing.checkMove(board, fromY, fromX, fromY-1, fromX) ||
               whiteKing.checkMove(board, fromY, fromX, fromY+1, fromX) ||
               whiteKing.checkMove(board, fromY, fromX, fromY, fromX-1) ||
               whiteKing.checkMove(board, fromY, fromX, fromY, fromX+1) ||
               whiteKing.checkMove(board, fromY, fromX, fromY-1, fromX-1) ||
               whiteKing.checkMove(board, fromY, fromX, fromY+1, fromX+1) ||
               whiteKing.checkMove(board, fromY, fromX, fromY-1, fromX+1) ||
               whiteKing.checkMove(board, fromY, fromX, fromY+1, fromX-1))
                return true;
        }
        else if(color.equalsIgnoreCase("Black")){
            int[] blackKingPos = getBlackKingPosition(board);
            int fromY = blackKingPos[0];
            int fromX = blackKingPos[1];
            Piece blackKing = board.getPieceFromBoard(fromY, fromX);
            if(blackKing.checkMove(board, fromY, fromX, fromY-1, fromX) ||
                    blackKing.checkMove(board, fromY, fromX, fromY+1, fromX) ||
                    blackKing.checkMove(board, fromY, fromX, fromY, fromX-1) ||
                    blackKing.checkMove(board, fromY, fromX, fromY, fromX+1) ||
                    blackKing.checkMove(board, fromY, fromX, fromY-1, fromX-1) ||
                    blackKing.checkMove(board, fromY, fromX, fromY+1, fromX+1) ||
                    blackKing.checkMove(board, fromY, fromX, fromY-1, fromX+1) ||
                    blackKing.checkMove(board, fromY, fromX, fromY+1, fromX-1))
                return true;
        }
        return false;
    }

    public boolean isKingBeingThreatened(String color){
        if(color.equalsIgnoreCase("White"))
            return isWhiteKingBeingThreatened();
        return isBlackKingBeingThreatened();
    }

    public void setKingBeingThreatened(String color, boolean isBeingThreatened){
        if(color.equalsIgnoreCase("White"))
            setWhiteKingBeingThreatened(isBeingThreatened);
        setBlackKingBeingThreatened(isBeingThreatened);
    }

    public void movePiece(int fromY, int fromX, int toY, int toX){
        this.board.movePiece(fromY, fromX, toY, toX);
    }
    public Piece getPieceFromBoard(int posY, int posX){
        return this.board.getPieceFromBoard(posY, posX);
    }

    public boolean areCoordinatesOutOfBounds(char posX, char posY){
        List<Character> validXMoves = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h');
        List<Character> validYMoves = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8');
        if(validXMoves.contains(posX) && validYMoves.contains(posY))
            return false;
        return true;
    }

    public int coordinateToX(char posX){
        if(posX == 'a') return 0;
        else if(posX == 'b') return 1;
        else if(posX == 'c') return 2;
        else if(posX == 'd') return 3;
        else if(posX == 'e') return 4;
        else if(posX == 'f') return 5;
        else if(posX == 'g') return 6;
        else if(posX == 'h') return 7;
        return 100;
    }

    public int coordinateToY(char posY){
        if(posY == '8') return 0;
        else if(posY == '7') return 1;
        else if(posY == '6') return 2;
        else if(posY == '5') return 3;
        else if(posY == '4') return 4;
        else if(posY == '3') return 5;
        else if(posY == '2') return 6;
        else if(posY == '1') return 7;
        return 100;
    }

    public int[] getWhiteKingPosition(Board board) {
        int[] position = new int[2];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board.getBoard()[i][j];
                if (piece instanceof King && piece.getColor().equalsIgnoreCase("White")) {
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }
        }
        position[0] = -1;
        position[1] = -1;
        return position;
    }

    public int[] getBlackKingPosition(Board board) {
        int[] position = new int[2];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board.getBoard()[i][j];
                if (piece instanceof King && piece.getColor().equalsIgnoreCase("Black")) {
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }
        }
        position[0] = -1;
        position[1] = -1;
        return position;
    }

    public boolean isCheckmate(String color) {
        if (isKingBeingThreatened(color)) {
            int[] kingPos = (color.equalsIgnoreCase("White")) ? getWhiteKingPosition(board) : getBlackKingPosition(board);
            for (int i = kingPos[0] - 1; i <= kingPos[0] + 1; i++) {
                for (int j = kingPos[1] - 1; j <= kingPos[1] + 1; j++) {
                    if (i >= 0 && i < 8 && j >= 0 && j < 8) {
                        if (board.getPieceFromBoard(kingPos[0], kingPos[1]).checkMove(board, kingPos[0], kingPos[1], i, j)
                                && !isSquareUnderThreat(color, i, j)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean isSquareUnderThreat(String color, int posY, int posX) {
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                Piece piece = board.getBoard()[i][j];
                if (piece != null && !piece.getColor().equals(color)) {
                    if (piece.checkMove(board, posY, posX, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
