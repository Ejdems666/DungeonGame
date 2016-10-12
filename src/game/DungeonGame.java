package game;

import libs.form.Form;

/**
 * Created by Ejdems on 10/10/2016.
 */
public class DungeonGame {
    private Player player;

    public void run(PlayerFactory playerFactory, DungeonMap map){
        player = playerFactory.getPlayer();
        map.createDungeonMap();
    }
}
