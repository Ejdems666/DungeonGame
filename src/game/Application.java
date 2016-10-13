package game;

import game.exceptions.DeadEndException;
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
            try {
                setPossibleDirections(player.getCurrentRoom());
            } catch (DeadEndException e) {
                System.out.println("dead end");
                break;
            }
            form.askForAllFields();
            player.setCurrentRoom(
                    map.getRoom(player.getCurrentRoom(), form.get("direction"))
            );
            System.out.println(player.getCurrentRoom());
        }
        System.out.println("game over");
    }

    private void setPossibleDirections(Room currentRoom) throws DeadEndException {
        String[] possibleDirections = currentRoom.getPassages();
        if(possibleDirections.length == 1 && possibleDirections[0].equals("")) {
            throw new DeadEndException();
        }
        form.getInput("direction").setAllowedValues(possibleDirections);
    }

    public void createForm() {
        form.addText("direction","Insert direction");
    }
}
