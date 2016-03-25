package com.thoughtworks.continuinglearning.functionaltictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static java.lang.Integer.parseInt;

public class ValidInputReader {
    private List<LocationValidators> validators;

    private final Board board;
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;

    public ValidInputReader(Board board, PrintStream printStream, BufferedReader bufferedReader) {
        this.board = board;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public int readInteger() {
        final int location = parseInt(readLine());
        Optional<Integer> cell = board.findOpenCell(location);

        return cell.orElseGet(() -> {
            printStream.println("Location already taken");
            return readInteger();
        });
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
