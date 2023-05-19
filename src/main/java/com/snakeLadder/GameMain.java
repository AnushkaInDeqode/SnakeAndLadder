package com.snakeLadder;

import com.snakeLadder.businessLogic.SnakeLadderGame;

public class GameMain {

    public static void main(String[] args) {
        SnakeLadderGame snakeLadderGame = new SnakeLadderGame();
        snakeLadderGame.initializeGame();
        snakeLadderGame.playGame();
    }
}
