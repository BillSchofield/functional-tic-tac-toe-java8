package com.thoughtworks.continuinglearning.functionaltictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameEnderTest {
    private List<EndCondition> endConditions;
    private GameEnder gameEnder;

    @Before
    public void setUp() throws Exception {
        endConditions = new ArrayList<>();
        gameEnder = new GameEnder(endConditions);
    }

    @Test
    public void shouldFindNoWinConditionWhenNoConditionIsMet() {
        assertThat(gameEnder.endCondition().isPresent(), is(false));
    }

    @Test
    public void shouldFindWinConditionWhenOneIsMet() {
        EndCondition endCondition = mock(EndCondition.class);
        when(endCondition.isMet()).thenReturn(true);
        endConditions.add(endCondition);

        assertThat(gameEnder.endCondition().isPresent(), is(true));
    }

}