package Decorators.PlayerCardDecorator;

import Models.PlayerCard;

public class GoldPlayerCardDecorator extends PlayerCardDecorator {
    public GoldPlayerCardDecorator(PlayerCard playCard) {
        super(playCard);
        this.decorationPrice = 100000000;
        this.deltaShooting   =  3;
        this.deltaPace       =  0;
        this.deltaDribbling  =  3;
        this.deltaPhysic     =  4;
        this.deltaPassing    =  3;
        this.deltaDefending  =  1;
    }
}
