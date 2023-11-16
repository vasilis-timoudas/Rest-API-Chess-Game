package com.RestChessGame.service;

import com.RestChessGame.model.entity.Game;
import com.RestChessGame.repository.GameRepository;
import com.RestChessGame.repository.MoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final MoveRepository moveRepository;

    @Autowired
    public GameService(GameRepository gameRepository, MoveRepository moveRepository) {
        this.gameRepository = gameRepository;
        this.moveRepository = moveRepository;
    }

    public Long newGame(){
        Game newGame = new Game();
        gameRepository.save(newGame);
        return newGame.getGameId();
    }

    public Optional<Game> getGameById(Long gameId){
        Optional<Game> gameOptional = gameRepository.findById(gameId);
        if(gameOptional.isPresent())
            return gameRepository.findById(gameId);
        throw new IllegalStateException("Game with ID " + gameId + " not found.");
    }

    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }

    public void deleteGameById(Long gameId){
        Optional<Game> gameOptional = gameRepository.findById(gameId);
        if(gameOptional.isPresent()){
            gameRepository.deleteById(gameId);

            if(moveRepository.existsByGameId(gameId)){
                moveRepository.deleteByGameId(gameId);
            }
        }
        else
            throw new IllegalStateException("Game with ID " + gameId + " not found.");
    }

    public void updateGameId(Long gameId, Game updatedGame) {
        Optional<Game> gameOptional = gameRepository.findById(gameId);
        if (gameOptional.isPresent()) {
            gameRepository.updateGameIdById(gameId, updatedGame.getGameId());

          //  if(moveRepository.existsByGameId(gameId)){
           //     moveRepository.updateByGameId(gameId, updatedGame.getGameId());
           // }
        } else {
            throw new IllegalStateException("Game with ID " + gameId + " not found.");
        }
    }
}
