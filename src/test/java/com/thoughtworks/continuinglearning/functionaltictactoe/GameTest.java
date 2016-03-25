package com.thoughtworks.continuinglearning.functionaltictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {
    private List<EndCondition> endConditions;
    private Game game;

    @Before
    public void setUp() throws Exception {
        endConditions = new ArrayList<>();
        game = new Game(endConditions);
    }

    @Test
    public void shouldFindNoWinConditionWhenNoConditionIsMet() {
        assertThat(game.endCondition().isPresent(), is(false));
    }

    @Test
    public void shouldFindWinConditionWhenOneIsMet() {
        EndCondition endCondition = mock(EndCondition.class);
        when(endCondition.isMet()).thenReturn(true);
        endConditions.add(endCondition);

        assertThat(game.endCondition().isPresent(), is(true));
    }

}