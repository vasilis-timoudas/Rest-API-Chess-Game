package com.RestChessGame.model.game;

public class Knight extends Piece{

    public Knight(String color) {
        super(color);
        name = "Knight";
    }

    @Override
    public boolean checkMove(Board board, int fromY, int fromX, int toY, int toX) {
        if(this.color.equalsIgnoreCase("White")) {
            if (fromY == toY + 1 && fromX == toX - 2 &&
               (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("Black"))){
                return true;
            }
            else if (fromY == toY + 1 && fromX == toX + 2 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("Black"))){
                return true;
            }
            else if (fromY == toY - 1 && fromX == toX + 2 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("Black"))){
                return true;
            }
            else if (fromY == toY - 1 && fromX == toX - 2 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("Black"))){
                return true;
            }
            else if (fromY == toY + 2 && fromX == toX - 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("Black"))){
                return true;
            }
            else if (fromY == toY + 2 && fromX == toX + 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("Black"))){
                return true;
            }
            else if (fromY == toY - 2 && fromX == toX - 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("Black"))){
                return true;
            }
            else if (fromY == toY - 2 && fromX == toX + 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("Black"))){
                return true;
            }
        }
        else if(this.color.equalsIgnoreCase("Black")){
            if (fromY == toY + 1 && fromX == toX - 2 &&
               (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                return true;
            }
            else if (fromY == toY + 1 && fromX == toX + 2 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                return true;
            }
            else if (fromY == toY - 1 && fromX == toX + 2 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                return true;
            }
            else if (fromY == toY - 1 && fromX == toX - 2 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                return true;
            }
            else if (fromY == toY + 2 && fromX == toX - 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                return true;
            }
            else if (fromY == toY + 2 && fromX == toX + 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                return true;
            }
            else if (fromY == toY - 2 && fromX == toX - 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                return true;
            }
            else if (fromY == toY - 2 && fromX == toX + 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                return true;
            }
        }
        return false;
    }
}
