package com.snakeLadder.businessLogic;

import com.snakeLadder.model.Dice;
import com.snakeLadder.model.*;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class SnakeLadderGame {
    private static final int BOARD_SIZE = 100;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private List<Player> players;
    private Dice dice;

    public SnakeLadderGame() {
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
        players = new ArrayList<>();
        dice = new Dice();
    }

    public void initializeGame() {
        // Initialize the snakes and ladders
        initializeSnakes();
        initializeLadders();

        // Initialize the players
        initializePlayers();
    }

    private void initializeSnakes() {
        // Add snakes to the game
        snakes.add(new Snake(16, 6));
        snakes.add(new Snake(47, 26));
        snakes.add(new Snake(49, 11));
        snakes.add(new Snake(56, 53));
        snakes.add(new Snake(62, 19));
        snakes.add(new Snake(64, 60));
    }

    private void initializeLadders() {
        // Add ladders to the game
        ladders.add(new Ladder(3, 22));
        ladders.add(new Ladder(5, 8));
        ladders.add(new Ladder(11, 26));
        ladders.add(new Ladder(20, 29));
        ladders.add(new Ladder(27, 39));
        ladders.add(new Ladder(38, 50));
    }

    private void initializePlayers() {
        // Add players to the game
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {
            for (Player player : players) {
                System.out.println(player.getName() + ", it's your turn. Press enter to roll the dice.");
                scanner.nextLine();

                int diceValue = dice.roll();
                System.out.println("You rolled a " + diceValue);

                int newPosition = player.getPosition() + diceValue;
                newPosition = handleSnakeOrLadder(newPosition);

                player.setPosition(newPosition);
                System.out.println("You are now at position " + newPosition);

                if (newPosition == BOARD_SIZE) {
                    System.out.println(player.getName() + " wins!");
                    gameOver = true;
                    break;
                }

                System.out.println();
            }
        }

        scanner.close();
    }

    public int handleSnakeOrLadder(int position) {
        for (Snake snake : snakes) {
            if (snake.getStart() == position)
                return snake.getEnd();

        }

        for (Ladder ladder : ladders) {
            if (ladder.getStart() == position)
                return ladder.getEnd();
            }


        return position;
    }

    public boolean isGameOver() {
        for (Player player : players) {

            if (player.getPosition() == BOARD_SIZE)
                return true;

        }
        return false;
    }

    public Player getWinner() {
        for (Player player : players) {

            if (player.getPosition() == BOARD_SIZE)
                return player;

        }
        return null;
    }
}