package com.thoughtworks.continuinglearning.functionaltictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        List<String> cells = Arrays.asList(" ", " ", " ", " ", " ", " ", " ", " ", " ");
        Board board = new Board(cells, printStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ValidInputReader inputReader = new ValidInputReader(bufferedReader);
        Player playerOne = new Player("X", board, printStream, inputReader);
        Player playerTwo = new Player("O", board, printStream, inputReader);
        Game game = new Game(board, playerOne, playerTwo);
        game.start();
    }
}
