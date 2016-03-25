package com.thoughtworks.continuinglearning.functionaltictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class NoEmptyCellsEndConditionTest {

    private List<String> cells;
    private NoEmptyCellsEndCondition endCondition;

    @Before
    public void setUp() throws Exception {
        cells = new ArrayList<>();
        endCondition = new NoEmptyCellsEndCondition(cells);
    }

    @Test
    public void shouldBeMetWhenThereAreNoEmptyCells() {
        cells.add("+");

        assertThat(endCondition.isMet(), is(true));
    }

    @Test
    public void shouldNotBeMetWhenThereAreEmptyCells() {
        cells.add("1");
        cells.add("+");

        assertThat(endCondition.isMet(), is(false));
    }

}