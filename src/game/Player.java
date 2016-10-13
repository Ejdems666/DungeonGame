package game;

/**
 * Created by Ejdems on 10/10/2016.
 */
public class Player {
    private String name;
    private float gold;
    private Room currentRoom;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, float gold) {
        this.name = name;
        this.gold = gold;
    }

    public void addGold(float gold) {
        this.gold += gold;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
