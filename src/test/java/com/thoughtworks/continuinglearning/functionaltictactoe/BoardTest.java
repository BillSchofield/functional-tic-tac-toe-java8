package com.thoughtworks.continuinglearning.functionaltictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private List<String> cells;

    @Before
    public void setUp() throws Exception {
        cells = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        printStream = mock(PrintStream.class);
        board = new Board(cells, printStream);
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


}