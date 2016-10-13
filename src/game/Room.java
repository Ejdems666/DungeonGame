package game;

/**
 * Created by Ejdems on 10/10/2016.
 */
public class Room {
    private String passages = "";

    float gold;
    String note;
    int visit=0;

    Room(float gold, String note) {
        this.gold = gold;
        if(!note.isEmpty()) {
            this.note = note;
        } else {
            this.note = "Random note";
        }
    }

    public void setDirection(Direction direction) {
        this.passages += direction.getValue();
    }

    public boolean hasPassageTo(char direction) {
        return passages.indexOf(direction) >= 0;
    }

    public String toString() {
        return note+gold+passages;
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

    public void visit() {
        visit++;
    }
    
}
