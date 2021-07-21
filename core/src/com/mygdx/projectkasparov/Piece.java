package com.mygdx.projectkasparov;

public class Piece {

    public enum PieceColor {
        BLACK(false), WHITE(true);

        private boolean isWhite;

        PieceColor(boolean isWhite){
            this.isWhite = isWhite;
        }

        boolean getColor(){
            return this.isWhite;
        }
    }

    public enum PieceType {
        KING("King", "K"), QUEEN("Queen", "Q"), ROOK("Rook", "R"),
        BISHOP("Bishop", "B"), KNIGHT("Knight", "N"), PAWN("Pawn", "");

        private String name; //name
        private String abbr; //abbreviated name

        PieceType(String name, String abbr){
            this.name = name;
            this.abbr = abbr;
        }

        String getName(){
            return this.name;
        }

        String getAbbr(){
            return this.abbr;
        }
    }

    public enum PieceState {
        UNMOVED(0), MOVED(1), CAPTURED(2);

        private int val; //value

        PieceState(int num){
            this.val = num;
        }

        int getNum(){
            return this.val;
        }
    }

    private final PieceColor color;
    private PieceType type;
    private PieceState state;
    private int xLoc; //location on board x axis
    private int yLoc; //location on board y axis

    public Piece(PieceType type, PieceState state, PieceColor color, int x, int y){
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

    public void setType(PieceType newType){
        this.type = newType;
    }

    public PieceState getState(){
        return this.state;
    }

    public void setState(PieceState newState){
        this.state = newState;
    }

    public void setLocation(int x, int y){
        this.xLoc = x;
        this.yLoc = y;
    }

    public int[] getLocation(){
        int[] loc = new int[2];
        loc[0] = this.xLoc;
        loc[1] = this.yLoc;

        return loc;
    }
}
