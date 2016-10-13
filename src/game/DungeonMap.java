package game;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ejdems on 10/10/2016.
 */
public class DungeonMap {

    private ArrayList<ArrayList<Room>> rooms = new ArrayList<>();
    private Random random = new Random();

    public DungeonMap() {

    }

    public void createDungeonMap() {
        // TODO: implement reading from a file
        String[] map = new String[4];
        map[0] = "0,1--100000-note,1-ws,1-es";
        map[1] = "0,1-es,1-ws,0";
        map[2] = "0,1-es,1-ws,0";
        map[3] = "0,1-en,1-wn,0";

        for (int x = 0; x < map.length; x++) {
            String[] roomMappers = map[x].split(",");
            rooms.add(new ArrayList<Room>());
            for (int y = 0; y < roomMappers.length; y++) {
                Room room = getRoom(roomMappers[y]);
                room.setPoint(x,y);
                rooms.get(x).add(room);
            }
        }
        System.out.print(rooms);
    }

    private Room getRoom(String roomMapper) {
        if (roomMapper.charAt(0) == '0') {
            return null;
        }
        String[] extrasMapper = roomMapper.substring(2).split("-");
        float gold = getGold(extrasMapper);
        String note = getNote(extrasMapper);
        Room room = new Room(gold,note);
        try {
            setDirections(extrasMapper[0], room);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return room;

    }

    private float getGold(String[] extrasMapper) {
        if (extrasMapper.length >= 2 && !extrasMapper[1].isEmpty()) {
            return Float.parseFloat(extrasMapper[1]);
        }
        return random.nextInt(10);
    }

    private String getNote(String[] extrasMapper) {
        if (extrasMapper.length >= 3) {
            return extrasMapper[2];
        }
        return "";
    }

    private void setDirections(String directionMapper, Room room) throws Exception {
        for (int i = 0; i < directionMapper.length(); i++) {
            char inputDirection = directionMapper.charAt(i);
            boolean correct = false;
            for (Room.Direction direction : Room.Direction.values()) {
                if (direction.getValue() == inputDirection) {
                    room.setDirection(direction);
                    correct = true;
                }
            }
            if (!correct) {
                throw new Exception("Wrong direction: " + inputDirection);
            }
        }
    }
}