package MultidimentionalArraysEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int playerRow = 0;
        int playerCol = 0;
        char[][] matrix = new char[n][m];
        ArrayDeque<String> bunnies = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < line.length(); j++) {
                matrix[i][j] = line.charAt(j);
                if (line.charAt(j) == 'P') {
                    playerRow = i;
                    playerCol = j;
                } else if (line.charAt(j) == 'B') {
                    bunnies.offer(String.format("%d, %d", i, j));
                }
            }
        }

        String command = scanner.nextLine();

        for (int i = 0; i < command.length(); i++) {
            char direction = command.charAt(i);

            switch (direction) {
                case 'U' :
                    if (playerRow - 1 >= 0 && matrix[playerRow - 1][playerCol] != 'B') {
                        matrix[playerRow][playerCol] = '.';
                        matrix[playerRow - 1][playerCol] = 'P';
                        playerRow = playerRow - 1;
                    } else if (playerRow - 1 < 0) {
                        matrix[playerRow][playerCol] = '.';
                        printMatrix(matrix);
                        System.out.println(String.format("Won: %d %d", playerRow, playerCol));

                    } else {
                        matrix[playerRow][playerCol] = '.';
                        printMatrix(matrix);
                        System.out.println(String.format("Dead: %d %d", playerRow - 1, playerCol));

                    }
                    break;
                case 'D' :
                    if (playerRow + 1 <= n - 1 && matrix[playerRow + 1][playerCol] != 'B') {
                        matrix[playerRow][playerCol] = '.';
                        matrix[playerRow + 1][playerCol] = 'P';
                        playerRow = playerRow + 1;
                    } else if (playerRow + 1 > n - 1) {
                        matrix[playerRow][playerCol] = '.';
                        printMatrix(matrix);
                        System.out.println(String.format("Won: %d %d", playerRow, playerCol));

                    } else {
                        matrix[playerRow][playerCol] = '.';
                        printMatrix(matrix);
                        System.out.println(String.format("Dead: %d %d", playerRow +1, playerCol));

                    }
                    break;
                case 'L' :
                    if (playerCol - 1 >= 0 && matrix[playerRow][playerCol - 1] != 'B') {
                        matrix[playerRow][playerCol] = '.';
                        matrix[playerRow][playerCol - 1] = 'P';
                        playerCol = playerCol - 1;
                    } else if (playerCol - 1 < 0) {
                        matrix[playerRow][playerCol] = '.';
                        printMatrix(matrix);
                        System.out.println(String.format("Won: %d %d", playerRow, playerCol));

                    } else {
                        matrix[playerRow][playerCol] = '.';
                        printMatrix(matrix);
                        System.out.println(String.format("Dead: %d %d", playerRow, playerCol - 1));

                    }
                    break;
                case 'R' :
                    if (playerCol + 1 <= m - 1 && matrix[playerRow][playerCol + 1] != 'B') {
                        matrix[playerRow][playerCol] = '.';
                        matrix[playerRow][playerCol + 1] = 'P';
                        playerCol = playerCol + 1;
                    } else if (playerCol + 1 > m - 1) {
                        matrix[playerRow][playerCol] = '.';
                        printMatrix(matrix);
                        System.out.println(String.format("Won: %d %d", playerRow, playerCol));

                    } else {
                        matrix[playerRow][playerCol] = '.';
                        printMatrix(matrix);
                        System.out.println(String.format("Dead: %d %d", playerRow, playerCol + 1));

                    }
                    break;
            }
            int times = bunnies.size();
            ArrayDeque<String> newBunnies = new ArrayDeque<>();
            boolean isDead = false;
            int deadRow = 0;
            int deadCol = 0;

            for (int j = 0; j < times; j++) {
                String[] rowCol = bunnies.poll().split(", ");
                int row = Integer.parseInt(rowCol[0]);
                int col = Integer.parseInt(rowCol[1]);



                if (row - 1 >= 0 && matrix[row - 1][col] != 'P') {
                    matrix[row - 1][col] = 'B';
                    bunnies.offer(String.format("%d, %d", row - 1, col));
                    newBunnies.offer(String.format("%d, %d", row - 1, col));
                } else if (row - 1 >= 0 && matrix[row - 1][col] == 'P') {
                    matrix[row - 1][col] = 'B';
                    isDead = true;
                    deadRow = row - 1;
                    deadCol = col;
                }

                if (row + 1 <= n - 1 && matrix[row + 1][col] != 'P') {
                    matrix[row + 1][col] = 'B';
                    bunnies.offer(String.format("%d, %d", row + 1, col));
                    newBunnies.offer(String.format("%d, %d", row + 1, col));
                } else if (row + 1 <= n - 1 && matrix[row + 1][col] == 'P') {
                    matrix[row + 1][col] = 'B';
                    isDead = true;
                    deadRow = row + 1;
                    deadCol = col;
                }

                if (col - 1 >= 0 && matrix[row][col - 1] != 'P') {
                    matrix[row][col - 1] = 'B';
                    bunnies.offer(String.format("%d, %d", row, col - 1));
                    newBunnies.offer(String.format("%d, %d", row, col - 1));
                } else if (col - 1 >= 0 && matrix[row][col - 1] == 'P') {
                    matrix[row][col - 1] = 'B';
                    isDead = true;
                    deadRow = row;
                    deadCol = col - 1;
                }

                if (col + 1 <= m - 1 && matrix[row][col + 1] != 'P') {
                    matrix[row][col + 1] = 'B';
                    bunnies.offer(String.format("%d, %d", row, col + 1));
                    newBunnies.offer(String.format("%d, %d", row, col + 1));
                } else if (col + 1 <= m - 1 && matrix[row][col + 1] == 'P') {
                    matrix[row][col + 1] = 'B';
                    isDead = true;
                    deadRow = row;
                    deadCol = col + 1;
                }

                if (isDead) {
                    printMatrix(matrix);
                    System.out.println(String.format("Dead: %d %d", deadRow, deadCol));
                    return;
                }
            }


            bunnies.clear();
            bunnies = newBunnies;

        }

    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
