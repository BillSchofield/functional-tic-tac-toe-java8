package com.thoughtworks.continuinglearning.functionaltictactoe;

import java.io.BufferedReader;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class ValidInputReader {
    private final BufferedReader bufferedReader;

    public ValidInputReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public int readInteger() {
        return parseInt(readLine());
    }

    private String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
