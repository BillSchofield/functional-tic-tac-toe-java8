package com.thoughtworks.continuinglearning.functionaltictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameTest {
    private Board board;
    private PrintStream printStream;
    private String endConditionDescription;
    private Game game;

    @Before
    public void setUp() throws Exception {
        Player player = mock(Player.class);
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        EndCondition endCondition = mock(EndCondition.class);
        endConditionDescription = "description";
        when(endCondition.description()).thenReturn(endConditionDescription);
        when(player.move()).thenReturn(endCondition);
        game = new Game(player, board, printStream);
    }



    @Test
    public void shouldDrawBoardWhenStarting() {
        game.start();

        verify(board).draw();
    }

    @Test
    public void shouldPrintEndConditionWhenStarting() {
        game.start();

        verify(printStream).println(endConditionDescription);
    }
}