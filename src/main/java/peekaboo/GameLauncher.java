package peekaboo;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.sound.Sound;
import de.gurkenlabs.litiengine.sound.Music;

public class GameLauncher {
  public static void launch() {
   
    Game.world().loadEnvironment("/Assets/maps/Temp img.PNG");

    Music ambient = Resources.music().get("Assets/audio/ES_Goth Christmas - par.wav");
    Game.audio().playMusic(ambient);


    Sound creak = Resources.sounds().get("Assets/audio/ES_Spooky Door Squeaking 02 - Epidemic Sound.wav");
    Game.audio().playSound(creak);
  }
}
