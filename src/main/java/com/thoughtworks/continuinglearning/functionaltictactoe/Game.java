package com.thoughtworks.continuinglearning.functionaltictactoe;

import java.io.PrintStream;

public class Game {
    private final Player player;
    private final Board board;
    private final PrintStream printStream;

    public Game(Player player, Board board, PrintStream printStream) {
        this.player = player;
        this.board = board;
        this.printStream = printStream;
    }

    public void start() {
        board.draw();
        EndCondition endCondition = player.move();
        printStream.println(endCondition.description());;
    }
}
