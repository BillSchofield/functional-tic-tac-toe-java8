package com.thoughtworks.continuinglearning.functionaltictactoe;

import java.util.List;

import static java.util.Arrays.asList;

public class NoEmptyCellsEndCondition implements EndCondition {
    private final List<String> cells;
    private static final List<String> emptyCellValues = asList("1", "2", "3", "4", "5", "6", "7", "8", "9");


    public NoEmptyCellsEndCondition(List<String> cells) {
        this.cells = cells;
    }

    @Override
    public boolean isMet() {
        return !cells.
                stream().
                filter(cellValue -> emptyCellValues.contains(cellValue)).
                findFirst().
                isPresent();
    }

    @Override
    public String description() {
        return "Game is a draw";
    }
}
