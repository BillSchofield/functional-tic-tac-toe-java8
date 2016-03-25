package com.thoughtworks.continuinglearning.functionaltictactoe;

public class Game {
    private final Board board;
    private final Player playerOne;

    public Game(Board board, Player playerOne) {
        this.board = board;
        this.playerOne = playerOne;
    }

    public void start() {
        board.draw();
        playerOne.move();
    }
}
