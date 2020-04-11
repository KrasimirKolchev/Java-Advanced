package ExamPrep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TronRacers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int firstRow = 0;
        int firstCol = 0;
        int secondRow = 0;
        int secondCol = 0;

        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line.charAt(j);
                if (line.charAt(j) == 'f') {
                    firstRow = i;
                    firstCol = j;
                } else if (line.charAt(j) == 's') {
                    secondRow = i;
                    secondCol = j;
                }
            }
        }

        while (true) {
            String[] command = reader.readLine().split("\\s+");

            switch (command[0]) {
                case "up" :
                    if (firstRow - 1 >= 0) {
                        firstRow--;
                    } else {
                        firstRow = matrix.length - 1;
                    }
                    break;
                case "down" :
                    if (firstRow + 1 < matrix.length) {
                        firstRow++;
                    } else {
                        firstRow = 0;
                    }
                    break;
                case "left" :
                    if (firstCol - 1 >= 0) {
                        firstCol--;
                    } else {
                        firstCol = matrix[0].length - 1;
                    }
                    break;
                case "right" :
                    if (firstCol + 1 < matrix[0].length) {
                        firstCol++;
                    } else {
                        firstCol = 0;
                    }
                    break;
            }
            if (matrix[firstRow][firstCol] != 's') {
                matrix[firstRow][firstCol] = 'f';
            } else {
                matrix[firstRow][firstCol] = 'x';
                printMatrix(matrix);
                return;
            }

            switch (command[1]) {
                case "up" :
                    if (secondRow - 1 >= 0) {
                        secondRow--;
                    } else {
                        secondRow = matrix.length - 1;
                    }
                    break;
                case "down" :
                    if (secondRow + 1 < matrix.length) {
                        secondRow++;
                    } else {
                        secondRow = 0;
                    }
                    break;
                case "left" :
                    if (secondCol - 1 >= 0) {
                        secondCol--;
                    } else {
                        secondCol = matrix[0].length - 1;
                    }
                    break;
                case "right" :
                    if (secondCol + 1 < matrix[0].length) {
                        secondCol++;
                    } else {
                        secondCol = 0;
                    }
                    break;
            }

            if (matrix[secondRow][secondCol] != 'f') {
                matrix[secondRow][secondCol] = 's';
            } else {
                matrix[secondRow][secondCol] = 'x';
                printMatrix(matrix);
                return;
            }
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
