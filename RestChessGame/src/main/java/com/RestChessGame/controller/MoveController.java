package com.RestChessGame.controller;

import com.RestChessGame.model.entity.Move;
import com.RestChessGame.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/chess-game")
public class MoveController {
    private final MoveService moveService;

    @Autowired
    public MoveController(MoveService moveService) {
        this.moveService = moveService;
    }

    // 3. Move a Piece
    @PostMapping("/{gameId}/{from}/{to}")
    public ResponseEntity<String> gameMove(@PathVariable Long gameId, @PathVariable String from, @PathVariable String to){
        //return new ResponseEntity<>(moveService.gameMove(gameId, from, to), HttpStatus.OK);
        try {
            if(moveService.gameMove(gameId, from, to)){
                return new ResponseEntity<>("Move is correct!", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Move is not correct!", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IllegalStateException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all Moves
    @GetMapping("/all-moves")
    public ResponseEntity<List<Move>> getAllMoves(){
        return new ResponseEntity<>(moveService.getAllMoves(), HttpStatus.OK);
    }

    // Get a Game's all Moves by gameId
    @GetMapping("/{gameId}/all-moves")
    public ResponseEntity<List<Move>> getAllMovesById(@PathVariable Long gameId){
        return new ResponseEntity<>(moveService.getAllMovesById(gameId), HttpStatus.OK);
    }

    // Get move by gameId and moveId
    @GetMapping("/{gameId}/{moveId}")
    public ResponseEntity<Optional<Move>> getMoveByGameId(@PathVariable Long gameId, @PathVariable Long moveId){
        return new ResponseEntity<>(moveService.getMoveByGameId(gameId, moveId), HttpStatus.OK);
    }

    // Get all white player moves by gameId and moveId
    @GetMapping("/{gameId}/white-player-moves")
    public ResponseEntity<List<Move>> getAllWhitePlayerMovesByGameId(@PathVariable Long gameId){
        return new ResponseEntity<>(moveService.getAllWhitePlayerMovesByGameId(gameId), HttpStatus.OK);
    }

    // Get all black player moves by gameId and moveId
    @GetMapping("/{gameId}/black-player-moves")
    public ResponseEntity<List<Move>> getAllBlackPlayerMovesByGameId(@PathVariable Long gameId){
        return new ResponseEntity<>(moveService.getAllBlackPlayerMovesByGameId(gameId), HttpStatus.OK);
    }

}
