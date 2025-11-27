package peekaboo;

import de.gurkenlabs.litiengine.gui.screens.Screen;
import java.awt.Color;
import java.awt.Graphics2D;

public class GameScreen extends Screen {

    public GameScreen() {
        super("game");
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
        g.setColor(Color.RED);
        g.drawString("Peekaboo", 50, 50);
    }
}
