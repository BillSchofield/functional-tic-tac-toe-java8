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
        GameEnder gameEnder = gameEnder(cells, board);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ValidInputReader inputReader = new ValidInputReader(board, printStream, bufferedReader);

        List<Player> playerOneOpponent = new ArrayList<>();
        Player playerOne = player(printStream, board, gameEnder, inputReader, playerOneOpponent, "X", "1");
        List<Player> playerTwoOpponent = Collections.singletonList(playerOne);
        Player playerTwo = player(printStream, board, gameEnder, inputReader, playerTwoOpponent, "O", "2");
        playerOneOpponent.add(playerTwo);
        Game game = new Game(playerOne, board, printStream);

        game.start();

    }

    private static Player player(PrintStream printStream, Board board, GameEnder gameEnder, ValidInputReader inputReader, List<Player> playerOneOpponent, String symbol, String number) {
        return new Player(symbol, number, board, gameEnder, printStream, inputReader, playerOneOpponent);
    }

    private static GameEnder gameEnder(List<String> cells, Board board) {
        List<EndCondition> endConditions = asList(
                new ThreeInARowWinsEndCondition(asList(
                        new ThreeInARowCondition(1, 2, 3, board),
                        new ThreeInARowCondition(4, 5, 6, board),
                        new ThreeInARowCondition(7, 8, 9, board),
                        new ThreeInARowCondition(1, 4, 7, board),
                        new ThreeInARowCondition(2, 5, 8, board),
                        new ThreeInARowCondition(3, 6, 9, board),
                        new ThreeInARowCondition(1, 5, 9, board),
                        new ThreeInARowCondition(3, 5, 7, board)
                )),
                new NoEmptyCellsEndCondition(cells)
        );
        return new GameEnder(endConditions);
    }

}
