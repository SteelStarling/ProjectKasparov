package com.mygdx.projectkasparov;

public abstract class Piece {

    private boolean isWhite = false;
    private boolean hasMoved = false;
    private String pieceType
    private Location loc;

    public Piece(String type, boolean isWhite, int x, int y){
        this.isWhite = isWhite;
        this.pieceType = type;

        loc = new Location(x,y); //create new location to hold data
    }

    public boolean getIsWhite(){
        return this.isWhite;
    }

    public void setIsWhite(boolean isWhite){
        this.isWhite = isWhite;
    }

    public Location getLoc() {
        return this.loc;
    }

    public int getXLoc(){
        return this.loc.getXPos();
    }

    public int getYLoc(){
        return this.loc.getYPos();
    }

    public abstract boolean isValidMove(int x, int y)

    public boolean setLocation(int x, int y){
        int xPos = this.getXLoc(); //get starting positions
        int yPos = this.getYLoc();
        if((x == xPos) && (y == yPos)){ //if positions are unchanged, return false and do nothing (if no move, don't move)
            return false;
        }

        boolean worked = this.loc.setNewLoc(x,y); //set new location, save if worked

        if(worked){ //if move works, set moved to true
            this.hasMoved = true;
        }

        return worked; //return if worked
    }

    public boolean setRelativeLocation(int relX, int relY){

        if((relX == 0) && (relY == 0)){ //if positions are unchanged, return false and do nothing (if no move, don't move)
            return false;
        }

        boolean worked = this.loc.setNewRelativeLoc(relX,relY); //set new relative location, save if worked

        if(worked){ //if move works, set moved to true
            this.hasMoved = true;
        }

        return worked; //return if worked
    }

}
