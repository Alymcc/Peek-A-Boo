package peekaboo;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.sound.Sound;

public class GameLauncher {
  public static void launch() {
    String mapPath = "maps/Temp_img.PNG";
    String soundPath = "audio/ES_6oth_Christmas_-_par.wav";

    Game.world().loadEnvironment(mapPath);
    Sound ambient = Resources.sounds().get(soundPath);
    Game.audio().playMusic(ambient);
  }
}
