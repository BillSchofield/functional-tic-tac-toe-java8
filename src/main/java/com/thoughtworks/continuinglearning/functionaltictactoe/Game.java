package com.thoughtworks.continuinglearning.functionaltictactoe;

public class Game {
    private final Board board;
    private final Player player;

    public Game(Board board, Player player) {
        this.board = board;
        this.player = player;
    }

    public void start() {
        board.draw();
        player.move();
        board.draw();
    }
}
