//package peekaboo.audio;

//import de.gurkenlabs.litiengine.Game;
//import de.gurkenlabs.litiengine.environment.Environment;
//import de.gurkenlabs.litiengine.resources.Resources;
//import de.gurkenlabs.litiengine.sound.Sound;
//import peekaboo.entities.Player;

//import java.awt.geom.Point2D;

//public class RoomMusic {
    //private static String currentTrack;

    //public static void attach(Environment map) {
        //Game.world().onEntityEntered(e -> {
            //if (e instanceof Player) {
                // Start music based on player location
                //map.getObjects().forEach(obj -> {
                    //if (obj.getBoundingBox().intersects(e.getBoundingBox())) {
                        //String musicFile = obj.getStringValue("music");
                       // if (musicFile != null && !musicFile.equals(currentTrack)) {
                            // Fade out the old track if one is playing
                         //   if (currentTrack != null) {
                       //         Resources.sounds().fadeOutMusic(2000); // 2 second fade
                      //      }

                            // Start the new track
                    //        Resources.sounds().playMusic("audio/" + musicFile, true);
                   //         currentTrack = musicFile;
                 //       }

                        // Ambient sound (optional property in Tiled)
                    //    String ambientFile = obj.getStringValue("ambient");
                   //     if (ambientFile != null) {
                  //          Sound ambient = Resources.sounds().get("audio/" + ambientFile);
                 //           Point2D location = obj.getLocation();
                  //          Game.audio().playSound(ambient, location);
                //        }
            //        }
        //        });
      //      }
 //       });
 //   }
//}
