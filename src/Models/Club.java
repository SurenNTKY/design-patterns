package Models;

import java.util.ArrayList;

public class Club {
    private  int budget = 1000000000;
    private static final ArrayList<Card> cards = new ArrayList<Card>();

    public Club(int budget) {
        this.budget = budget;
    }
    public int getBudget() {
        return budget;
    }
    public void setBudget(int budget) {
        this.budget = budget;
    }
    public ArrayList<Card> getCards() {
        return cards;
    }
    public void addCard(Card card) {
        cards.add(card);
    }
    public void removeCard(Card card) {
        cards.remove(card);
    }
    public Card findCardByName(String name) {
        for (Card card : cards) {
            if(card.getName().equals(name)) return card;
        }
        return null;
    }
}
