package com.thoughtworks.continuinglearning.functionaltictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ThreeInARowConditionTest {
    private Board board;
    private ThreeInARowCondition threeInARowCondition;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        threeInARowCondition = new ThreeInARowCondition(1, 2, 3, board);
    }

    @Test
    public void shouldBeMetWhenThreeCellsAreTheSame() {
        when(board.tuple(1, 2, 3)).thenReturn(Arrays.asList("+", "+", "+"));
        assertThat(threeInARowCondition.isMet(), is(true));
    }

    @Test
    public void shouldNotBeMetWhenTheCellsAreDifferent() {
        when(board.tuple(1, 2, 3)).thenReturn(Arrays.asList("+", "X"));
        assertThat(threeInARowCondition.isMet(), is(false));
    }

}