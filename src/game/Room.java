package game;

/**
 * Created by Ejdems on 10/10/2016.
 */
public class Room {
    private String passages = "";
    float gold;
    String note;
    int visit = 0;
    int x;
    int y;
//    private static NoteGenerator noteGenerator = new NoteGenerator();

    Room(float gold, String note) {
        this.gold = gold;
        if(!note.isEmpty()) {
            this.note = note;
        } else {
//            this.note = noteGenerator.getRandomNote();
            this.note = "random note";
        }
    }

    public String getPassages() {
        return passages;
    }

    public boolean isDeadEnd() {
        return passages.equals("");
    }

    public void setDirection(Direction direction) {
        this.passages += direction.getValue();
    }

    public boolean hasPassageTo(char direction) {
        return passages.indexOf(direction) >= 0;
    }

    public String toString() {
        return "note: " + note + "\ngold: " + gold + "\npossible passages:" + passages;
    }

    public void visit() {
        visit++;
    }

    public void setPoint(int x, int y) {
        this.x = x;
        this.y = y;
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
