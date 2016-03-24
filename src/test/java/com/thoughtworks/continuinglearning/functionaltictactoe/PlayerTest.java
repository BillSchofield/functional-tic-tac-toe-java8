package com.thoughtworks.continuinglearning.functionaltictactoe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayerTest {

    private Board board;
    private PrintStream printStream;
    private Player player;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        player = new Player(board, printStream, bufferedReader);
    }

    @Test
    public void shouldPromptPlayerWhenMakingMove() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        player.move();

        verify(printStream).println(contains("enter a number"));
    }

    @Test
    public void shouldMarkBoardInPositionOneWhenPlayerEntersOne() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");

        player.move();

        verify(board).mark(1);
    }
}