package com.RestChessGame.model.game;

public class Pawn extends Piece{
    private boolean hasFirstMove = true;

    public Pawn(String color){
        super(color);
        name = "Pawn";
    }

    public boolean isHasFirstMove() {
        return hasFirstMove;
    }

    public void setHasFirstMove(boolean hasFirstMove) {
        this.hasFirstMove = hasFirstMove;
    }

    @Override
    public boolean checkMove(Board board, int fromY, int fromX, int toY, int toX) {
        if(this.color.equalsIgnoreCase("White")) {
            // Forward Move 2 positions
            if(fromY == toY + 2 && fromX == toX &&
               hasFirstMove &&
               (board.getBoard()[toY][toX] == null) &&
               board.getBoard()[toY+1][toX] == null){
                hasFirstMove = false;
                return true;
            }
            // Forward Move 1 position
            else if(fromY == toY + 1 && fromX == toX &&
                   (board.getBoard()[toY][toX] == null)) {
                hasFirstMove = false;
                return true;
            }
            // Forward Right Move 1 position (attack only)
            else if(fromY == toY + 1 && fromX == toX + 1 &&
                   (board.getBoard()[toY][toX] != null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("Black"))){
                hasFirstMove = false;
                return true;
            }
            // Forward Left Move 1 position (attack only)
            else if(fromY == toY + 1 && fromX == toX - 1 &&
                   (board.getBoard()[toY][toX] != null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("Black"))){
                hasFirstMove = false;
                return true;
            }
        }
        else if(this.color.equalsIgnoreCase("Black")){
            // Forward Move 2 positions
            if(fromY == toY - 2 && fromX == toX &&
                    hasFirstMove &&
                    (board.getBoard()[toY][toX] == null) &&
                    board.getBoard()[toY-1][toX] == null){
                hasFirstMove = false;
                return true;
            }
            // Forward Move 1 position
            else if(fromY == toY - 1 && fromX == toX &&
                    (board.getBoard()[toY][toX] == null)) {
                hasFirstMove = false;
                return true;
            }
            // Forward Right Move 1 position
            else if(fromY == toY - 1 && fromX == toX - 1 &&
                    (board.getBoard()[toY][toX] != null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                hasFirstMove = false;
                return true;
            }
            // Forward Left Move 1 position
            else if(fromY == toY - 1 && fromX == toX + 1 &&
                    (board.getBoard()[toY][toX] != null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                hasFirstMove = false;
                return true;
            }
        }
        return false;
    }
}
