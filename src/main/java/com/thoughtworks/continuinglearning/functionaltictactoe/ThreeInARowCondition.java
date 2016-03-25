package com.thoughtworks.continuinglearning.functionaltictactoe;

import java.util.List;
import java.util.stream.Collectors;

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
        List<String> tuple = board.tuple(first, second, third);
        return tuple.stream().distinct().collect(Collectors.toList()).size() == 1;
    }
}
