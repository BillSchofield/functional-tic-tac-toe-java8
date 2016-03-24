package com.thoughtworks.continuinglearning.functionaltictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GameTest {

    private Board board;
    private Game game;
    private Player playerOne;
    private Player playerTwo;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        game = new Game(board, playerOne, playerTwo);
    }

    @Test
    public void shouldDrawBoardThreeTimesWhenStarting() {
        game.start();

        verify(board, times(3)).draw();
    }

    @Test
    public void firstPlayerShouldMoveWhenStarting() {
        game.start();

        verify(playerOne).move();
    }

    @Test
    public void secondPlayerShouldMoveWhenStarting() {
        game.start();

        verify(playerTwo).move();
    }

}