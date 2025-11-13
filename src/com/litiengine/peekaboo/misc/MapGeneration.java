package com.litiengine.peekaboo.misc


import litiengine.litiengine.src.main.java.de.gurkenlabs.litiengine;
import litiengine.environment.tilemap.IMap.java.IMap;
import com.litiengine.peekaboo.environment.tilemap.MapOrientations;
import com.litiengine.peekaboo.resources.Maps.MapGenerator;
import com.litiengine.peekaboo.resources.Resources;

public final class MapGeneration {

  public static IMap generateRandomizedMap() {
      final String MAP_NAME = "my map";
      final int MAP_WIDTH = 50;
      final int MAP_HEIGHT = 50;
      final int TILE_WIDTH = 8;
      final int TILE_HEIGHT = 8;

      IMap map;

      // ------------- THIS IS WHERE ALL THE MAP GENERATION MAGIC HAPPENS ---------------
      // always generate maps in a try-with-resource block to ensure that the map is "finished" when the creation is done
      try (MapGenerator =Resources.maps(){
      generate(MapOrientations.ORTHOGONAL, MAP_NAME, MAP_WIDTH, MAP_HEIGHT, TILE_WIDTH, TILE_HEIGHT, Resources.tilesets().get("Map_Party_Room - 4K.tsx"));
      {
          return map;
      }}}