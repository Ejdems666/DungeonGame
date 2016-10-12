package game;

/**
 * Created by Ejdems on 12/10/2016.
 */
public class Application {
    private Player player;

    public void run(PlayerFactory playerFactory, DungeonMap map){
        player = playerFactory.getPlayer();
        map.createDungeonMap();
    }
}
