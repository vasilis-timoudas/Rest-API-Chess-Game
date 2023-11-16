package com.RestChessGame.model.game;

public class Piece {
    protected String color;
    protected String name;

    public Piece(String color) {
        this.color = color;
    }

    public boolean checkMove(Board board, int fromY, int fromX, int toY, int toX){
        return (fromY == toY && fromX == toX);
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

}
