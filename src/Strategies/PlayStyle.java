package Strategies;

import Models.PlayerCard;

public interface PlayStyle {
    int calculatePower(PlayerCard playCard);
    long getPlayStylePrice();
}
