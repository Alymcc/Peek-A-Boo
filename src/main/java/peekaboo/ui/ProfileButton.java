package peekaboo.ui;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.ImageComponent;
import de.gurkenlabs.litiengine.resources.Resources;

public class ProfileButton extends ImageComponent {
    public ProfileButton(float x, float y) {
        // Use the furniture resource files.png
        super(x, y, Resources.images().get("furniture/files.png"));
    }

    @Override
    public void clicked() {
        // When clicked, open the ProfileViewer at the first profile
        ProfileViewer viewer = (ProfileViewer) Game.screens().get(ProfileViewer.NAME);
        viewer.setCurrentIndex(0);
        Game.screens().display(ProfileViewer.NAME);
    }
}