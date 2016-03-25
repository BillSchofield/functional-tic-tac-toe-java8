package com.thoughtworks.continuinglearning.functionaltictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ValidInputReaderTest {

    private BufferedReader bufferedReader;
    private ValidInputReader validInputReader;

    @Before
    public void setUp() throws Exception {
        bufferedReader = mock(BufferedReader.class);
        validInputReader = new ValidInputReader(bufferedReader);
    }

    @Test
    public void shouldReadANumberOneWhenUserEntersAOne() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");

        assertThat(validInputReader.readInteger(), is(1));
    }

}