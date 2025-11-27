package peekaboo.ui;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.resources.Resources;
import peekaboo.state.ChildProfile;
import peekaboo.state.ChildRegistry;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ProfileViewer extends Screen {
    public static final String NAME = "PROFILE-VIEWER";
    private int currentIndex = 0;

    public ProfileViewer() {
        super(NAME);
    }

    public void setCurrentIndex(int index) {
        this.currentIndex = index;
    }

    @Override
    public void prepare() {
        // Arrow key navigation
        Game.loop().input().keyboard().onKeyPressed(KeyEvent.VK_RIGHT, e -> nextProfile());
        Game.loop().input().keyboard().onKeyPressed(KeyEvent.VK_LEFT, e -> previousProfile());

        // Optional: ESC to go back to menu
        Game.loop().input().keyboard().onKeyPressed(KeyEvent.VK_ESCAPE, e -> {
            Game.screens().display(MenuScreen.NAME);
        });
    }

    @Override
    public void render(Graphics2D g) {
        ChildProfile profile = ChildRegistry.getProfiles().get(currentIndex);

        // Load the child’s unique PNG from resources/ui/AvatarFile
        Image avatar = Resources.images().get("ui/" + profile.getAvatarFile());
        if (avatar != null) {
            g.drawImage(avatar, 100, 160, null);
        }

        // Draw profile text
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Name: " + profile.getName(), 100, 100);
        g.drawString("Description: " + profile.getDescription(), 100, 130);
        g.drawString("Location: " + profile.getLocation(), 100, 160);
        g.drawString("Age: " + profile.getAge() + " | Gender: " + profile.getGender(), 100, 190);
    }

    private void nextProfile() {
        currentIndex = (currentIndex + 1) % ChildRegistry.getProfiles().size();
    }

    private void previousProfile() {
        currentIndex = (currentIndex - 1 + ChildRegistry.getProfiles().size()) % ChildRegistry.getProfiles().size();
    }
}