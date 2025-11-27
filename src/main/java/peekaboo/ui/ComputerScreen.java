package peekaboo.ui;

import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.Game;

import java.awt.*;

public class ComputerScreen extends Screen {
    public static final String NAME = "COMPUTER-SCREEN";
    private Image laptopScreen;

    public ComputerScreen() {
        super(NAME);
        laptopScreen = Resources.images().get("sprites/items/Laptop_Screen_.png");
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);

        if (laptopScreen != null) {
            // Draw the laptop screen image centered
            int centerX = Game.window().getResolution().getWidth() / 2;
            int centerY = Game.window().getResolution().getHeight() / 2;
            g.drawImage(laptopScreen,
                    centerX - laptopScreen.getWidth(null) / 2,
                    centerY - laptopScreen.getHeight(null) / 2,
                    null);
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Press ESC to return", 50, 50);
    }

    @Override
    public void prepare() {
        // ESC returns to Menu
        Game.loop().input().keyboard().onKeyPressed(KeyEvent.VK_ESCAPE, e -> {
            Game.screens().display(MenuScreen.NAME);
        });
    }
}