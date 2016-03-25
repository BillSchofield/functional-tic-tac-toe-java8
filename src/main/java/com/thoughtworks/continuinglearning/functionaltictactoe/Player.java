package com.thoughtworks.continuinglearning.functionaltictactoe;

import java.io.PrintStream;

public class Player {
    private final String symbol;
    private final Board board;
    private final PrintStream printStream;
    private final ValidInputReader inputReader;

    public Player(String symbol, Board board, PrintStream printStream, ValidInputReader inputReader) {
        this.symbol = symbol;
        this.board = board;
        this.printStream = printStream;
        this.inputReader = inputReader;
    }

    public void move() {
        printStream.println("Player 1, enter a number between 1 and 9 to make your move.");
        board.mark(inputReader.readInteger(), symbol);
    }
}
