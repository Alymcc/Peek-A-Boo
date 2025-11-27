package peekaboo;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.entities.Spawnpoint;
import de.gurkenlabs.litiengine.graphics.Camera;
import peekaboo.entities.Player;

public final class PeekabooLogic {

    private PeekabooLogic() {
        // prevent instantiation
    }

    public static void init() {
        // Create a camera
        Camera camera = new Camera();
        camera.setClampToMap(true);
        Game.world().setCamera(camera);

        // Update focus every frame so the camera follows the player
        Game.loop().attach(() -> camera.setFocus(Player.instance().getCenter()));

        // Gravity (optional, only if you want platformer physics)
        Game.world().setGravity(120);

        // When a level loads, spawn the player at the spawnpoint named "Start"
        Game.world().onLoaded(env -> {
            Spawnpoint start = env.getSpawnpoint("Start"); // capital S
            if (start != null) {
                start.spawn(Player.instance());
            } else {
                // fallback: center player if no spawnpoint
                double centerX = env.getMap().getSizeInPixels().getWidth() / 2.0;
                double centerY = env.getMap().getSizeInPixels().getHeight() / 2.0;
                Player.instance().setLocation(centerX, centerY);
            }
        });
    }
}
