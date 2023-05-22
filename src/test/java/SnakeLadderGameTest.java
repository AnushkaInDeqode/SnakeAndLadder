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
        SnakeLadderGame game = new SnakeLadderGame();
        game.initializeSnakes();
        int newPosition = game.handleSnakeOrLadder(16);
        assertEquals(6, newPosition);
    }

    @Test
    public void testHandleSnakeOrLadder_Ladder() {
        SnakeLadderGame game = new SnakeLadderGame();
        game.initializeLadders();
        int newPosition = game.handleSnakeOrLadder(5);
        assertEquals(8, newPosition);
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
