package com.mygdx.projectkasparov;

public class Board {

    private Square[][] board; //board of squares to fill

    public Board(){
        this.board = new Square[Constants.BoardSize][Constants.BoardSize]; //create board of squares

        for(int x = 0; x < Constants.BoardSize; x++){ //fill board with squares
            for(int y = 0; y < Constants.BoardSize; y++){
                this.board[x][y] = new Square(x,y); //save square
            }
        }
    }

    public Square getSquare(int x, int y){
        return board[x][y];
    }

    public void setupPieces(){
        
    }
}
