package example.gops.player;

public class RandomPlayer extends Player {

    public RandomPlayer(String name) {
        super(name);
    }

    public int play(int scoreCard) {
        this.playCard = cards.popRandom();
        return this.playCard;
    }
}
