package com.thoughtworks.continuinglearning.functionaltictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

import static java.util.Collections.singletonList;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class PlayerTest {

    private Board board;
    private PrintStream printStream;
    private Player player;
    private ValidInputReader inputReader;
    private Player opponent;
    private List<Player> otherPlayer;
    private EndCondition endCondition;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        endCondition = mock(EndCondition.class);
        when(board.gameEndCondition()).thenReturn(of(endCondition));
        printStream = mock(PrintStream.class);
        inputReader = mock(ValidInputReader.class);
        opponent = mock(Player.class);
        otherPlayer = singletonList(opponent);
        player = new Player("X", "3", board, printStream, inputReader, otherPlayer);
    }

    @Test
    public void shouldPromptPlayerWhenMakingMove() throws IOException {
        when(inputReader.readInteger()).thenReturn(1);

        player.move();

        verify(printStream).println(contains("Player 3"));
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
        player = new Player("+", "3", board, printStream, inputReader, otherPlayer);

        player.move();

        verify(board).mark(1, "+");
    }

    @Test
    public void shouldTellOtherPlayerToMoveWhenWeAreFinishedMoving() {
        when(board.gameEndCondition()).thenReturn(empty());

        player.move();

        verify(opponent).move();
    }

    @Test
    public void shouldNotTellOtherPlayerToMoveWhenBoardIsFull() {
        player.move();

        verify(opponent, never()).move();
    }

    @Test
    public void shouldNotTellOtherPlayerToMoveWhenGameIsWon() {
        player.move();

        verify(opponent, never()).move();
    }

    @Test
    public void shouldDrawBoardAfterMoving() {
        player.move();

        verify(board).draw();
    }

    @Test
    public void shouldFindEndCondition() {
        assertThat(player.move(), is(endCondition));
    }


}