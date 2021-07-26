package com.mygdx.projectkasparov;

public abstract class Piece {

    private boolean isWhite = false;
    private int xLoc; //location on board x axis
    private int yLoc; //location on board y axis

    public Piece(boolean isWhite, int x, int y){
        this.isWhite = isWhite;

        this.xLoc = x;
        this.yLoc = y;
    }

    public boolean getIsWhite(){
        return this.isWhite;
    }

    public void setIsWhite(boolean isWhite){
        this.isWhite = isWhite;
    }

    public void setXLoc(int x){
        this.xLoc = x;
    }

    public int getXLoc(){
        return this.xLoc;
    }

    public void setYLoc(int y){
        this.yLoc = y;
    }

    public int getYLoc(){
        return this.yLoc;
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
