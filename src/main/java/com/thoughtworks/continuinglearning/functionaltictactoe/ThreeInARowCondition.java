package com.thoughtworks.continuinglearning.functionaltictactoe;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class ThreeInARowCondition implements Condition {
    private final int first;
    private final int second;
    private final int third;
    private final Board board;

    public ThreeInARowCondition(int first, int second, int third, Board board) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.board = board;
    }

    @Override
    public boolean isMet() {
        return board.
                tuple(first, second, third).
                stream().
                distinct().
                collect(counting()) == 1;
    }
}
