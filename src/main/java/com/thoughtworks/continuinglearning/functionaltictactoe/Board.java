package com.thoughtworks.continuinglearning.functionaltictactoe;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static java.util.Arrays.asList;

public class Board {
    private final List<String> cells;
    private final PrintStream printStream;
    private static final List<String> emptyCellValues = asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

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

    public Optional<Integer> findOpenCell(final int location) {
        final String cellValue = cells.get(location - 1);

        return emptyCellValues.
                stream().
                filter(emptyCellValue -> cellValue.equals(emptyCellValue)).
                map(s -> location).
                findFirst();
    }

    public List<String> tuple(int first, int second, int third) {
        return Arrays.asList(
                cells.get(first-1),
                cells.get(second-1),
                cells.get(third-1)
        );
    }
}
