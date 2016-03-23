package com.thoughtworks.continuinglearning.functionaltictactoe;

public class Main {

    public static void main(String[] args) {
        new Game(new Board(System.out)).start();
    }
}
