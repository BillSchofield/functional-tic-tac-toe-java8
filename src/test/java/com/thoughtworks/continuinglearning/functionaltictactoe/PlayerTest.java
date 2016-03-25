package com.thoughtworks.continuinglearning.functionaltictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayerTest {

    private Board board;
    private PrintStream printStream;
    private Player player;
    private ValidInputReader inputReader;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        inputReader = mock(ValidInputReader.class);
        player = new Player("X", board, printStream, inputReader);
    }

    @Test
    public void shouldPromptPlayerWhenMakingMove() throws IOException {
        when(inputReader.readInteger()).thenReturn(1);
        player.move();

        verify(printStream).println(contains("enter a number"));
    }

    @Test
    public void shouldMarkBoardInPositionOneWhenPlayerEntersOne() throws IOException {
        when(inputReader.readInteger()).thenReturn(1);

        player.move();

        verify(board).mark(1, "X");
    }

    @Test
    public void shouldMarkBoardWithMySymbolWhenMySymbolIsPlus() throws IOException {
        when(inputReader.readInteger()).thenReturn(1);
        player = new Player("+", board, printStream, inputReader);

        player.move();

        verify(board).mark(1, "+");
    }

}