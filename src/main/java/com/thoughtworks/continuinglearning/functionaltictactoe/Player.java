package com.thoughtworks.continuinglearning.functionaltictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Player {
    private final String symbol;
    private final Board board;
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;

    public Player(String symbol, Board board, PrintStream printStream, BufferedReader bufferedReader) {
        this.symbol = symbol;
        this.board = board;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public void move() {
        printStream.println("Player 1, enter a number between 1 and 9 to make your move.");
        board.mark(Integer.parseInt(readLine()), symbol);
    }

    private String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
