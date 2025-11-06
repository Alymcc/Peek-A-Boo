package peekaboo;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.sound.Sound;

public class GameLauncher {
    public static void main(String[] args) {
        launch();
    }

    public static void launch() {
        String mapPath = "Assets/maps/Map_Party_Room.png";
        String soundPath = "Assets/audio/Menu Music.mp3";

        Game.world().loadEnvironment(mapPath);
        Sound ambient = Resources.sounds().get(soundPath);
        Game.audio().playMusic(ambient);
    }
}