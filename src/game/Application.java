package game;

import game.exceptions.DeadEndException;
import libs.Output;
import libs.form.Form;

/**
 * Created by Ejdems on 12/10/2016.
 */
public class Application {
    private Form form = new Form();
    private Output output = new Output();
    private Player player;

    public void run(PlayerFactory playerFactory, DungeonMap map){
        player = playerFactory.getPlayer();
        map.createDungeonMap();
        player.setCurrentRoom(map.getStartingRoom());
        createForm();
        while(true) {
            output.separator("current room:\n" + player.getCurrentRoom() + "\n");
            try {
                setPossibleDirections(player.getCurrentRoom());
            } catch (DeadEndException e) {
                output.separator("game over");
                output.crashMessage(e);
            }
            form.askForAllFields();
            player.setCurrentRoom(
                    map.getRoom(player.getCurrentRoom(), form.get("direction"))
            );
        }
    }

    private void setPossibleDirections(Room currentRoom) throws DeadEndException {
        String possibleDirections = currentRoom.getPassages();
        if(possibleDirections.equals("")) {
            throw new DeadEndException("dead end, no possible passages!");
        }
        form.getInput("direction").setAllowedValues(possibleDirections.split(""));
    }

    public void createForm() {
        form.addText("direction","Insert direction");
    }
}
