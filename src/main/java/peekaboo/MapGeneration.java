package peekaboo;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.environment.Environment;
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.environment.tilemap.IMap;
import de.gurkenlabs.litiengine.entities.Spawnpoint;
import peekaboo.entities.Player;

public class MapGeneration {
    public static Environment loadPlayroomMap() {

        IMap playgroundMap = Resources.maps().get("playground");
        Environment map = new Environment(playgroundMap);

        Player player = Player.instance(); // use singleton instead of new Player()

        // Find spawnpoint named "Start"
        Spawnpoint start = map.getSpawnpoints().stream()
                .filter(spawn -> "Start".equals(spawn.getName()))
                .findFirst()
                .orElse(null);

        if (start != null) {
            player.setLocation(start.getLocation());
        }

        map.add(player);

        // Attach player update loop
        Game.loop().attach(player); // calls player.update() each frame

        Game.world().camera().setClampToMap(true);

        //Play background music when map loads
        Game.audio().playMusic(Resources.sounds().get("music/Office_Music.mp3"));

        return map;
    }
}

