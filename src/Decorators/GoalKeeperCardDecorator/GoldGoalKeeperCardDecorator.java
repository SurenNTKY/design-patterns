package Decorators.GoalKeeperCardDecorator;

import Models.GoalKeeperCard;

public class GoldGoalKeeperCardDecorator extends GoalKeeperCardDecorator {
    public GoldGoalKeeperCardDecorator(GoalKeeperCard goalKeeperCard) {
        super(goalKeeperCard);
        this.decorationPrice = 100000000;
        this.deltaDiving = 3;
        this.deltaHandling = 0;
        this.deltaReflex = 3;
        this.deltaPositioning = 4;
        this.deltaKicking = 3;
        this.deltaSpeed = 1;
    }
}
