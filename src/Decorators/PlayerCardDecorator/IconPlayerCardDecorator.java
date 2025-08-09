package Decorators.PlayerCardDecorator;

import Models.PlayerCard;

public class IconPlayerCardDecorator extends PlayerCardDecorator {
    public IconPlayerCardDecorator(PlayerCard playCard) {
        super(playCard);
        this.decorationPrice = 20000000;
        this.deltaShooting   =  5;
        this.deltaPace       =  3;
        this.deltaDribbling  =  2;
        this.deltaPhysic     =  0;
        this.deltaPassing    =  2;
        this.deltaDefending  =  5;
    }
}
