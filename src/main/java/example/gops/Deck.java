package example.gops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck {
    private List<Integer> cards;

    public Deck() {
        cards = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
    }

    public int popRandom() {
        final int value = cards.get((int) Math.floor(Math.random() * (double) cards.size()));
        cards.remove(Integer.valueOf(value));
        return value;
    }

    public void remove(int value) {
        cards.remove(Integer.valueOf(value));
    }

    public boolean hasCards() {
        return cards.size() > 0;
    }
}