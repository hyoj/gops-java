package example.gops.player;

import example.gops.Deck;

public abstract class Player {
    private String name;
    Deck cards;
    int playCard;
    private int score;

    public Player(String name) {
        cards = new Deck();
        score = 0;
        this.name = name;
    }

    public int scorePoint(int value) {
        return score += value;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public int getPlayCard() {
        return playCard;
    }

    public abstract int play(int scoreCard);

    @Override
    public String toString() {
        return "Player{" +
            "name='" + name + '\'' +
            //", cards=" + cards +
            //", playCard=" + playCard +
            ", score=" + score +
            '}';
    }
}
