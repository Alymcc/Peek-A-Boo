package peekaboo;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.environment.Environment;
import de.gurkenlabs.litiengine.environment.tilemap.IMap;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import de.gurkenlabs.litiengine.resources.Resources;
import peekaboo.entities.Player;

public class IngameScreen extends GameScreen {
    public static final String NAME = "INGAME"; // match PeekabooMain

    public IngameScreen() {
        super(NAME);
    }

    @Override
    public void prepare() {

        IMap map = Resources.maps().get("playground");

        //Seeing where it is failing
        if (map == null) {
            System.err.println("Map not found in resources!");
            return;
        }

        Environment playground = new Environment(map);

        Player player = new Player();
        if (playground.getSpawnpoint("Start") != null) {
            player.setLocation(playground.getSpawnpoint("Start").getLocation());
        } else {
            player.setLocation(64, 64);
        }
        playground.add(player);

        Game.world().camera().setFocus(player.getCenter());
        Game.world().camera().setClampToMap(true);

        Game.world().loadEnvironment(playground);
    }
}
