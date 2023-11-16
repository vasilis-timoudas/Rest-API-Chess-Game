package com.RestChessGame.model.game;

public class Bishop extends Piece{

    public Bishop(String color) {
        super(color);
        name = "Bishop";
    }

    @Override
    public boolean checkMove(Board board, int fromY, int fromX, int toY, int toX) {
        int distanceY = fromY - toY;
        int distanceX = fromX - toX;

        if(this.color.equalsIgnoreCase("White")) {
            // Forward Right Move 1 position
            if(fromY == toY + 1 && fromX == toX + 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("Black"))){
                return true;
            }
            // Forward Left Move 1 position
            else if(fromY == toY + 1 && fromX == toX - 1 &&
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
            // Forward Right Move N positions
            else if(distanceY > 0 && distanceX < 0){
                if(board.isForwardRightDiagonalEmpty(fromY, fromX, toY, toX)){
                    if(board.isEmpty(toY, toX) || board.getPieceFromBoard(toY, toX).getColor().equalsIgnoreCase("Black")){
                        return true;
                    }
                }
            }
            // Forward Left Move N positions
            else if(distanceY > 0 && distanceX > 0){
                if(board.isForwardLeftDiagonalEmpty(fromY, fromX, toY, toX)){
                    if(board.isEmpty(toY, toX) || board.getPieceFromBoard(toY, toX).getColor().equalsIgnoreCase("Black")){
                        return true;
                    }
                }
            }
            // Backward Right Move N positions
            else if(distanceY < 0 && distanceX < 0){
                if(board.isBackwardRightDiagonalEmpty(fromY, fromX, toY, toX)){
                    if(board.isEmpty(toY, toX) || board.getPieceFromBoard(toY, toX).getColor().equalsIgnoreCase("Black")){
                        return true;
                    }
                }
            }
            // Backward Left Move N positions
            else if(distanceY < 0 && distanceX > 0){
                if(board.isBackwardLeftDiagonalEmpty(fromY, fromX, toY, toX)){
                    if(board.isEmpty(toY, toX) || board.getPieceFromBoard(toY, toX).getColor().equalsIgnoreCase("Black")){
                        return true;
                    }
                }
            }
        }
        else if(this.color.equalsIgnoreCase("Black")){
            // Forward Right Move 1 position
            if(fromY == toY + 1 && fromX == toX + 1 &&
                    (board.getBoard()[toY][toX] == null || board.getBoard()[toY][toX].getColor().equalsIgnoreCase("White"))){
                return true;
            }
            // Forward Left Move 1 position
            else if(fromY == toY + 1 && fromX == toX - 1 &&
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
            // Forward Right Move N positions
            else if(distanceY > 0 && distanceX < 0){
                if(board.isForwardRightDiagonalEmpty(fromY, fromX, toY, toX)){
                    if(board.isEmpty(toY, toX) || board.getPieceFromBoard(toY, toX).getColor().equalsIgnoreCase("White")){
                        return true;
                    }
                }
            }
            // Forward Left Move N positions
            else if(distanceY > 0 && distanceX > 0){
                if(board.isForwardLeftDiagonalEmpty(fromY, fromX, toY, toX)){
                    if(board.isEmpty(toY, toX) || board.getPieceFromBoard(toY, toX).getColor().equalsIgnoreCase("White")){
                        return true;
                    }
                }
            }
            // Backward Right Move N positions
            else if(distanceY < 0 && distanceX < 0){
                if(board.isBackwardRightDiagonalEmpty(fromY, fromX, toY, toX)){
                    if(board.isEmpty(toY, toX) || board.getPieceFromBoard(toY, toX).getColor().equalsIgnoreCase("White")){
                        return true;
                    }
                }
            }
            // Backward Left Move N positions
            else if(distanceY < 0 && distanceX > 0){
                if(board.isBackwardLeftDiagonalEmpty(fromY, fromX, toY, toX)){
                    if(board.isEmpty(toY, toX) || board.getPieceFromBoard(toY, toX).getColor().equalsIgnoreCase("White")){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
