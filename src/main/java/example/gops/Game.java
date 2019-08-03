package example.gops;

import example.gops.player.EqualPlayer;
import example.gops.player.RandomPlayer;

public class Game {
    private GamePlayers players;
    private Deck scoreCards;
    private int turn;

    public Game() {
        players = new GamePlayers(new RandomPlayer("P0"), new EqualPlayer("P1"));
        scoreCards = new Deck();
        turn = 0;
    }

    private void playTurn() {
        final int scoreCard = scoreCards.popRandom();
        System.out.println("Turn " + turn + ": Bounty: " + scoreCard);

        players.playCard(scoreCard);
        System.out.println(players.toStringPlayersPlayCard());

        turn++;
    }

    public void playGame() {
        while (scoreCards.hasCards()) {
            playTurn();
        }

        System.out.println();
        System.out.println(players.toStringPlayersScores());

        if (players.getWinner().isPresent()) {
            System.out.println(players.getWinner().get().getName() + " Wins!");
        } else {
            System.out.println("Players Tie!");
        }
    }
}
