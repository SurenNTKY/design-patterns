package Directors;

import Builders.GoalKeeperCardBuilder;
import Builders.PlayerCardBuilder;
import Models.GoalKeeperCard;
import Models.PlayerCard;

public class Director {
    public PlayerCard createPlayer(String name, String nat,
                                      int shooting, int pace, int dribbling,
                                      int physic, int passing, int defending) {
        return new PlayerCardBuilder()
                .withName(name)
                .withNationality(nat)
                .withShooting(shooting)
                .withPace(pace)
                .withDribbling(dribbling)
                .withPhysic(physic)
                .withPassing(passing)
                .withDefending(defending)
                .build();
    }

    public GoalKeeperCard createGoalKeeper(String name, String nat,
                                          int diving, int handling, int reflex,
                                          int positioning, int kicking, int speed) {
        return new GoalKeeperCardBuilder()
                .withName(name)
                .withNationality(nat)
                .withDiving(diving)
                .withHandling(handling)
                .withReflex(reflex)
                .withPositioning(positioning)
                .withKicking(kicking)
                .withSpeed(speed)
                .build();
    }
}
