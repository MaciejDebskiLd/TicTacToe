package com.tictactoe.models;

import com.tictactoe.enums.Sign;

public class Board {

    private Sign[][] board = new Sign[3][3];

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Sign._;
            }

        }
    }

    public Sign getBoard(int row, int column) {
        return board[row][column];
    }


    public void setBoard(int row, int column, Sign sign) {
        this.board[row][column] = sign;
    }

    public boolean checkBoardIsFull() {

        boolean isFull = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Sign._) {
                    isFull = false;
                }
            }

        }

        return isFull;
    }

    public boolean isEmptyCell(int row, int column) {
        return board[row][column] == Sign._;
    }


    public boolean checkForWin() {

        for (int r = 0; r < 3; r++) {
            if (board[r][0] == board[r][1] && board[r][1] == board[r][2] && board[r][0] != Sign._)
                return true;
        }

        for (int c = 0; c < 3; c++) {
            if (board[0][c] == board[1][c] && board[1][c] == board[2][c] && board[0][c] != Sign._)
                return true;
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != Sign._)
            return true;

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != Sign._)
            return true;

        return false;
    }
}
