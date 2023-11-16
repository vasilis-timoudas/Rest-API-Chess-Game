package com.RestChessGame.model.game;


public class Board {
    private Piece[][] board;

    public Board(){
        // Init board
        board = new Piece[8][8];

        // Init Black Pieces
        for(int i=0; i<8; i++)
            board[1][i] = new Pawn("Black");
        board[0][0] = new Rook("Black");
        board[0][1] = new Knight("Black");
        board[0][2] = new Bishop("Black");
        board[0][3] = new Queen("Black");
        board[0][4] = new King("Black");
        board[0][5] = new Bishop("Black");
        board[0][6] = new Knight("Black");
        board[0][7] = new Rook("Black");

        // Init White Pieces
        for(int i=0; i<8; i++)
            board[6][i] = new Pawn("White");
        board[7][0] = new Rook("White");
        board[7][1] = new Knight("White");
        board[7][2] = new Bishop("White");
        board[7][3] = new Queen("White");
        board[7][4] = new King("White");
        board[7][5] = new Bishop("White");
        board[7][6] = new Knight("White");
        board[7][7] = new Rook("White");
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void movePiece(int fromY, int fromX, int toY, int toX){
        setPieceToBoard(getPieceFromBoard(fromY, fromX), toY, toX);
        this.board[fromY][fromX] = null;
    }

    public Piece getPieceFromBoard(int posY, int posX){
        return this.board[posY][posX];
    }

    public void setPieceToBoard(Piece piece, int posY, int posX){
        this.board[posY][posX] = piece;
    }

    public boolean isEmpty(int posY, int posX){
        if(this.board[posY][posX] == null)
            return true;
        return false;
    }

    public boolean isEnemyPiece(String color, int posY, int posX){
        if(color.equalsIgnoreCase("White")){
            if(this.board[posY][posX].getColor().equals("Black")){
                return true;
            }
        }
        else if(color.equalsIgnoreCase("Black")){
            if(this.board[posY][posX].getColor().equals("White")){
                return true;
            }
        }
        return false;
    }

    public boolean isForwardEmpty(int fromY, int fromX, int toY, int toX) {
        for (int i = fromY - 1; i > toY; i--) {
            if (board[i][fromX] != null) {
                return false;
            }
        }
        return true;
    }

    public boolean isBackwardEmpty(int fromY, int fromX, int toY, int toX) {
        for (int i = fromY + 1; i < toY; i++) {
            if (board[i][fromX] != null) {
                return false;
            }
        }
        return true;
    }

    public boolean isRightEmpty(int fromY, int fromX, int toY, int toX){
        for(int i=fromX+1; i<toX; i++){
            if(board[fromY][i] != null){
                return false;
            }
        }
        return true;
    }

    public boolean isLeftEmpty(int fromY, int fromX, int toY, int toX){
        for(int i=fromX-1; i>toX; i--){
            if(board[fromY][i] != null){
                return false;
            }
        }
        return true;
    }

    public boolean isForwardRightDiagonalEmpty(int fromY, int fromX, int toY, int toX){
        for(int i=fromY-1; i>toY; i--){
            if (board[i][++fromX] != null) {
                return false;
            }
        }
        return true;
    }

    public boolean isForwardLeftDiagonalEmpty(int fromY, int fromX, int toY, int toX){
        for(int i=fromY-1; i>toY; i--){
            if (board[i][--fromX] != null) {
                return false;
            }
        }
        return true;
    }

    public boolean isBackwardRightDiagonalEmpty(int fromY, int fromX, int toY, int toX){
        for(int i=fromY+1; i<toY; i++){
            if(board[i][++fromX] != null){
                return false;
            }
        }
        return true;
    }

    public boolean isBackwardLeftDiagonalEmpty(int fromY, int fromX, int toY, int toX){
        for(int i=fromY+1; i<toY; i++){
            if(board[i][--fromX] != null){
                return false;
            }
        }
        return true;
    }

}
