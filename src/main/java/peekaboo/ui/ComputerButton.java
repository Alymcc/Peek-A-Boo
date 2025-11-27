package peekaboo.ui;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.ImageComponent;
import de.gurkenlabs.litiengine.resources.Resources;

public class ComputerButton extends ImageComponent {
    public ComputerButton(float x, float y) {
        // Use the furniture resource computer.png
        super(x, y, Resources.images().get("furniture/computer.png"));
    }

    @Override
    public void clicked() {
        // When clicked, open the ComputerScreen
        Game.screens().display(ComputerScreen.NAME);
    }
}
