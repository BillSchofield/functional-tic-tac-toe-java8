package com.thoughtworks.continuinglearning.functionaltictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ValidInputReaderTest {

    private BufferedReader bufferedReader;
    private ValidInputReader validInputReader;
    private Board board;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        validInputReader = new ValidInputReader(board, printStream, bufferedReader);
    }

    @Test
    public void shouldReadANumberOneWhenUserEntersAOne() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.findOpenCell(anyInt())).thenReturn(of(1));

        assertThat(validInputReader.readInteger(), is(1));
    }

    @Test
    public void shouldReportLocationIsTakenWhenUserEntersOccupiedLocation() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.findOpenCell(anyInt())).thenReturn(empty(),  of(1));

        validInputReader.readInteger();

        verify(printStream).println(contains("Location already taken"));
    }

    @Test
    public void shouldFindFirstValidLocationUserSelects() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.findOpenCell(anyInt())).thenReturn(empty(),  of(1));

        assertThat(validInputReader.readInteger(), is(1));
    }


}