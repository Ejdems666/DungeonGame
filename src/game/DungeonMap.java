package game;

import java.util.ArrayList;

/**
 * Created by Ejdems on 10/10/2016.
 */
public class DungeonMap {

    private ArrayList<ArrayList<Room>> rooms = new ArrayList<>();

    public DungeonMap() {

    }

    public void createDungeonMap() throws Exception {
        String[] map = new String[4];

        map[0] = "0,1rd,1ld,0";
        map[1] = "0,1rd,1ld,0";
        map[2] = "0,1rd,1ld,0";
        map[3] = "0,1rd,1ld,0";

        for (int z = 0; z < map.length; z++) {
            String[] mapRooms = map[z].split(",");
            rooms.add(new ArrayList<Room>());

            for (int y = 0; y < mapRooms.length; y++) {
                if (mapRooms[y].charAt(0) == 0) {
                    rooms.get(z).add(null);
                } 
                else        
                {
                    Room myRoom = new Room();  
                    for (int i = 1; i < mapRooms[y].length(); i++) { // charAt[0] is = to 1
                        switch(mapRooms[y].charAt(i)) 
                        {
                            case's':
                                myRoom.setSouth(true);
                                break;
                            case 'n':  
                                myRoom.setNorth(true);
                                break;      
                            case 'w':  
                                myRoom.setWest(true);
                                break;    
                            case 'e':  
                                myRoom.setEast(true);
                                break;  
                            default:
                                throw new Exception("wrong direction");
                        }
                    }
                    rooms.get(z).add(myRoom);
                }
        
            }
        }
    }  
}