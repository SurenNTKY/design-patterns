package Builders;

import Models.PlayerCard;

public class PlayerCardBuilder implements CardBuilder<PlayerCard>{
    private String name, nationality;
    private int shooting, pace, dribbling, physic, passing, defending;

    public PlayerCardBuilder withName(String name) { this.name = name; return this; }
    public PlayerCardBuilder withNationality(String nat) { this.nationality = nat; return this; }
    public PlayerCardBuilder withShooting(int v)  { shooting  = v; return this; }
    public PlayerCardBuilder withPace(int v)      { pace      = v; return this; }
    public PlayerCardBuilder withDribbling(int v) { dribbling = v; return this; }
    public PlayerCardBuilder withPhysic(int v)    { physic    = v; return this; }
    public PlayerCardBuilder withPassing(int v)   { passing   = v; return this; }
    public PlayerCardBuilder withDefending(int v) { defending = v; return this; }

    @Override
    public PlayerCard build() {
        return new PlayerCard(name, nationality,
                shooting, pace, dribbling,
                physic, passing, defending);
    }
}
