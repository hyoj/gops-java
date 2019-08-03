package example.gops;

import example.gops.player.Player;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GamePlayers {
    private List<Player> players;

    GamePlayers(Player... players) {
        this.players = Arrays.asList(players);
    }

    public void playCard(int scoreCard) {
        players.forEach(p -> p.play(scoreCard));
        scorePoint(scoreCard);
    }

    void scorePoint(int scoreCard) {
        List<Player> sortedPlayersByPlayCard = players.stream()
            .sorted(Comparator.comparing(Player::getPlayCard).reversed())
            .collect(Collectors.toList());

        if (sortedPlayersByPlayCard.get(0).getPlayCard() > sortedPlayersByPlayCard.get(1).getPlayCard()) {
            sortedPlayersByPlayCard.get(0).scorePoint(scoreCard);
        }
    }

    public String toStringPlayersPlayCard() {
        return players.stream()
            .map(p -> p.getName() + ": " + p.getPlayCard())
            .collect(Collectors.joining("\n"));
    }

    public String toStringPlayersScores() {
        return players.stream()
            .map(p -> String.valueOf(p.getScore()))
            .collect(Collectors.joining(" v ", "Scores: ", ""));
    }

    public Optional<Player> getWinner() {
        List<Player> sortedPlayers = players.stream()
            .sorted(Comparator.comparingInt(Player::getScore).reversed())
            .collect(Collectors.toList());

        final Player p0 = sortedPlayers.get(0);
        final Player p1 = sortedPlayers.get(1);

        if (p0.getScore() == p1.getScore()) {
            return Optional.empty();
        }

        return Optional.of(p0);
    }

    @Override
    public String toString() {
        return players.stream()
            .map(Object::toString)
            .collect(Collectors.joining("\n"));
    }
}
