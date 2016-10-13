package game;

import libs.form.Form;

/**
 * Created by Ejdems on 12/10/2016.
 */
public class Application {
    private Form form = new Form();
    private Player player;

    public void run(PlayerFactory playerFactory, DungeonMap map){
        player = playerFactory.getPlayer();
        map.createDungeonMap();
        player.setCurrentRoom(map.getStartingRoom());
        createForm();
        while(true) {
            setPossibleDirections(player.getCurrentRoom());
            form.askForAllFields();
            switch (form.get("direction")) {
                case "w":
                    player.setCurrentRoom(map.getRoom(player.getCurrentRoom(), Room.Direction.WEST));
                    break;
                case "n":
                    player.setCurrentRoom(map.getRoom(player.getCurrentRoom(), Room.Direction.NORTH));
                    break;
                case "e":
                    player.setCurrentRoom(map.getRoom(player.getCurrentRoom(), Room.Direction.EAST));
                    break;
                case "s":
                    player.setCurrentRoom(map.getRoom(player.getCurrentRoom(), Room.Direction.SOUTH));
                    break;
            }
            System.out.println(player.getCurrentRoom());
        }
    }

    private void setPossibleDirections(Room currentRoom) {
        String[] possibleDirections = currentRoom.getPassages();
        form.getInput("direction").setAllowedValues(possibleDirections);
    }

    public void createForm() {
        form.addText("direction","Insert direction");
    }
}
