package com.thoughtworks.continuinglearning.functionaltictactoe;

import java.io.PrintStream;
import java.util.List;
import java.util.Optional;

public class Player {
    private final String symbol;
    private final Board board;
    private final PrintStream printStream;
    private final ValidInputReader inputReader;
    private final List<Player> otherPlayer;

    public Player(String symbol, Board board, PrintStream printStream, ValidInputReader inputReader, List<Player> otherPlayer) {
        this.symbol = symbol;
        this.board = board;
        this.printStream = printStream;
        this.inputReader = inputReader;
        this.otherPlayer = otherPlayer;
    }

    public void move() {
        printStream.println("Player 1, enter a number between 1 and 9 to make your move.");
        board.mark(inputReader.readInteger(), symbol);
        board.draw();
        board.openCells().
                stream().
                findFirst().
                ifPresent(integer -> otherPlayer.stream().findFirst().get().move());
    }
}
