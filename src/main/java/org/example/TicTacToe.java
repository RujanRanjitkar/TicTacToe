package org.example;

import java.util.Scanner;

public class TicTacToe {
    // For  Displaying The table format of Tic Tac Toe
    //Since pattern method  is static we can directly call it form main method
    //It takes 2 dimensional array as parameter
    static void pattern(String[][] arr) {
        System.out.println("-------");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("|");
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "|");
            }
            System.out.println("\n-------");
        }
    }

    static boolean checkWinner(String[][] arr, String symbol) {
        if (   // for rows
                arr[0][0].equals(symbol) && arr[0][1].equals(symbol) && arr[0][2].equals(symbol) ||
                        arr[1][0].equals(symbol) && arr[1][1].equals(symbol) && arr[1][2].equals(symbol) ||
                        arr[2][0].equals(symbol) && arr[2][1].equals(symbol) && arr[2][2].equals(symbol) ||

                        // for columns
                        arr[0][0].equals(symbol) && arr[1][0].equals(symbol) && arr[2][0].equals(symbol) ||
                        arr[0][1].equals(symbol) && arr[1][1].equals(symbol) && arr[2][1].equals(symbol) ||
                        arr[0][2].equals(symbol) && arr[1][2].equals(symbol) && arr[2][2].equals(symbol) ||

                        // for diagonals
                        arr[0][0].equals(symbol) && arr[1][1].equals(symbol) && arr[2][2].equals(symbol) ||
                        arr[0][2].equals(symbol) && arr[1][1].equals(symbol) && arr[2][0].equals(symbol)

        ) {
            System.out.println("Player " + symbol + " Wins");
            return true;
        }
        return false;
    }

    static boolean checkEmptyCell(String[][] arr, String symbol, int a, int b) {
        if (arr[a][b].equals(" ")) {
            arr[a][b] = symbol;
            return false;
        } else {
            System.out.println("The cell arr[" + a + "][" + b + "] is already occupied");
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //2 dimensional array with empty values in index
        String[][] arr = {{" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}};
        pattern(arr);
        String symbol = " ";


        // 9 boxes so for loop executes 9 times
        for (int i = 0; i < 9; i++) {
            //if value of i is even then its turn of player 1 and he possesses 0
            if (i % 2 == 0) {
                System.out.println("Player 1 turn (0):");
                symbol = "0";
            } else {
                //if value of i is odd then its turn of player 2 and he possesses X
                System.out.println("Player 2 turn (X):");
                symbol = "X";
            }
            int index = sc.nextInt();
            // As per the index and value of i, assign symbols in array index
            switch (index) {
                case 7:
                    if (checkEmptyCell(arr, symbol, 0, 0)) {
                        i--;
                    }
                    break;
                case 8:
                    if (checkEmptyCell(arr, symbol, 0, 1)) {
                        i--;
                    }
                    break;
                case 9:
                    if (checkEmptyCell(arr, symbol, 0, 2)) {
                        i--;
                    }
                    break;
                case 4:
                    if (checkEmptyCell(arr, symbol, 1, 0)) {
                        i--;
                    }
                    break;
                case 5:
                    if (checkEmptyCell(arr, symbol, 1, 1)) {
                        i--;
                    }
                    break;
                case 6:
                    if (checkEmptyCell(arr, symbol, 1, 2)) {
                        i--;
                    }
                    break;
                case 1:
                    if (checkEmptyCell(arr, symbol, 2, 0)) {
                        i--;
                    }
                    break;
                case 2:
                    if (checkEmptyCell(arr, symbol, 2, 1)) {
                        i--;
                    }
                    break;
                case 3:
                    if (checkEmptyCell(arr, symbol, 2, 2)) {
                        i--;
                    }
                    break;
                default:
                    System.out.println("Invalid Index. Applicable index are (1 to 9)");
                    i--;
            }
            pattern(arr);

            // To check winner
            if (i > 3) {
                if (checkWinner(arr, symbol)) {
                    break;
                }
            }

            //In case of tie
            if (i == 8) {
                System.out.println("It's a tieeeeee");
                break;
            }
        }
    }
}