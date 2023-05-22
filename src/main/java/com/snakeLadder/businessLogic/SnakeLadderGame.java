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

        initializeSnakes();
        initializeLadders();
        initializePlayers();
    }

    public void initializeSnakes() {

        this.snakes.add(new Snake(16, 6));
        this.snakes.add(new Snake(47, 26));
        this.snakes.add(new Snake(49, 11));
        this.snakes.add(new Snake(56, 53));
        this.snakes.add(new Snake(62, 19));
        this.snakes.add(new Snake(64, 60));
    }

    public void initializeLadders() {

        this.ladders.add(new Ladder(3, 22));
        this.ladders.add(new Ladder(5, 8));
        this.ladders.add(new Ladder(11, 26));
        this.ladders.add(new Ladder(20, 29));
        this.ladders.add(new Ladder(27, 39));
        this.ladders.add(new Ladder(38, 50));
    }

    public void initializePlayers() {

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

}