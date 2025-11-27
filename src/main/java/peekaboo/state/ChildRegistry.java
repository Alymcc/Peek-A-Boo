package peekaboo.state;

import java.util.List;

public class ChildRegistry {
    public static final List<ChildProfile> profiles = List.of(
            new ChildProfile("Jimmy", 6, "Male",
                    "Sporty, plays dodgeball, tall, twin, very serious",
                    "Ball Pit", "jimmy.png"),
            new ChildProfile("Lil Timmy", 6, "Male",
                    "Aggressive, football player, loves sliding, larger build",
                    "Slide", "lil_timmy.png"),
            new ChildProfile("Sally", 6, "Female",
                    "Loves trees, enjoys climbing, wears green bow, gets scared easily",
                    "Jungle Gym", "sally.png"),
            new ChildProfile("Bartholomew", 6, "Male",
                    "Nerdy, loves Star Wars, role play, emotional support water bottle, high anxiety",
                    "Bathroom", "bartholomew.png"),
            new ChildProfile("Gertrude", 6, "Female",
                    "Shy, playful, loves pizza and apple juice, allergic to peanuts, asthma",
                    "Party Room", "gertrude.png")
    );

    public static List<ChildProfile> getProfiles() {
        return profiles;
    }
}