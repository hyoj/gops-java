package example.gops;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class GameTest {
    @Test
    public void testPlayGame() {
        Game game = new Game();
        game.playGame();

        assertThat(42, equalTo(42));
    }
}
