package Decorators.PlayerCardDecorator;

import Models.PlayerCard;

public abstract class PlayerCardDecorator extends PlayerCard {
    protected final PlayerCard playerCard;
    protected long decorationPrice;
    protected int deltaShooting, deltaPace, deltaDribbling, deltaPhysic, deltaPassing, deltaDefending;

    public PlayerCardDecorator(PlayerCard playerCard) {
        super(playerCard.getName(), playerCard.getNationality(),
                playerCard.getShooting(), playerCard.getPace(),
                playerCard.getDribbling(), playerCard.getPhysic(),
                playerCard.getPassing(), playerCard.getDefending());
        this.playerCard = playerCard;
    }

    @Override
    public long getPrice() { return playerCard.getPrice() + decorationPrice; }
    @Override
    public int getShooting() { return Math.min(99, playerCard.getShooting() + deltaShooting); }
    @Override
    public int getPace() { return Math.min(99, playerCard.getPace() + deltaPace); }
    @Override
    public int getDribbling() { return Math.min(99, playerCard.getDribbling() + deltaDribbling); }
    @Override
    public int getPhysic() { return Math.min(99, playerCard.getPhysic() + deltaPhysic); }
    @Override
    public int getPassing() { return Math.min(99, playerCard.getPassing() + deltaPassing); }
    @Override
    public int getDefending() { return Math.min(99, playerCard.getDefending() + deltaDefending); }



}
