package peekaboo;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.resources.Resources;
import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

import java.io.File;

public class PeekabooMain {

    private static EmbeddedMediaPlayer videoPlayer;

    public static void main(String[] args) {
        // Game metadata
        Game.info().setName("Peek-A-Boo");
        Game.info().setVersion("v1.0");

        // Init engine
        Game.init(args);
        Game.graphics().setBaseRenderScale(4f);

        // Load resources
        Resources.load("game.litidata");

        // Register screens
        Game.screens().add(new MenuScreen());
        Game.screens().add(new IngameScreen());

        // Start the game loop
        Game.start();

        // Play intro video, then show menu
        playIntro();
    }

    private static void playIntro() {
        MediaPlayerFactory factory = new MediaPlayerFactory();
        videoPlayer = factory.mediaPlayers().newEmbeddedMediaPlayer();

        videoPlayer.videoSurface().set(
                factory.videoSurfaces().newVideoSurface(Game.window().getRenderComponent())
        );

        // Resolve the resource path properly
        java.net.URL introUrl = Resources.getLocation("video/intro.mp4");
        if (introUrl != null) {
            File intro = new File(introUrl.getPath());
            System.out.println("Looking for intro at: " + intro.getAbsolutePath());

            if (intro.exists()) {
                videoPlayer.media().play(intro.getAbsolutePath());

                // Timed fallback: stop after 12 seconds
                new Thread(() -> {
                    try {
                        Thread.sleep(12000);
                    } catch (InterruptedException ignored) {}
                    stopVideoAndShowMenu();
                }).start();
            } else {
                System.out.println("Intro video not found, skipping to menu.");
                stopVideoAndShowMenu();
            }
        } else {
            System.out.println("Intro video resource not found, skipping to menu.");
            stopVideoAndShowMenu();
        }
    }

    private static void stopVideoAndShowMenu() {
        if (videoPlayer != null) {
            videoPlayer.controls().stop();
            videoPlayer.release();
            videoPlayer = null;
        }

        Game.screens().display(MenuScreen.NAME);
    }
}
