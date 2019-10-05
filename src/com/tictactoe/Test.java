package com.tictactoe;

import com.tictactoe.enums.PlayerType;
import com.tictactoe.enums.Sign;
import com.tictactoe.models.Board;
import com.tictactoe.models.Player;
import com.tictactoe.utils.Print;

public class Test {
    public static void main(String[] args) {
        Board board;
        Board board1;

//        board = new com.tictactoe.models.Board();
//        board.setBoard(0, 0, com.tictactoe.enums.Sign.X);
//        board.setBoard(1, 1, com.tictactoe.enums.Sign.X);
//        board.setBoard(2, 2, com.tictactoe.enums.Sign.X);
//        com.tictactoe.utils.Print.printBoard(board);
//        System.out.println("checkForWin: " + board.checkForWin());
//
//        //------------------
//        board = new com.tictactoe.models.Board();
//        board.setBoard(0, 0, com.tictactoe.enums.Sign.X);
//        board.setBoard(0, 1, com.tictactoe.enums.Sign.X);
//        board.setBoard(0, 2, com.tictactoe.enums.Sign.X);
//        board.setBoard(1, 0, com.tictactoe.enums.Sign.X);
//        board.setBoard(1, 1, com.tictactoe.enums.Sign.X);
//        board.setBoard(1, 2, com.tictactoe.enums.Sign.X);
//        board.setBoard(2, 0, com.tictactoe.enums.Sign.X);
//        board.setBoard(2, 1, com.tictactoe.enums.Sign.X);
//        board.setBoard(2, 2, com.tictactoe.enums.Sign.X);
//        com.tictactoe.utils.Print.printBoard(board);
//        System.out.println("checkBoardIsFull: " + board.checkBoardIsFull());

        //------------------
        board = new Board();
        Player player = new Player(Sign.O, PlayerType.COMPUTER, board);

        board.setBoard(0, 0, Sign.O);
        board.setBoard(1, 1, Sign.O);
        board.setBoard(2, 0, Sign._);
//        board.setBoard(1, 0, com.tictactoe.enums.Sign.O);
        // sprawdzenie move to win
        Print.printBoard(board);
        player.computerMoveToBlock();
        System.out.println("------------------- CPU MOVE TO Block ------------------------------");
        Print.printBoard(board);




//        com.tictactoe.utils.Print.printBoard(board);
//        player.computerRandomMove();
//        player.computerRandomMove();
//        player.computerRandomMove();
//        player.computerRandomMove();
//        System.out.println("--------------------------------------  PO RUCHU KOMPUTERA RANDOM --------------------------");
//        com.tictactoe.utils.Print.printBoard(board);





    }
}
