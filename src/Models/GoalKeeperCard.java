package Models;

public class GoalKeeperCard extends Card {
    private final int diving, handling, reflex, positioning, kicking, speed;

    public GoalKeeperCard(String name, String nationality, int diving,
                          int handling, int reflex, int positioning,
                          int kicking, int speed) {
        super(name,nationality);
        this.diving = capacity(diving);
        this.handling = capacity(handling);
        this.reflex = capacity(reflex);
        this.positioning = capacity(positioning);
        this.kicking = capacity(kicking);
        this.speed = capacity(speed);
    }

    private int capacity(int stat) { return Math.min(stat, 99); }

    public int getDiving() { return diving; }
    public int getHandling() { return handling; }
    public int getReflex() { return reflex; }
    public int getPositioning() { return positioning; }
    public int getKicking() { return kicking; }
    public int getSpeed() { return speed; }

    @Override
    public long getPrice() {
        int sum = diving + handling + reflex + positioning + kicking + speed;
        double avg = (double)sum / 6;
        return Math.round(avg * 10000000L);
    }
}
