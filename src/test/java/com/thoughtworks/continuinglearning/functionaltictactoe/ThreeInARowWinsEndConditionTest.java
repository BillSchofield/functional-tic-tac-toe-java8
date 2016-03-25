package com.thoughtworks.continuinglearning.functionaltictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ThreeInARowWinsEndConditionTest {

    private Condition winCondition;
    private List<Condition> winConditions;
    private ThreeInARowWinsEndCondition endCondition;

    @Before
    public void setUp() throws Exception {
        winCondition = mock(Condition.class);
        winConditions = Collections.singletonList(winCondition);
        endCondition = new ThreeInARowWinsEndCondition(winConditions);
    }

    @Test
    public void shouldBeMetWhenAWinConditionIsMet() {
        when(winCondition.isMet()).thenReturn(true);
        assertThat(endCondition.isMet(), is(true));
    }

    @Test
    public void shouldNotBeMetWhenNoWinConditionsAreMet() {
        when(winCondition.isMet()).thenReturn(false);
        assertThat(endCondition.isMet(), is(false));
    }
}