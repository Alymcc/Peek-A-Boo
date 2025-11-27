package peekaboo;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.Direction;
import de.gurkenlabs.litiengine.input.Input;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import peekaboo.entities.Player;

public final class PlayerInput {
    private PlayerInput() {}

    public static void init() {
        // ESC = quit game
        Input.keyboard().onKeyPressed(KeyEvent.VK_ESCAPE, e -> System.exit(0));

        // W = up
        Input.keyboard().onKeyPressed(KeyEvent.VK_W, e -> {
            Player.instance().setAngle(Direction.UP.toAngle());
        });

        // S = down
        Input.keyboard().onKeyPressed(KeyEvent.VK_S, e -> {
            Player.instance().setAngle(Direction.DOWN.toAngle());
        });

        // A = left
        Input.keyboard().onKeyPressed(KeyEvent.VK_A, e -> {
            Player.instance().setAngle(Direction.LEFT.toAngle());
        });

        // D = right
        Input.keyboard().onKeyPressed(KeyEvent.VK_D, e -> {
            Player.instance().setAngle(Direction.RIGHT.toAngle());
        });
    }
}
