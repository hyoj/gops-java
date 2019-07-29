package example.gops.player;

import example.gops.Deck;

public abstract class Player {
    Deck cards;
    private int score;

    public Player() {
        cards = new Deck();
        score = 0;
    }

    public int scorePoint(int value) {
        return score += value;
    }

    public int getScore() {
        return score;
    }

    public abstract int playCard(int scoreCard);
}
