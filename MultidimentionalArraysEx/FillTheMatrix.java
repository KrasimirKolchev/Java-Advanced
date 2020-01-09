package MultidimentionalArraysEx;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int size = Integer.parseInt(input[0]);
        String type = input[1];
        int[][] matrix = new int[size][size];

        switch (type) {
            case "A" :
                MatrixPatternA(matrix);
                break;
            case "B" :
                MatrixPatternB(matrix);
                break;
        }

        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }


    public static int[][] MatrixPatternA (int[][] matrix) {
        int start = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = start;
                start++;
            }
        }
        return matrix;
    }

    public static int[][] MatrixPatternB (int[][] matrix) {
        int start = 1;

        for (int i = 0; i < matrix.length; i++) {

            if (i % 2 == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = start;
                    start++;
                }
            } else {
                for (int j = matrix.length - 1; j >= 0; j--) {
                    matrix[j][i] = start;
                    start++;
                }
            }
        }
        return matrix;
    }
}
