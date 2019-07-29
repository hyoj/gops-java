package example.gops;

import example.gops.player.EqualPlayer;
import example.gops.player.Player;
import example.gops.player.RandomPlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private List<Player> players;
    private Deck scoreCards;
    private int turn;

    public Game() {
        players = new ArrayList<>(Arrays.asList(new RandomPlayer(), new EqualPlayer()));
        scoreCards = new Deck();
        turn = 0;
    }

    private void playTurn() {
        final int scoreCard = scoreCards.popRandom();

        System.out.println("Turn " + turn + ": Bounty: " + scoreCard);

        final int card0 = players.get(0).playCard(scoreCard);
        final int card1 = players.get(1).playCard(scoreCard);

        System.out.println("\tP0: " + card0);
        System.out.println("\tP1: " + card1);

        if (card0 > card1) {
            players.get(0).scorePoint(scoreCard);
        } else if (card1 > card0) {
            players.get(1).scorePoint(scoreCard);
        }

        turn++;
    }

    public void playGame() {
        while (scoreCards.hasCards()) {
            playTurn();
        }

        System.out.println("Scores: " + players.get(0).getScore() + " v " + players.get(1).getScore());

        if (players.get(0).getScore() == players.get(1).getScore()) {
            System.out.println("Players Tie!");
        } else if (players.get(0).getScore() > players.get(1).getScore()) {
            System.out.println("Player 0 Wins!");
        } else {
            System.out.println("Player 1 Wins!");
        }
    }
}
