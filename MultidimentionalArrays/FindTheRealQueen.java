package MultidimentionalArrays;

import java.util.*;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dim = 8;

        char[][] matrix = new char[dim][dim];

        for (int i = 0; i < dim; i++) {

            String[] line = scanner.nextLine().split(" ");

            for (int j = 0; j < dim; j++) {
                matrix[i][j] = line[j].charAt(0);
            }
        }

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == 'q') {
                    if (IsValidQueen(matrix, i, j)) {
                        System.out.println(i + " " + j);
                    }
                }
            }
        }
    }

    private static boolean IsValidQueen(char[][] matrix, int row, int col) {

        return (IsValidRow(matrix, row) && IsValidColumn(matrix, col)
                && IsValidFirstDiagonal(matrix, row, col) && IsValidSecondDiagonal(matrix, row, col));
    }

    private static boolean IsValidRow(char[][] matrix, int row) {
        int queenCount = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[row][i] == 'q') {
                queenCount++;
            }
        }

        return queenCount == 1;
    }


    private static boolean IsValidColumn(char[][] matrix, int col) {
        int queenCount = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] == 'q') {
                queenCount++;
            }
        }
        return queenCount == 1;
    }

    private static boolean IsValidSecondDiagonal(char[][] matrix, int row, int col) {
        int queenCount = 0;

        for (int i = 1; row - i >= 0 && col + i < matrix.length; i++) {
            if (matrix[row - i][col + i] == 'q') {
                queenCount++;
            }
        }

        for (int i = 1; row + i < matrix.length && col - i >= 0; i++) {
            if (matrix[row + i][col - i] == 'q') {
                queenCount++;
            }
        }
        return queenCount == 0;
    }

    private static boolean IsValidFirstDiagonal (char[][] matrix, int row, int col) {
        int queenCount = 0;

        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if (matrix[row - i][col - i] == 'q') {
                queenCount++;
            }
        }

        for (int i = 1; row + i < matrix.length && col + i < matrix.length; i++) {
            if (matrix[row + i][col + i] == 'q') {
                queenCount++;
            }
        }

        return queenCount == 0;
    }


}
