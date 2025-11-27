package peekaboo.ui;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.graphics.ImageRenderer;
import de.gurkenlabs.litiengine.input.Input;
import peekaboo.IngameScreen;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;

public class MenuScreen extends Screen {
    public static final String NAME = "MENU";
    private BufferedImage background;

    public MenuScreen() {
        super(NAME);
        background = Resources.images().get("ui/main-menu.png");
    }

    @Override
    public void prepare() {
        super.prepare();

        // ENTER starts the game
        Input.keyboard().onKeyPressed(KeyEvent.VK_ENTER, e -> {
            Game.screens().display(IngameScreen.NAME);
        });

        // Add files.png button to open ProfileViewer
        ProfileButton button = new ProfileButton(200, 300);
        this.getComponents().add(button);
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);

        if (background != null) {
            ImageRenderer.render(g, background, 0, 0);
        }

        g.drawString("Press ENTER to start", 50, 70);
    }
}