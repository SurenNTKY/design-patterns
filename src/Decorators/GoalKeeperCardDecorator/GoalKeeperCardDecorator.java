package Decorators.GoalKeeperCardDecorator;

import Models.GoalKeeperCard;

public abstract class GoalKeeperCardDecorator extends GoalKeeperCard {
    protected final GoalKeeperCard goalKeeperCard;
    protected long decorationPrice;
    protected int deltaDiving, deltaHandling, deltaReflex, deltaPositioning, deltaKicking, deltaSpeed;

    public GoalKeeperCardDecorator(GoalKeeperCard goalKeeperCard) {
        super(goalKeeperCard.getName(),goalKeeperCard.getNationality(),
                goalKeeperCard.getDiving(), goalKeeperCard.getHandling(),
                goalKeeperCard.getReflex(), goalKeeperCard.getPositioning(),
                goalKeeperCard.getKicking(), goalKeeperCard.getSpeed());
        this.goalKeeperCard = goalKeeperCard;
    }

    @Override
    public long getPrice() { return goalKeeperCard.getPrice() + decorationPrice; }
    @Override
    public int getDiving() { return Math.min(99, goalKeeperCard.getDiving() + deltaDiving); }
    @Override
    public int getHandling() { return Math.min(99, goalKeeperCard.getHandling() + deltaHandling); }
    @Override
    public int getReflex() { return Math.min(99, goalKeeperCard.getReflex() + deltaReflex); }
    @Override
    public int getPositioning() { return Math.min(99, goalKeeperCard.getPositioning() + deltaPositioning); }
    @Override
    public int getKicking() { return Math.min(99, goalKeeperCard.getKicking() + deltaKicking); }
    @Override
    public int getSpeed() { return Math.min(99, goalKeeperCard.getSpeed() + deltaSpeed); }
}
