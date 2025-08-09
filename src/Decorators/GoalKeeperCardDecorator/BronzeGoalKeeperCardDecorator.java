package Decorators.GoalKeeperCardDecorator;

import Models.GoalKeeperCard;

public class BronzeGoalKeeperCardDecorator extends GoalKeeperCardDecorator {
    public BronzeGoalKeeperCardDecorator(GoalKeeperCard goalKeeperCard) {
        super(goalKeeperCard);
        this.decorationPrice = 50000000;
        this.deltaDiving = 0;
        this.deltaHandling = 1;
        this.deltaReflex = 3;
        this.deltaPositioning = 0;
        this.deltaKicking = 0;
        this.deltaSpeed = 2;
    }
}