package Decorators.PlayerCardDecorator;

import Models.PlayerCard;

public class HeroPlayerCardDecorator extends PlayerCardDecorator {
    public HeroPlayerCardDecorator(PlayerCard playCard) {
        super(playCard);
        this.decorationPrice = 15000000;
        this.deltaShooting   =  4;
        this.deltaPace       =  2;
        this.deltaDribbling  =  2;
        this.deltaPhysic     =  1;
        this.deltaPassing    =  1;
        this.deltaDefending  =  2;
    }
}
