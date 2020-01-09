package MultidimentionalArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int row = dim[0];
        int col = dim[1];

        String[][] matrix = new String[row][col];

        for (int i = 0; i < matrix.length; i++) {
            char symbol = 'a';
            symbol += i;
            for (int j = 0; j < matrix[i].length; j++) {
                StringBuilder text = new StringBuilder();
                text.append(symbol).append((char)(symbol + j)).append(symbol);
                matrix[i][j] = text.toString();
            }
        }
        printMatrix(matrix);
    }

    public static void printMatrix(String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
