import org.junit.Test;

import com.snakeLadder.businessLogic.SnakeLadderGame;
import com.snakeLadder.model.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SnakeLadderGameTest {

    @Test
    public void testHandleSnakeOrLadder_Snake() {
        List<Snake> snakes = List.of(new Snake(16, 6), new Snake(47, 26));
        SnakeLadderGame game = new SnakeLadderGame();
        game.initializeSnakes(snakes);
        int newPosition = game.handleSnakeOrLadder(16);
        assertEquals(6, newPosition);
    }

    @Test
    public void testHandleSnakeOrLadder_Ladder() {
        List<Ladder> ladders = List.of(new Ladder(3, 22), new Ladder(5, 8));
        SnakeLadderGame game = new SnakeLadderGame();
        game.initializeLadders(ladders);
        int newPosition = game.handleSnakeOrLadder(3);
        assertEquals(22, newPosition);
    }

    @Test
    public void testHandleSnakeOrLadder_NoSnakeOrLadder() {
        SnakeLadderGame game = new SnakeLadderGame();
        int newPosition = game.handleSnakeOrLadder(10);
        assertEquals(10, newPosition);
    }

    @Test
    public void testPlayerInitialization() {
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        SnakeLadderGame game = new SnakeLadderGame();
        game.initializePlayers();
        assertEquals(2, game.getPlayers().size());
    }

}
