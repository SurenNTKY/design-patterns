package Models;

import Strategies.BalancedStrategy;
import Strategies.PlayStyle;

public class PlayerCard extends Card {
    private final int shooting, pace, dribbling, physic, passing, defending;
    private PlayStyle playStyle = new BalancedStrategy();

    public PlayerCard(String name, String nationality, int shooting, int pace, int dribbling, int physic, int passing, int defending) {
        super(name, nationality);
        this.shooting = capacity(shooting);
        this.pace = capacity(pace);
        this.dribbling = capacity(dribbling);
        this.physic = capacity(physic);
        this.passing = capacity(passing);
        this.defending = capacity(defending);
    }

    private int capacity(int stat) {
        return Math.min(stat, 99);
    }

    public int getShooting() { return shooting; }
    public int getPace() { return pace; }
    public int getDribbling() { return dribbling; }
    public int getPhysic() { return physic; }
    public int getPassing() { return passing; }
    public int getDefending() { return defending; }

    public PlayStyle getPlayStyle() { return playStyle; }
    public void setPlayStyle(PlayStyle playStyle) { this.playStyle = playStyle; }

    public double getOverallPower() {
        return playStyle.calculatePower(this);
    }

    @Override
    public long getPrice() {
        int sum = shooting + pace + dribbling + physic + passing + defending;
        int avg =  sum / 6;
        return Math.round(avg * 10_000_000L);
    }

    public long getPlayStylePrice() {
        return playStyle.getPlayStylePrice();
    }
}
