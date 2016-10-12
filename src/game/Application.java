package game;

/**
 * Created by Ejdems on 12/10/2016.
 */
public class Application {
    public static void main(String[] args) {
        DungeonGame game = new DungeonGame();
        PlayerFactory playerFactory = new PlayerFactory();
        DungeonMap map = new DungeonMap();
        game.run(playerFactory,map);
    }
}
