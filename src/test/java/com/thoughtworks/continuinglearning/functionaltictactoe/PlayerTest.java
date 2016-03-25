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
    private Game game;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        endCondition = mock(EndCondition.class);
        printStream = mock(PrintStream.class);
        inputReader = mock(ValidInputReader.class);
        opponent = mock(Player.class);
        otherPlayer = singletonList(opponent);
        game = mock(Game.class);
        when(game.endCondition()).thenReturn(empty());
        player = new Player("X", "3", board, game, printStream, inputReader, otherPlayer);
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
        player = new Player("+", "3", board, game, printStream, inputReader, otherPlayer);

        player.move();

        verify(board).mark(1, "+");
    }

    @Test
    public void shouldTellOtherPlayerToMoveWhenWeAreFinishedMoving() {
        when(game.endCondition()).thenReturn(empty());

        player.move();

        verify(opponent).move();
    }

    @Test
    public void shouldNotTellOtherPlayerToMoveWhenBoardIsFull() {
        when(game.endCondition()).thenReturn(of(endCondition));

        player.move();

        verify(opponent, never()).move();
    }

    @Test
    public void shouldNotTellOtherPlayerToMoveWhenGameIsWon() {
        when(game.endCondition()).thenReturn(of(endCondition));
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
        when(game.endCondition()).thenReturn(of(endCondition));
        assertThat(player.move(), is(endCondition));
    }


}