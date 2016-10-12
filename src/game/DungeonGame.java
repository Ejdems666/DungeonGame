package game;

import libs.form.Form;

/**
 * Created by Ejdems on 10/10/2016.
 */
public class DungeonGame {
    public static void main(String[] args) {
        PlayerFactory playerFactory = new PlayerFactory();
        DungeonMap map = new DungeonMap();
        Application app = new Application();
        app.run(playerFactory,map);
    }
}
