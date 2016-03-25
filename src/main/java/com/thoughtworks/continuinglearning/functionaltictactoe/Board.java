package com.thoughtworks.continuinglearning.functionaltictactoe;

import java.io.PrintStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.lang.String.format;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Board {
    private final List<String> cells;
    private final PrintStream printStream;
    private static final List<String> emptyCellValues = asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
    private final List<EndCondition> endConditions;

    public Board(List<String> cells, PrintStream printStream, List<EndCondition> endConditions) {
        this.cells = cells;
        this.printStream = printStream;
        this.endConditions = endConditions;
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

    public List<Integer> openCells() {
        return IntStream.range(1, 10).
                filter(cellNumber -> findOpenCell(cellNumber).isPresent()).
                boxed().
                collect(toList());
    }

    public Optional<EndCondition> gameEndCondition() {
        return endConditions.
                stream().
                filter(endCondition -> endCondition.isMet()).
                findFirst();
    }
}
