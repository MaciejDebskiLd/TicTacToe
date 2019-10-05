package com.tictactoe.utils;

import com.tictactoe.models.Board;

import java.util.Scanner;

public class Print {

    public static void printBoard(Board board){

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board.getBoard(i, j) + "|");
            }
            System.out.println();
            System.out.println("--------");
        }
    }

    public static int menu() {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *       MENU - WYBIERZ TRYB GRY        *");
        System.out.println("     ****************************************");
        System.out.println("     1. Człowiek - Człowiek");
        System.out.println("     2. Człowiek - Komputer");
        System.out.println("     3. Komputer - Człowiek");
        System.out.println("     4. Komputer - Komputer");

        selection = input.nextInt();
        return selection;


    }

}