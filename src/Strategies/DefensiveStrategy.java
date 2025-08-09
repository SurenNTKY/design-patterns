package Strategies;

import Models.PlayerCard;

public class DefensiveStrategy implements PlayStyle {
    private static final long Price = 4000000;

    @Override
    public int calculatePower(PlayerCard playCard) {
        return (playCard.getPhysic() + playCard.getPassing() + playCard.getDefending()) / 3;
    }

    @Override
    public long getPlayStylePrice() {
        return Price;
    }
}
