package peekaboo;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.resources.Resources;
import peekaboo.ui.MenuScreen;
import peekaboo.ui.ProfileViewer;

public class PeekabooMain {
    public static void main(String[] args) {
        Game.init(args);
        Resources.load("game.litidata");

        Game.screens().add(new MenuScreen());
        Game.screens().add(new IngameScreen());
        Game.screens().add(new ProfileViewer());
        Game.screens().add(new ComputerScreen());

        Game.screens().display(MenuScreen.NAME);
        Game.start();
    }
}