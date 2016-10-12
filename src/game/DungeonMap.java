package game;

import org.jetbrains.annotations.Nullable;

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
        map[0] = "0,1-42-1000,1-82,0";
        map[1] = "0,1-42,1-82,0";
        map[2] = "0,1-42,1-82,0";
        map[3] = "0,1-42,1-82,0";

        for (int i = 0; i < map.length; i++) {
            String[] roomMappers = map[i].split(",");
            rooms.add(new ArrayList<Room>());
            for (int ii = 0; ii < roomMappers.length; ii++) {
                rooms.get(i).add(getRoom(roomMappers[ii]));
            }
        }
        System.out.print(rooms);
    }

    @Nullable
    private Room getRoom(String roomMapper) {
        if (roomMapper.charAt(0) == '0') {
            return null;
        } else {
            String[] extrasMapper = roomMapper.substring(2).split("-");
            Room room = createRoom(extrasMapper);
            return room;
        }
    }

    private Room createRoom(String[] extrasMapper) {
        float gold;
        if(extrasMapper.length >= 2) {
            gold = Float.parseFloat(extrasMapper[1]);
        } else {
            gold = random.nextInt(10);
        }
        Room room = new Room(gold);
        setDirections(extrasMapper[0], room);
        return room;
    }

    private void setDirections(String directionMapper, Room room) {
        for (int i = 0; i < directionMapper.length(); i++) {
            int direction = Integer.parseInt(directionMapper.substring(i,i+1));
            room.setDirection(direction);
        }
    }
}