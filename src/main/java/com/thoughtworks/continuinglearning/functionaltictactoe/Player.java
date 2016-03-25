package com.thoughtworks.continuinglearning.functionaltictactoe;

import java.io.PrintStream;
import java.util.List;

public class Player {
    private final String symbol;
    private final String number;
    private final Board board;
    private final PrintStream printStream;
    private final ValidInputReader inputReader;
    private final List<Player> otherPlayer;

    public Player(String symbol, String number, Board board, PrintStream printStream, ValidInputReader inputReader, List<Player> otherPlayer) {
        this.symbol = symbol;
        this.number = number;
        this.board = board;
        this.printStream = printStream;
        this.inputReader = inputReader;
        this.otherPlayer = otherPlayer;
    }

    public EndCondition move() {
        printStream.println("Player " + number + ", enter a number between 1 and 9 to make your move.");
        board.mark(inputReader.readInteger(), symbol);
        board.draw();
        return board.
                gameEndCondition().
                orElseGet(() -> otherPlayer.
                        stream().
                        findFirst().
                        get().
                        move());
    }
}
