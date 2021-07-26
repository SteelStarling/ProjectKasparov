package com.mygdx.projectkasparov;

public final class Location {

    private int xPos; //stores for x and y position
    private int yPos;

    /**
     * Setup Location object with x and y coordinates
     * @param x  x coord for location
     * @param y  y coord for location
     */
    public Location(int x, int y){
        this.xPos = x; //save x and y
        this.yPos = y;
    }

    /**
     * Set Location object with new x and y coordinates
     * @param x  x coord for location
     * @param y  y coord for location
     *
     * @return  boolean stating if the new location has been saved
     */
    public boolean setNewLoc(int x, int y){
        if(x < 0 || x >= Constants.BoardSize){
            return false; //return false if out of bounds
        }
        if(x < 0 || x >= Constants.BoardSize){
            return false; //return false if out of bounds
        }
        this.xPos = x; //save new x and y
        this.yPos = y;
        return true; //return true if in bounds
    }

    /**
     * Set Location object with new x and y coordinates, relative to the current position
     * @param xRel  x coord for location relative to the current position
     * @param yRel  y coord for location relative to the current position
     *
     * @return  boolean stating if the new location has been saved
     */
    public boolean setNewRelativeLoc(int xRel, int yRel){
        int x = this.xPos + xRel; //setup new x and y values to check if out of bounds
        int y = this.yPos + yRel;
        return this.setNewLoc(x,y); //pass new values into setNewLoc to actually set new loc and check space validity
    }

    /**
     * Method to get x position from a location
     * @return int for x position
     */
    public int getXPos(){
        return this.xPos;
    }

    /**
     * Method to get y position from a location
     * @return int for y position
     */
    public int getYPos(){
        return this.yPos;
    }
}
