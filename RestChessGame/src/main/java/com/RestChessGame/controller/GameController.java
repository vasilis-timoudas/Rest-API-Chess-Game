package com.RestChessGame.controller;

import com.RestChessGame.model.entity.Game;
import com.RestChessGame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/chess-game")
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // 1. Create new Game
    @PostMapping("/new-game")
    public ResponseEntity<Long> newGame(){
        return new ResponseEntity<>(gameService.newGame(), HttpStatus.OK);
    }

    // 2. Get Game by gameId
    @GetMapping("/{gameId}")
    public ResponseEntity<Optional<Game>> getGameById(@PathVariable Long gameId){
        return new ResponseEntity<>(gameService.getGameById(gameId), HttpStatus.OK);
    }

    // 4. List of all Games
    @GetMapping
    public ResponseEntity<List<Game>> getAllGames(){
        return new ResponseEntity<>(gameService.getAllGames(), HttpStatus.OK);
    }

    // 5. Delete Game by gameId
    @DeleteMapping("/{gameId}")
    public ResponseEntity<String> deleteGameById(@PathVariable Long gameId){
        try {
            gameService.deleteGameById(gameId);
            return new ResponseEntity<>("Game with ID " + gameId + " has been deleted", HttpStatus.NO_CONTENT);
        } catch (IllegalStateException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update gameId by gameId
    @PutMapping("/{gameId}")
    public ResponseEntity<String> updateGameId(@PathVariable Long gameId, @RequestBody Game updatedGame) {
        try {
            gameService.updateGameId(gameId, updatedGame);
            return new ResponseEntity<>("Game ID " + gameId + " has been updated", HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
