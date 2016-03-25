package com.thoughtworks.continuinglearning.functionaltictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        List<String> cells = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        Board board = new Board(cells, printStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ValidInputReader inputReader = new ValidInputReader(board, printStream, bufferedReader);

        List<Player> playerOneOpponent = new ArrayList<>();
        Player playerOne = new Player("X", board, printStream, inputReader, playerOneOpponent);
        List<Player> playerTwoOpponent = Collections.singletonList(playerOne);
        Player playerTwo = new Player("O", board, printStream, inputReader, playerTwoOpponent);
        playerOneOpponent.add(playerTwo);

        Game game = new Game(board, playerOne);
        game.start();
        printStream.println("Game is a draw");
    }
}
