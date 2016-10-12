package game;

/**
 * Created by Ejdems on 12/10/2016.
 */
public class Application {
    public static void main(String[] args) {
        PlayerFactory playerFactory = new PlayerFactory();
        DungeonMap map = new DungeonMap();
        DungeonGame game = new DungeonGame();
        game.run(playerFactory,map);
    }
}
