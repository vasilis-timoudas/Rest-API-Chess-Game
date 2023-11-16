package com.RestChessGame.model.game;

public class King extends Piece{

    public King(String color) {
        super(color);
        name = "King";
    }

    @Override
    public boolean checkMove(Board board, int fromY, int fromX, int toY, int toX) {
        if(this.color.equalsIgnoreCase("White")) {
            // Forward Move 1 position
            if(fromY == toY + 1 && fromX == toX &&
              (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("Black"))){
                return true;
            }
            // Forward Right Move 1 position
            else if(fromY == toY + 1 && fromX == toX + 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("Black"))){
                return true;
            }
            // Forward Left Move 1 position
            else if(fromY == toY + 1 && fromX == toX - 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("Black"))){
                return true;
            }
            // Backward Move 1 position
            if(fromY == toY - 1 && fromX == toX &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("Black"))){
                return true;
            }
            // Backward Right Move 1 position
            else if(fromY == toY - 1 && fromX == toX - 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("Black"))){
                return true;
            }
            // Backward Left Move 1 position
            else if(fromY == toY - 1 && fromX == toX + 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("Black"))){
                return true;
            }
            // Right Move 1 position
            else if(fromY == toY && fromX == toX - 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("Black"))){
                return true;
            }
            // Left Move 1 position
            else if(fromY == toY && fromX == toX + 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("Black"))){
                return true;
            }
        }
        else if(this.color.equalsIgnoreCase("Black")){
            // Forward Move 1 position
            if(fromY == toY + 1 && fromX == toX &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                return true;
            }
            // Forward Right Move 1 position
            else if(fromY == toY + 1 && fromX == toX + 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                return true;
            }
            // Forward Left Move 1 position
            else if(fromY == toY + 1 && fromX == toX - 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                return true;
            }
            // Backward Move 1 position
            if(fromY == toY - 1 && fromX == toX &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                return true;
            }
            // Backward Right Move 1 position
            else if(fromY == toY - 1 && fromX == toX - 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                return true;
            }
            // Backward Left Move 1 position
            else if(fromY == toY - 1 && fromX == toX + 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                return true;
            }
            // Right Move 1 position
            else if(fromY == toY && fromX == toX + 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                return true;
            }
            // Left Move 1 position
            else if(fromY == toY && fromX == toX - 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                return true;
            }
        }
        return false;
    }
}
