package com.thoughtworks.continuinglearning.functionaltictactoe;

import java.io.PrintStream;
import java.util.List;

import static java.lang.String.format;

public class Board {
    private final List<String> cells;
    private final PrintStream printStream;

    public Board(List<String> cells, PrintStream printStream) {
        this.cells = cells;
        this.printStream = printStream;
    }

    public void draw() {
        String boardString = format(
                "%s|%s|%s\n" +
                "-----\n" +
                "%s|%s|%s\n" +
                "-----\n" +
                "%s|%s|%s\n",
                cells.toArray());

        printStream.println(boardString);
    }

    public void mark(int location, String symbol) {
        cells.set(location - 1, symbol);
    }
}
