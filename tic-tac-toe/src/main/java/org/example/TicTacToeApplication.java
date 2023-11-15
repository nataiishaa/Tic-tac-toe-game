package org.example;

import java.util.Scanner;

public class TicTacToeApplication {
    static Scanner scanner;
    static char[][] map;
    static final int MAP_SIZE = 3;
    static final char EMPTY_FILED = '*';
    static final char X_FILED = 'X';
    static final char O_FILED = 'O';

    public static void main(String[] args) {
        init();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(X_FILED)) {
                System.out.println("Game over. You win!");
                break;
            }
            if (checkDraft()) {
                System.out.println("Game over. Draw");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(X_FILED)) {
                System.out.println("Game over. Computer win");
                break;
            }
            if (checkDraft()) {
                System.out.println("Game over. Draw");
                break;
            }

        }

    }

    public static boolean checkWin(char playerField) {
        if (map[0][0] == playerField && map[0][1] == playerField && map[0][2] == playerField) return true;
        if (map[1][0] == playerField && map[0][1] == playerField && map[1][2] == playerField) return true;
        if (map[2][0] == playerField && map[0][1] == playerField && map[2][2] == playerField) return true;

        if (map[0][0] == playerField && map[1][0] == playerField && map[2][0] == playerField) return true;
        if (map[0][1] == playerField && map[1][1] == playerField && map[2][1] == playerField) return true;
        if (map[0][2] == playerField && map[1][2] == playerField && map[2][2] == playerField) return true;

        if (map[0][0] == playerField && map[1][1] == playerField && map[2][2] == playerField) return true;
        if (map[0][2] == playerField && map[1][1] == playerField && map[2][0] == playerField) return true;
        return false;

    }

    public static boolean checkDraft() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == EMPTY_FILED) {
                    return false;
                }
            }

        }
        return true;
    }

    public static boolean isSellEmpty(int x, int y) {
        if (x < 0 || y < 0 || x >= MAP_SIZE || y >= MAP_SIZE) {
            return false;
        }
        if (map[y][x] != EMPTY_FILED) {
            return false;
        }
        return true;

    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Your turn. Enter the coordinates of your move X Y");

            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isSellEmpty(x, y));
        map[y][x] = X_FILED;

        //System.out.println("You enter  " + x + " " + y);
    }

    public static void aiTurn() {
        int x, y;
        System.out.println("Opponent's move");
        do {

            x = (int) (Math.random() * MAP_SIZE);
            y = (int) (Math.random() * MAP_SIZE);
        } while (!isSellEmpty(x, y));
        map[y][x] = O_FILED;

        //System.out.println("You enter  " + x + " " + y);
    }

    public static void printMap() {
        for (int i = 0; i <= MAP_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();  // New line.
        for (int i = 0; i < MAP_SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(map[i][j] + " ");

            }
            System.out.println();  // New line.
        }
        System.out.println();  // New line.
    }

    public static void init() {
        map = new char[MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = EMPTY_FILED;
            }

        }
        scanner = new Scanner(System.in);

    }
}
