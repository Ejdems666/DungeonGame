package game;

/**
 * Created by Ejdems on 10/10/2016.
 */
public class Room {
    final int NORTH = 1;
    final int SOUTH = 2;
    final int EAST = 4;
    final int WEST = 8;

    private float passages = 0;

    float gold;
    String note;

    Room(float gold) {
        this.gold = gold;
        this.note = "Random note"; //TODO: make 'random' note generator
    }

    Room(float gold, String note) {
        this.gold = gold;
        this.note = note;
    }

    public void setDirection(int direction) {
        this.passages += direction;
    }

    public boolean hasPassageTo(int direction) {
        if(passages < direction) {
            return false;
        } else if(passages == direction) {
            return true;
        }
        return passages/direction <= 2;
    }

    public String toString() {
        return "Room with this gold: "+gold;
    }
}
