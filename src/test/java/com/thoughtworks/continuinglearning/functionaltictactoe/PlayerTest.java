package com.thoughtworks.continuinglearning.functionaltictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

import static java.util.Collections.singletonList;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class PlayerTest {

    private Board board;
    private PrintStream printStream;
    private Player player;
    private ValidInputReader inputReader;
    private Player opponent;
    private List<Player> otherPlayer;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        inputReader = mock(ValidInputReader.class);
        opponent = mock(Player.class);
        otherPlayer = singletonList(opponent);
        player = new Player("X", board, printStream, inputReader, otherPlayer);
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
        player = new Player("+", board, printStream, inputReader, otherPlayer);

        player.move();

        verify(board).mark(1, "+");
    }

    @Test
    public void shouldTellOtherPlayerToMoveWhenWeAreFinishedMoving() {
        when(board.openCells()).thenReturn(singletonList(1));

        player.move();

        verify(opponent).move();
    }

    @Test
    public void shouldNotTellOtherPlayerToMoveWhenBoardIsFull() {
        when(board.openCells()).thenReturn(new ArrayList<>());

        player.move();

        verify(opponent, never()).move();
    }

    @Test
    public void shouldDrawBoardAfterMoving() {
        player.move();

        verify(board).draw();
    }


}