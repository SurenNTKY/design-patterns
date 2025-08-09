package Builders;

import Models.GoalKeeperCard;

public class GoalKeeperCardBuilder implements CardBuilder<GoalKeeperCard>{
    private String name, nationality;
    private int diving, handling, reflex, positioning, kicking, speed;

    public GoalKeeperCardBuilder withName(String name)           { this.name = name;       return this; }
    public GoalKeeperCardBuilder withNationality(String nat)     { this.nationality = nat;  return this; }
    public GoalKeeperCardBuilder withDiving(int v)               { diving      = v; return this; }
    public GoalKeeperCardBuilder withHandling(int v)             { handling    = v; return this; }
    public GoalKeeperCardBuilder withReflex(int v)               { reflex      = v; return this; }
    public GoalKeeperCardBuilder withPositioning(int v)          { positioning = v; return this; }
    public GoalKeeperCardBuilder withKicking(int v)              { kicking     = v; return this; }
    public GoalKeeperCardBuilder withSpeed(int v)                { speed       = v; return this; }

    @Override
    public GoalKeeperCard build() {
        return new GoalKeeperCard(name, nationality,
                diving, handling, reflex,
                positioning, kicking, speed);
    }
}
