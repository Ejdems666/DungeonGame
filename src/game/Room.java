package game;

/**
 * Created by Ejdems on 10/10/2016.
 */
public class Room {
    final int NORTH = 'n';
    final int SOUTH = 's';
    final int EAST = 'e';
    final int WEST = 'w';

    private String passages = "";

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

    public void setDirection(char direction) {
        this.passages += direction;
    }

    public boolean hasPassageTo(char direction) {
        return passages.indexOf(direction) >= 0;
    }

    public String toString() {
        return "Room with this gold: "+gold;
    }
}
