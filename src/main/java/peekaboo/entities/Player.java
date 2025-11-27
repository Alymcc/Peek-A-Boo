package peekaboo.entities;

import java.awt.geom.Point2D;

import de.gurkenlabs.litiengine.IUpdateable;
import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.entities.EntityInfo;
import de.gurkenlabs.litiengine.entities.MovementInfo;
import de.gurkenlabs.litiengine.entities.CollisionInfo;
import de.gurkenlabs.litiengine.input.PlatformingMovementController;
import de.gurkenlabs.litiengine.graphics.animation.Animation;
import de.gurkenlabs.litiengine.physics.IMovementController;
import de.gurkenlabs.litiengine.resources.Resources;

@EntityInfo(width = 16, height = 32)
@MovementInfo(velocity = 70)
@CollisionInfo(collisionBoxWidth = 16, collisionBoxHeight = 16, collision = true)
public class Player extends Creature implements IUpdateable {

    public static Player instance;
    private PlatformingMovementController<Player> controller;

    public Player() {
        super("player");

        // Register idle animations (looping)
        this.animations().add(new Animation("idle-up", Resources.spritesheets().get("pab-idle-up"), true));
        this.animations().add(new Animation("idle-down", Resources.spritesheets().get("pab-idle-down"), true));
        this.animations().add(new Animation("idle-right", Resources.spritesheets().get("player_idle_right"), true));

// Register walk animations (looping)
        this.animations().add(new Animation("walk-left", Resources.spritesheets().get("Player-walk-left"), true));
        this.animations().add(new Animation("walk-right", Resources.spritesheets().get("Player-walk-right"), true));
    }

    public static Player instance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    @Override
    protected IMovementController createMovementController() {
        this.controller = new PlatformingMovementController<>(this);
        return this.controller;
    }

    public PlatformingMovementController<Player> getController() {
        return this.controller;
    }

    @Override
    public void update() {

        double speed = Math.hypot(getX(),getY());

        if (speed == 0) {
            switch (this.getFacingDirection()) {
                case UP:
                    this.animations().play("idle-up");
                    break;
                case DOWN:
                    this.animations().play("idle-down");
                    break;
                case RIGHT:
                    this.animations().play("idle-right");
                    break;
                case LEFT:
                    this.animations().play("walk-left"); // fallback if no idle-left
                    break;
                default:
                    this.animations().play("idle-down");
                    break;
            }
        }
    }
}
