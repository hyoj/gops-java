package example.gops.player;

public class RandomPlayer extends Player {
    public int playCard(int scoreCard) {
        return cards.popRandom();
    }
}
