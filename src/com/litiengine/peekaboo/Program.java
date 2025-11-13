package com.litiengine.peekaboo;

import com.litiengine.peekaboo.misc.MapGeneration;
import com.litiengine.peekaboo.screens.IngameScreen;
import com.de.gurkenlabs.litiengine.Game;
import com.de.gurkenlabs.litiengine.environment.tilemap.IMap;
import com.de.gurkenlabs.litiengine.resources.Resources;
import java.awt.Image;

/**
 * This class provides the main entry point for the LITIengine game "GURK NUKEM".
 */
public class Program {

  /**
   * The main entry point for the Game.
   * 
   * @param args
   *          The command line arguments.
   */
  public static void main(String[] args) {
    // set meta information about the game
    Game.info().setName("Peek A Boo");
    Game.info().setSubTitle("");
    Game.info().setVersion("v0.0.2");
    Game.info().setWebsite("https://github.com/Alymcc/Peek-A-Boo.git");
    Game.info().setDescription("A 2D platformer with horror elements made in the LITIengine");

    // init the game infrastructure
    Game.init(args);

    // set the icon for the game (this has to be done after initialization because the ScreenManager will not be present otherwise)
    Game.window().setIcon(Resources.images().get("icon.png"));
    Game.graphics().setBaseRenderScale(4f);

    // load data from the utiLITI game file
    Resources.load("game.litidata");

    PlayerInput.init();
    GurkNukemLogic.init();

    // add the screens that will help you organize the different states of your game
    Game.screens().add(new IngameScreen());

    // load the first level (resources for the map were implicitly loaded from the game file)
    Game.world().loadEnvironment("Map_Party_Room.png");

    // load a demo map for map generation
    IMap map = MapGeneration.generateRandomizedMap();
    // Game.world().loadEnvironment(map);

    Game.start();
  }
}