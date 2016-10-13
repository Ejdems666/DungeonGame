package game;

/**
 * Created by Ejdems on 10/10/2016.
 */
public class Room {
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

    public void setDirection(Direction direction) {
        this.passages += direction.getValue();
    }

    public boolean hasPassageTo(char direction) {
        return passages.indexOf(direction) >= 0;
    }

    public String toString() {
        return "Room with this gold: "+gold;
    }

    public enum Direction {
        NORTH('n'), SOUTH('s'), WEST('w'), EAST('e');

        char value;
        Direction(char value) {
            this.value = value;
        }

        public char getValue() {
            return  value;
        }
    }
}
