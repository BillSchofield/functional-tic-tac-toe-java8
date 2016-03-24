package com.thoughtworks.continuinglearning.functionaltictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

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
        cells = Arrays.asList(" ", " ", " ", " ", " ", " ", " ", " ", " ");
        printStream = mock(PrintStream.class);
        board = new Board(cells, printStream);
    }

    @Test
    public void shouldPrintGridWhenDrawing() {
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
    public void shouldSetCellZeroToXWhenLocationOneMarked() {
        board.mark(1);

        assertThat(cells.get(0), is("X"));
    }

    @Test
    public void shouldPutCellValuesInGridWhenDrawing() {

    }


}