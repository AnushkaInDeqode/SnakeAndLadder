import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.snakeLadder.businessLogic.SnakeLadderGame;
import com.snakeLadder.model.*;

public class SnakeLadderGameTest {

    private SnakeLadderGame snakeLadderGame;

    @Before
    public void setUp() {
        snakeLadderGame = new SnakeLadderGame();
        snakeLadderGame.initializeGame();
    }

    @Test
    public void testPlayerMovementWithoutSnakesOrLadders() {
        Player player = snakeLadderGame.getPlayers().get(0);
        player.setPosition(5);

        snakeLadderGame.handleSnakeOrLadder(2);
        Assert.assertEquals(7, player.getPosition());

        snakeLadderGame.handleSnakeOrLadder(3);
        Assert.assertEquals(10, player.getPosition());

        snakeLadderGame.handleSnakeOrLadder(4);
        Assert.assertEquals(14, player.getPosition());

        snakeLadderGame.handleSnakeOrLadder(2);
        Assert.assertEquals(16, player.getPosition());
    }

    @Test
    public void testPlayerMovementWithSnakes() {
        Player player = snakeLadderGame.getPlayers().get(0);
        player.setPosition(10);

        snakeLadderGame.handleSnakeOrLadder(3);
        Assert.assertEquals(13, player.getPosition());

        snakeLadderGame.handleSnakeOrLadder(5);
        Assert.assertEquals(6, player.getPosition());

        snakeLadderGame.handleSnakeOrLadder(4);
        Assert.assertEquals(6, player.getPosition());
    }

    @Test
    public void testPlayerMovementWithLadders() {
        Player player = snakeLadderGame.getPlayers().get(0);
        player.setPosition(4);

        snakeLadderGame.handleSnakeOrLadder(2);
        Assert.assertEquals(22, player.getPosition());

        snakeLadderGame.handleSnakeOrLadder(3);
        Assert.assertEquals(29, player.getPosition());

        snakeLadderGame.handleSnakeOrLadder(5);
        Assert.assertEquals(34, player.getPosition());

        snakeLadderGame.handleSnakeOrLadder(1);
        Assert.assertEquals(50, player.getPosition());
    }

    @Test
    public void testPlayerWinning() {
        Player player = snakeLadderGame.getPlayers().get(0);
        player.setPosition(94);

        snakeLadderGame.handleSnakeOrLadder(6);
        Assert.assertEquals(100, player.getPosition());

        Assert.assertTrue(snakeLadderGame.isGameOver());
        Assert.assertEquals(player, snakeLadderGame.getWinner());
    }
}
