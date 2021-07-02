package com.mygdx.projectkasparov;

public abstract class Piece {

    public enum PieceColor {
        BLACK, WHITE
    }

    public enum PieceType {
        KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN
    }

    public enum PieceState {
        ACTIVE, CAPTURED
    }

    private PieceColor color;
    private PieceType type;
    private PieceState state;
    private int xLoc; //location on board x axis
    private int yLoc; //location on board y axis

    public Piece(PieceColor color, PieceType type, PieceState state, int x, int y){
        this.color = color;
        this.type = type;
        this.state = state;

        this.xLoc = x;
        this.yLoc = y;
    }

    public PieceColor getColor(){
        return this.color;
    }

    public PieceType getType(){
        return this.type;
    }

    public PieceState getState(){
        return this.state;
    }

    public int[] getLocation(){
        int[] loc = new int[2];
        loc[0] = this.xLoc;
        loc[1] = this.yLoc;

        return loc;
    }
}
