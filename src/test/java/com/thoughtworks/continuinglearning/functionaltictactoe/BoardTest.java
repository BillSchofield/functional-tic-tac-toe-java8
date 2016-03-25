package com.thoughtworks.continuinglearning.functionaltictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private List<String> cells;
    private ArrayList<EndCondition> endConditions;

    @Before
    public void setUp() throws Exception {
        cells = asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        printStream = mock(PrintStream.class);
        endConditions = new ArrayList<>();
        board = new Board(cells, printStream, endConditions);
    }

    @Test
    public void shouldPrintGridWhenDrawing() {
        board.draw();

        verify(printStream).println(
                "1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9\n"
        );
    }

    @Test
    public void shouldSetCellZeroToXWhenLocationOneMarked() {
        board.mark(1, "X");

        assertThat(cells.get(0), is("X"));
    }

    @Test
    public void shouldPutCellValuesInGridWhenDrawing() {
        cells.replaceAll(s -> "*");

        board.draw();

        verify(printStream).println(
                "*|*|*\n" +
                "-----\n" +
                "*|*|*\n" +
                "-----\n" +
                "*|*|*\n"
        );
    }

    @Test
    public void shouldSetCellZeroToSymbolUsedToMarked() {
        board.mark(1, "+");

        assertThat(cells.get(0), is("+"));
    }

    @Test
    public void shouldFindCellWhenItIsUnmarked() {
        Optional<Integer> openCell = board.findOpenCell(1);

        assertThat(openCell.isPresent(), is(true));
        assertThat(openCell.get(), is(1));
    }

    @Test
    public void shouldNotFindCellWhenItIsMarked() {
        cells.set(0, "+");

        Optional<Integer> openCell = board.findOpenCell(1);

        assertThat(openCell.isPresent(), is(false));
    }

    @Test
    public void shouldFindNoWinConditionWhenNoConditionIsMet() {
        assertThat(board.gameEndCondition().isPresent(), is(false));
    }

    @Test
    public void shouldFindWinConditionWhenOneIsMet() {
        EndCondition endCondition = mock(EndCondition.class);
        when(endCondition.isMet()).thenReturn(true);
        endConditions.add(endCondition);

        assertThat(board.gameEndCondition().isPresent(), is(true));
    }

}