package com.tictactoe.models;

import com.tictactoe.enums.PlayerType;
import com.tictactoe.enums.Sign;

import java.util.Random;
import java.util.Scanner;

import static com.tictactoe.enums.PlayerType.COMPUTER;
import static com.tictactoe.enums.PlayerType.HUMAN;

public class Player {

    private Sign sign;
    private PlayerType playerType;
    private Board board;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player(Sign sign, PlayerType playerType, Board board) {
        this.sign = sign;
        this.playerType = playerType;
        this.board = board;
    }


    public void setSign(Sign sign) {
        this.sign = sign;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Sign getSign() {
        return sign;
    }

    public void getMove() throws ArrayIndexOutOfBoundsException {
        if (playerType == HUMAN) {
            Scanner scanner = new Scanner(System.in);
            int x = -1;
            do {
                try {
                    System.out.println("Podaj rzad znaku (1-3):");
                    x = Integer.valueOf(scanner.next()) - 1;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } while (x < 0 || x > 2);

            System.out.println("Podaj kolumne znaku (1-3):");
            int y = Integer.parseInt(scanner.next()) - 1;

            // do while warunek - jezeli miejsce jest zajete zapytaj jeszcze raz
            if (board.isEmptyCell(x, y)) {
                board.setBoard(x, y, sign);
            } else {
                getMove();
            }
        } else {
            wayToWin();
        }


    }

    public void computerRandomMove() {
        Random rnd = new Random();
        int row;
        int column;

        do {
            row = rnd.nextInt(3);
            column = rnd.nextInt(3);
        } while (!board.isEmptyCell(row, column));

        System.out.println("CPU random move");

        board.setBoard(row, column, sign);
    }


    public boolean computerMoveToWin() {

        //Sprawdzenie wierszy
        for (int r = 0; r < 3; r++) {
            if (board.getBoard(r, 0) == sign && board.getBoard(r, 1) == sign && board.getBoard(r, 2) == Sign._) {
                board.setBoard(r, 2, sign);
                return true;
            }
            if (board.getBoard(r, 0) == sign && board.getBoard(r, 2) == sign && board.getBoard(r, 1) == Sign._) {
                board.setBoard(r, 1, sign);
                return true;
            }
            if (board.getBoard(r, 1) == sign && board.getBoard(r, 2) == sign && board.getBoard(r, 0) == Sign._) {
                board.setBoard(r, 0, sign);
                return true;
            }
        }

        //Sprawdzenie kolumn
        for (int c = 0; c < 3; c++) {
            if (board.getBoard(0, c) == sign && board.getBoard(1, c) == sign && board.getBoard(2, c) == Sign._) {
                board.setBoard(2, c, sign);
                return true;
            }
            if (board.getBoard(0, c) == sign && board.getBoard(2, c) == sign && board.getBoard(1, c) == Sign._) {
                board.setBoard(1, c, sign);
                return true;
            }
            if (board.getBoard(1, c) == sign && board.getBoard(2, c) == sign && board.getBoard(0, c) == Sign._) {
                board.setBoard(0, c, sign);
                return true;
            }
        }

        // Sprawdzenie skosu \
        if (board.getBoard(0, 0) == sign && board.getBoard(1, 1) == sign && board.getBoard(2, 2) == Sign._) {
            board.setBoard(2, 2, sign);
            return true;
        }
        if (board.getBoard(1, 1) == sign && board.getBoard(2, 2) == sign && board.getBoard(0, 0) == Sign._) {
            board.setBoard(0, 0, sign);
            return true;
        }
        if (board.getBoard(0, 0) == sign && board.getBoard(2, 2) == sign && board.getBoard(1, 1) == Sign._) {
            board.setBoard(1, 1, sign);
            return true;
        }

        // Sprawdzenie skou /
        if (board.getBoard(0, 2) == sign && board.getBoard(1, 1) == sign && board.getBoard(2, 0) == Sign._) {
            board.setBoard(2, 0, sign);
            return true;
        }
        if (board.getBoard(1, 1) == sign && board.getBoard(2, 0) == sign && board.getBoard(0, 2) == Sign._) {
            board.setBoard(0, 2, sign);
            return true;
        }
        if (board.getBoard(2, 0) == sign && board.getBoard(0, 2) == sign && board.getBoard(1, 1) == Sign._) {
            board.setBoard(1, 1, sign);
            return true;
        }

        return false;

    }

    public boolean computerMoveToBlock() {

        Sign opponentsSing;

        if (getSign() == Sign.X) {
            opponentsSing = Sign.O;
        } else {
            opponentsSing = Sign.X;
        }

        //Sprawdzenie wierszy
        for (int r = 0; r < 3; r++) {
            if (board.getBoard(r, 0) == opponentsSing && board.getBoard(r, 1) == opponentsSing && board.getBoard(r, 2) == Sign._) {
                board.setBoard(r, 2, sign);
                return true;
            }
            if (board.getBoard(r, 0) == opponentsSing && board.getBoard(r, 2) == opponentsSing && board.getBoard(r, 1) == Sign._) {
                board.setBoard(r, 1, sign);
                return true;
            }
            if (board.getBoard(r, 1) == opponentsSing && board.getBoard(r, 2) == opponentsSing && board.getBoard(r, 0) == Sign._) {
                board.setBoard(r, 0, sign);
                return true;
            }
        }

        //Sprawdzenie kolumn
        for (int c = 0; c < 3; c++) {
            if (board.getBoard(0, c) == opponentsSing && board.getBoard(1, c) == opponentsSing && board.getBoard(2, c) == Sign._) {
                board.setBoard(2, c, sign);
                return true;
            }
            if (board.getBoard(0, c) == opponentsSing && board.getBoard(2, c) == opponentsSing && board.getBoard(1, c) == Sign._) {
                board.setBoard(1, c, sign);
                return true;
            }
            if (board.getBoard(1, c) == opponentsSing && board.getBoard(2, c) == opponentsSing && board.getBoard(0, c) == Sign._) {
                board.setBoard(0, c, sign);
                return true;
            }
        }

        // Sprawdzenie skosu \
        if (board.getBoard(0, 0) == opponentsSing && board.getBoard(1, 1) == opponentsSing && board.getBoard(2, 2) == Sign._) {
            board.setBoard(2, 2, sign);
            return true;
        }
        if (board.getBoard(1, 1) == opponentsSing && board.getBoard(2, 2) == opponentsSing && board.getBoard(0, 0) == Sign._) {
            board.setBoard(0, 0, sign);
            return true;
        }
        if (board.getBoard(0, 0) == opponentsSing && board.getBoard(2, 2) == opponentsSing && board.getBoard(1, 1) == Sign._) {
            board.setBoard(1, 1, sign);
            return true;
        }

        // Sprawdzenie skosu /
        if (board.getBoard(0, 2) == opponentsSing && board.getBoard(1, 1) == opponentsSing && board.getBoard(2, 0) == Sign._) {
            board.setBoard(2, 0, sign);
            return true;
        }
        if (board.getBoard(1, 1) == opponentsSing && board.getBoard(2, 0) == opponentsSing && board.getBoard(0, 2) == Sign._) {
            board.setBoard(0, 2, sign);
            return true;
        }
        if (board.getBoard(2, 0) == opponentsSing && board.getBoard(0, 2) == opponentsSing && board.getBoard(1, 1) == Sign._) {
            board.setBoard(1, 1, sign);
            return true;
        }

        return false;
    }

    public void wayToWin() {

        if (computerMoveToWin()) {
            System.out.println("CPU to win move");
            return;
        } else if (computerMoveToBlock()) {
            System.out.println("CPU to block move");
            return;
        }

        computerRandomMove();
    }


}

