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
        map[0] = "0,1-es-1000,1-ws,0";
        map[1] = "0,1-es,1-ws,0";
        map[2] = "0,1-es,1-ws,0";
        map[3] = "0,1-en,1-wn,0";

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
            float gold = getGold(extrasMapper);
            Room room = new Room(gold);
            try {
                setDirections(extrasMapper[0], room);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
            return room;
        }
    }

    private float getGold(String[] extrasMapper) {
        if(extrasMapper.length >= 2) {
            return Float.parseFloat(extrasMapper[1]);
        }
        return random.nextInt(10);
    }

    private void setDirections(String directionMapper, Room room) throws Exception {
        for (int i = 0; i < directionMapper.length(); i++) {
            char direction = directionMapper.charAt(i);
            boolean correct = false;
            for (Room.Direction d : Room.Direction.values()) {
                if(d.getValue() == direction) {
                    room.setDirection(d);
                    correct = true;
                }
            }
            if(!correct) {
                throw new Exception("Wrong direction: "+direction);
            }
        }
    }
}