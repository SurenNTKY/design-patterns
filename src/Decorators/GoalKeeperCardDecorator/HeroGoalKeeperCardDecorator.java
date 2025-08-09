package Decorators.GoalKeeperCardDecorator;

import Models.GoalKeeperCard;

public class HeroGoalKeeperCardDecorator extends GoalKeeperCardDecorator {
    public HeroGoalKeeperCardDecorator(GoalKeeperCard goalKeeperCard) {
        super(goalKeeperCard);
        this.decorationPrice = 150000000;
        this.deltaDiving = 4;
        this.deltaHandling = 2;
        this.deltaReflex = 2;
        this.deltaPositioning = 1;
        this.deltaKicking = 1;
        this.deltaSpeed = 2;
    }
}
