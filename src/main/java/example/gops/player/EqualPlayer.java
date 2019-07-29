package example.gops.player;

public class EqualPlayer extends Player {
    public int playCard(int scoreCard) {
        cards.remove(scoreCard);
        return scoreCard;
    }
}
