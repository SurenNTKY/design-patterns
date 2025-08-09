package Models;

public abstract class Card {
    protected final String name;
    protected final String nationality;

    protected Card(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }
    public String getNationality() {
        return nationality;
    }

    public abstract long getPrice();
}
