package game;

/**
 * Created by Ejdems on 10/10/2016.
 */
public class Room {
    
    boolean north = false;
    boolean south = false;    
    boolean east = false;    
    boolean west = false; 
    int goldReserve;
    
    
    
    
    Room(){

    }//Room

    public void setNorth(boolean north) {
        this.north = north;
    }

    public void setSouth(boolean south) {
        this.south = south;
    }

    public void setEast(boolean east) {
        this.east = east;
    }

    public void setWest(boolean west) {
        this.west = west;
    }

    public boolean isNorth() {
        return north;
    }

    public boolean isSouth() {
        return south;
    }

    public boolean isEast() {
        return east;
    }

    public boolean isWest() {
        return west;
    }
    
    
}// class
