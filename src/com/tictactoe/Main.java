package com.tictactoe;

import com.tictactoe.enums.PlayerType;
import com.tictactoe.enums.Sign;
import com.tictactoe.models.Board;
import com.tictactoe.models.Player;
import com.tictactoe.utils.Print;

public class Main {

    public static void main(String[] args) {

        Board board = new Board();

        Player player1 = new Player(Sign.X, PlayerType.COMPUTER, board);
        Player player2 = new Player(Sign.O, PlayerType.COMPUTER, board);

        switch (Print.menu()) {
                case 1:
                    player1.setPlayerType(PlayerType.HUMAN);
                    player2.setPlayerType(PlayerType.HUMAN);

                    break;
                case 2:
                    player1.setPlayerType(PlayerType.HUMAN);
                    player2.setPlayerType(PlayerType.COMPUTER);

                    break;
                case 3:
                    player1.setPlayerType(PlayerType.COMPUTER);
                    player2.setPlayerType(PlayerType.HUMAN);

                    break;
                case 4:
                    player1.setPlayerType(PlayerType.COMPUTER);
                    player2.setPlayerType(PlayerType.COMPUTER);
                    break;
            }


            do {
                Print.printBoard(board);
                player1.getMove();
                Print.printBoard(board);
                if (board.checkForWin()) {
                    //Wygral p1
                    System.out.println("Wygral P1");
                    break;
                }
                if (board.checkBoardIsFull()) {
                    // Remis
                    System.out.println("Remis");
                    break;
                }
                player2.getMove();
                Print.printBoard(board);
                if (board.checkForWin()) {
                    //Wygral p2
                    System.out.println("Wygral P2");
                    break;
                }
                System.out.println("--------------------- PLANSZA PO RUCHU OBU GRACZY -----------------------------");
            } while (!board.checkBoardIsFull());


        }
    }




