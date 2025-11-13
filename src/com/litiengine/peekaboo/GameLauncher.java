package com.litiengine.peekaboo;

import /Peek-A-Boo.Game;
import .resources.Resources;
import com.litiengine.peekaboo.sound.Sound;

public class GameLauncher {
    public static void main(String[] args) {
        launch(args);
    }

    public static void launch(String[] args) {
        Game.init(args);
        Game.start();

        new Thread(() -> {
            try {
                Thread.sleep(500); // short delay to ensure loop is running
                Game.world().loadEnvironment("maps/Map_Party_Room - 4K.tsx");
                Sound ambient = Resources.sounds().get("audio/Menu Music.mp3");
                Game.audio().playMusic(ambient);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}