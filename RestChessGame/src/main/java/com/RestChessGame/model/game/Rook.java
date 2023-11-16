package com.RestChessGame.model.game;

public class Rook extends Piece{

    public Rook(String color) {
        super(color);
        name = "Rook";
    }

    @Override
    public boolean checkMove(Board board, int fromY, int fromX, int toY, int toX) {
        int distanceY = fromY - toY;
        int distanceX = fromX - toX;

        if(this.color.equalsIgnoreCase("White")) {
            // Forward Move 1 position
            if(fromY == toY + 1 && fromX == toX &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("Black"))){
                return true;
            }
            // Backward Move 1 position
            if(fromY == toY - 1 && fromX == toX &&
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
            // Forward Move N positions
            if(distanceY > 0 && distanceX == 0){
                if(board.isForwardEmpty(fromY, fromX, toY, toX)){ // OK
                    if(board.isEmpty(toY, toX) || board.getPieceFromBoard(toY, toX).getColor().equalsIgnoreCase("Black")){
                        return true;
                    }
                }
            }
            // Backward Move N positions
            else if(distanceY < 0 && distanceX == 0){ // OK
                if(board.isBackwardEmpty(fromY, fromX, toY, toX)){
                    if(board.isEmpty(toY, toX) || board.getPieceFromBoard(toY, toX).getColor().equalsIgnoreCase("Black")){
                        return true;
                    }
                }
            }
            // Right Move N positions
            else if(distanceY == 0 && distanceX < 0) {
                if(board.isRightEmpty(fromY, fromX, toY, toX)){
                    if(board.isEmpty(toY, toX) || board.getPieceFromBoard(toY, toX).getColor().equalsIgnoreCase("Black")){
                        return true;
                    }
                }
            }
            // Left Move N positions
            else if(distanceY == 0 && distanceX > 0){
                if(board.isLeftEmpty(fromY, fromX, toY, toX)){
                    if(board.isEmpty(toY, toX) || board.getPieceFromBoard(toY, toX).getColor().equalsIgnoreCase("Black")){
                        return true;
                    }
                }
            }
        }
        else if(this.color.equalsIgnoreCase("Black")) {
            // Forward Move 1 position
            if(fromY == toY + 1 && fromX == toX &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                return true;
            }
            // Backward Move 1 position
            if(fromY == toY - 1 && fromX == toX &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                return true;
            }
            // Right Move 1 position
            else if(fromY == toY && fromX == toX - 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                return true;
            }
            // Left Move 1 position
            else if(fromY == toY && fromX == toX + 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                return true;
            }
            // Forward Move N positions
            if(distanceY > 0 && distanceX == 0){
                if(board.isForwardEmpty(fromY, fromX, toY, toX)){
                    if(board.isEmpty(toY, toX) || board.getPieceFromBoard(toY, toX).getColor().equalsIgnoreCase("White")){
                        return true;
                    }
                }
            }
            // Backward Move N positions
            else if(distanceY < 0 && distanceX == 0){
                if(board.isBackwardEmpty(fromY, fromX, toY, toX)){
                    if(board.isEmpty(toY, toX) || board.getPieceFromBoard(toY, toX).getColor().equalsIgnoreCase("White")){
                        return true;
                    }
                }
            }
            // Right Move N positions
            else if(distanceY == 0 && distanceX < 0) {
                if(board.isRightEmpty(fromY, fromX, toY, toX)){
                    if(board.isEmpty(toY, toX) || board.getPieceFromBoard(toY, toX).getColor().equalsIgnoreCase("White")){
                        return true;
                    }
                }
            }
            // Left Move N positions
            else if(distanceY == 0 && distanceX > 0){
                if(board.isLeftEmpty(fromY, fromX, toY, toX)){
                    if(board.isEmpty(toY, toX) || board.getPieceFromBoard(toY, toX).getColor().equalsIgnoreCase("White")){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
