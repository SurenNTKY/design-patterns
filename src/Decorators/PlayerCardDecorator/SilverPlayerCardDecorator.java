package Decorators.PlayerCardDecorator;

import Models.PlayerCard;

public class SilverPlayerCardDecorator extends PlayerCardDecorator {
    public SilverPlayerCardDecorator(PlayerCard playCard) {
        super(playCard);
        this.decorationPrice = 70000000;
        this.deltaShooting   =  2;
        this.deltaPace       =  2;
        this.deltaDribbling  =  4;
        this.deltaPhysic     =  2;
        this.deltaPassing    =  3;
        this.deltaDefending  =  1;
    }
}
