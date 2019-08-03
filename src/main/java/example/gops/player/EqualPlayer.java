package example.gops.player;

public class EqualPlayer extends Player {

    public EqualPlayer(String name) {
        super(name);
    }

    @Override
    public int play(int scoreCard) {
        cards.remove(scoreCard);
        playCard = scoreCard;
        return scoreCard;
    }
}
