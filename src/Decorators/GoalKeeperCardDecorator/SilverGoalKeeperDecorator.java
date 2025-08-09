package Decorators.GoalKeeperCardDecorator;

import Models.GoalKeeperCard;

public class SilverGoalKeeperDecorator extends GoalKeeperCardDecorator {
    public SilverGoalKeeperDecorator(GoalKeeperCard goalKeeperCard) {
        super(goalKeeperCard);
        this.decorationPrice = 50000000;
        this.deltaDiving = 2;
        this.deltaHandling = 2;
        this.deltaReflex = 4;
        this.deltaPositioning = 2;
        this.deltaKicking = 3;
        this.deltaSpeed = 1;
    }
}
