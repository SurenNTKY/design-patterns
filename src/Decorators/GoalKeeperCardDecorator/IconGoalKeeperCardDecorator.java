package Decorators.GoalKeeperCardDecorator;

import Models.GoalKeeperCard;

public class IconGoalKeeperCardDecorator extends GoalKeeperCardDecorator {
    public IconGoalKeeperCardDecorator(GoalKeeperCard goalKeeperCard) {
        super(goalKeeperCard);
        this.decorationPrice = 50000000;
        this.deltaDiving = 5;
        this.deltaHandling = 3;
        this.deltaReflex = 2;
        this.deltaPositioning = 0;
        this.deltaKicking = 2;
        this.deltaSpeed = 5;
    }
}
