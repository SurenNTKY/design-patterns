package Decorators.PlayerCardDecorator;

import Models.PlayerCard;

public class BronzePlayerCardDecorator extends PlayerCardDecorator {
    public BronzePlayerCardDecorator(PlayerCard playCard) {
        super(playCard);
        this.decorationPrice = 50000000;
        this.deltaShooting   =  0;
        this.deltaPace       =  1;
        this.deltaDribbling  =  3;
        this.deltaPhysic     =  0;
        this.deltaPassing    =  0;
        this.deltaDefending  =  2;
    }
}
