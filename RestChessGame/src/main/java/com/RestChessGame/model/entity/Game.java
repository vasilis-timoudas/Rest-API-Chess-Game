package com.RestChessGame.model.entity;

import jakarta.persistence.*;

@Entity(name = "Game")
@Table
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;
    private String currentTurn;  // 'White' or 'Black'
    private String winner;

    public Game(){
        currentTurn = "white";
        winner = "";
    }

    public Long getGameId() {
        return gameId;
    }

    public String getCurrentTurn() {
        return currentTurn;
    }

    public String getWinner() {
        return winner;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public void setCurrentTurn(String currentTurn) {
        this.currentTurn = currentTurn;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
