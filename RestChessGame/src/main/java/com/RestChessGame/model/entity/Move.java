package com.RestChessGame.model.entity;

import jakarta.persistence.*;

@Entity(name = "Move")
@Table
public class Move {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moveId;
    private String currentTurn; // 'White' or 'Black'
    private String pieceType;   // ex. 'Pawn'
    private String fromSquare;
    private String toSquare;
    private Long gameId;

    public Move(String currentTurn, String pieceType, String fromSquare, String toSquare, Long gameId) {
        this.currentTurn = currentTurn;
        this.pieceType = pieceType;
        this.fromSquare = fromSquare;
        this.toSquare = toSquare;
        this.gameId = gameId;
    }

    public Move(){}

    public Long getMoveId() {
        return moveId;
    }

    public String getCurrentTurn() {
        return currentTurn;
    }

    public String getPieceType() {
        return pieceType;
    }

    public String getFromSquare() {
        return fromSquare;
    }

    public String getToSquare() {
        return toSquare;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setMoveId(Long moveId) {
        this.moveId = moveId;
    }

    public void setCurrentTurn(String currentTurn) {
        this.currentTurn = currentTurn;
    }

    public void setPieceType(String pieceType) {
        this.pieceType = pieceType;
    }

    public void setFromSquare(String fromSquare) {
        this.fromSquare = fromSquare;
    }

    public void setToSquare(String toSquare) {
        this.toSquare = toSquare;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
}
