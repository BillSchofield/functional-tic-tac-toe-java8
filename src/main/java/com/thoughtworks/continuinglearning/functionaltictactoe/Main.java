package com.thoughtworks.continuinglearning.functionaltictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        List<String> cells = asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        Board board = new Board(cells, printStream);
        Game game = game(cells, board);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ValidInputReader inputReader = new ValidInputReader(board, printStream, bufferedReader);

        List<Player> playerOneOpponent = new ArrayList<>();
        Player playerOne = new Player("X", "1", board, game, printStream, inputReader, playerOneOpponent);
        List<Player> playerTwoOpponent = Collections.singletonList(playerOne);
        Player playerTwo = new Player("O", "2", board, game, printStream, inputReader, playerTwoOpponent);
        playerOneOpponent.add(playerTwo);

        board.draw();
        EndCondition endCondition = playerOne.move();
        printStream.println(endCondition.description());;
    }

    private static Game game(List<String> cells, Board board) {
        List<EndCondition> endConditions = asList(
                new NoEmptyCellsEndCondition(cells),
                new ThreeInARowWinsEndCondition(asList(
                        new ThreeInARowCondition(1, 2, 3, board)
                ))
        );
        return new Game(endConditions);
    }
}
