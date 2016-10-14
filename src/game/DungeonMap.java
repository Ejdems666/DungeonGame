package game;

import libs.Output;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ejdems on 10/10/2016.
 */
public class DungeonMap {

    private ArrayList<ArrayList<Room>> rooms = new ArrayList<>();
    private Random random = new Random();
    private Output output = new Output();

    public void createDungeonMap() {
        // TODO: implement reading from a file
        String[] map = new String[4];
        map[0] = "0,1-e,1-ws,1-ws";
        map[1] = "1-s,0,1--10000-GOAL ROOM,1-ns";
        map[2] = "1-sn,1-es,1-we,1-nws";
        map[3] = "1-ne,1-enw,1-wn,1-w";

        for (int x = 0; x < map.length; x++) {
            String[] roomsMapper = map[x].split(",");
            rooms.add(new ArrayList<Room>());
            for (int y = 0; y < roomsMapper.length; y++) {
                if (roomsMapper[y].charAt(0) == '0') {
                    rooms.get(x).add(null);
                } else {
                    Room room = getRoom(roomsMapper[y]);
                    room.setPoint(x, y);
                    rooms.get(x).add(room);
                }
            }
        }
    }

    private Room getRoom(String roomMapper) {
        String[] extrasMapper = roomMapper.substring(2).split("-");
        float gold = getGold(extrasMapper);
        String note = getNote(extrasMapper);
        Room room = new Room(gold, note);
        try {
            setDirections(extrasMapper[0], room);
        } catch (Exception e) {
           output.crashMessage(e);
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

    public Room getRoom(Room originalRoom, String direction) {
        int x = originalRoom.x;
        int y = originalRoom.y;
        switch (direction) {
            case "w":
                y--;
                break;
            case "n":
                x--;
                break;
            case "e":
                y++;
                break;
            case "s":
                x++;
                break;
        }
        return rooms.get(x).get(y);
    }

    public Room getStartingRoom() {
        int x;
        int y;
        Room room = null;
        while(room == null || room.isDeadEnd()) {
            x = random.nextInt(rooms.size()-1);
            y = random.nextInt(rooms.get(x).size()-1);
            room = rooms.get(x).get(y);
        }
        return room;
    }
}