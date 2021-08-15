package com.mygdx.projectkasparov;

public class Square {

    private boolean isOccupied; //holds if a square is occupied
    private Piece heldPiece; //piece held on the square
    private final Location loc; //stores location of square

    public Square(int x, int y){
        this.isOccupied = false; //set to unoccupied

        this.loc = new Location(x, y); //set location
    }

    public Square(Piece piece, int x, int y){
        this.isOccupied = true; //set to occupied

        this.heldPiece = piece; //save piece

        this.loc = new Location(x, y); //set location
    }

    public boolean getOccupied(){
        return this.isOccupied; //return occupied state
    }

    public Piece getHeldPiece(){
        return this.heldPiece; //return piece
    }

    public void setUnoccupied(){
        this.isOccupied = false; //update occupied state
        this.heldPiece = null; //save heldPiece
    }

    public void setHeldPiece(Piece piece){
        this.isOccupied = true; //update to occupied
        this.heldPiece = piece; //save piece
    }
}
