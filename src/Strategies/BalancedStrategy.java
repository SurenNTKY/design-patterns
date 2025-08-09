package Strategies;

import Models.PlayerCard;

public class BalancedStrategy implements PlayStyle{
    private static final long Price = 3000000;

    @Override
    public int calculatePower (PlayerCard playCard) {
        int sum = playCard.getShooting() + playCard.getPace() + playCard.getDribbling()
                + playCard.getPhysic() + playCard.getPassing() + playCard.getDefending();
        return sum / 6;
    }

    @Override
    public long getPlayStylePrice() {
        return Price;
    }

}
