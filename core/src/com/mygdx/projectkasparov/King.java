package com.mygdx.projectkasparov;

public class King extends Piece {

    private boolean hasCastled = false;

    public King(boolean isWhite, int x, int y){
        super("King", isWhite, x, y);
    }



    public boolean getCastled(boolean hasCastled){
        return this.hasCastled; //return if Castled
    }

    public void setCastled(boolean hasCastled){
        this.hasCastled = hasCastled; //set new Castled
    }
}
