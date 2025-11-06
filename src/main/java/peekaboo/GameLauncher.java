package peekaboo;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.sound.Sound;
import de.gurkenlabs.litiengine.entities.Entity;
import de.gurkenlabs.litiengine.graphics.RenderType;


public class GameLauncher {
    public static void main(String[] args) {
        launch(args); // This calls the method below
    }

    public static void launch(String[] args) {
        // This is where you initialize and start the game
        Game.init(args);
        Game.start();

        new Thread(() -> {
            try {
                Thread.sleep(500);
                Game.world().loadEnvironment("maps/Map_Party_Room.tmx");

                Sound ambient = Resources.sounds().get("audio/Menu Music.mp3");
                Game.audio().playMusic(ambient);

                Entity player;
                player = new Entity(100, 100);
                Game.world().environment().add(player);
                Game.world().camera().setFocus(player.getCenter());
                player.setRenderType(RenderType.OVERLAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
