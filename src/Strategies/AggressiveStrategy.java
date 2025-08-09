package Strategies;

import Models.PlayerCard;

public class AggressiveStrategy implements PlayStyle {
    private static final long Price = 5000000;

    @Override
    public int calculatePower(PlayerCard playCard) {
        return (playCard.getShooting()
                + playCard.getPace()
                + playCard.getDribbling()) / 3;
    }

    @Override
    public long getPlayStylePrice() { return Price; }

}
