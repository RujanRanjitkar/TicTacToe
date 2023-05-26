package org.example;

import java.util.Scanner;

public class TTT {
    static void pattern(String[] arr) {
        System.out.println("-------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[(i * 3) + j] + "|");
            }
            System.out.println("\n-------");
        }
    }

    static boolean checkWinner(String[] arr, String symbol) {
        if (
                (arr[0].equals(symbol) && arr[1].equals(symbol) && arr[2].equals(symbol)) ||
                        (arr[3].equals(symbol) && arr[4].equals(symbol) && arr[5].equals(symbol)) ||
                        (arr[6].equals(symbol) && arr[7].equals(symbol) && arr[8].equals(symbol)) ||

                        (arr[0].equals(symbol) && arr[3].equals(symbol) && arr[7].equals(symbol)) ||
                        (arr[1].equals(symbol) && arr[4].equals(symbol) && arr[7].equals(symbol)) ||
                        (arr[2].equals(symbol) && arr[5].equals(symbol) && arr[8].equals(symbol)) ||

                        (arr[0].equals(symbol) && arr[4].equals(symbol) && arr[8].equals(symbol)) ||
                        (arr[2].equals(symbol) && arr[4].equals(symbol) && arr[6].equals(symbol))
        ) {
            System.out.println("Player " + symbol + " wins");
            return true;
        }
        return false;
    }

    static boolean checkEmptyCell(String[] arr, String symbol, int a) {
        if (arr[a].equals(" ")) {
            arr[a] = symbol;
            return false;
        } else {
            System.out.println("The cell " + a + " is already occupied");
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
        pattern(arr);
        String symbol = " ";
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                System.out.println("Player 0's turn:");
                symbol = "0";
            } else {
                System.out.println("Player X's turn:");
                symbol = "X";
            }
            int index = sc.nextInt();
            switch (index) {
                case 1:
                    if (checkEmptyCell(arr, symbol, 0)) {
                        i--;
                    }
                    break;
                case 2:
                    if (checkEmptyCell(arr, symbol, 1)) {
                        i--;
                    }
                    break;
                case 3:
                    if (checkEmptyCell(arr, symbol, 2)) {
                        i--;
                    }
                    break;
                case 4:
                    if (checkEmptyCell(arr, symbol, 3)) {
                        i--;
                    }
                    break;
                case 5:
                    if (checkEmptyCell(arr, symbol, 4)) {
                        i--;
                    }
                    break;
                case 6:
                    if (checkEmptyCell(arr, symbol, 5)) {
                        i--;
                    }
                    break;
                case 7:
                    if (checkEmptyCell(arr, symbol, 6)) {
                        i--;
                    }
                    break;
                case 8:
                    if (checkEmptyCell(arr, symbol, 7)) {
                        i--;
                    }
                    break;
                case 9:
                    if (checkEmptyCell(arr, symbol, 8)) {
                        i--;
                    }
                    break;
                default:
                    System.out.println("Invalid Index. Applicable index are (1 to 9)");
                    i--;
            }
            pattern(arr);
            if (i > 3) {
                if (checkWinner(arr, symbol)) {
                    break;
                }
            }
            if (i == 8) {
                System.out.println("It's a tieeeeee");
            }
        }
    }
}
