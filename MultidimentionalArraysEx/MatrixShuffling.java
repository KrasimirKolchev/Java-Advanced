package MultidimentionalArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int row = dim[0];
        int col = dim[1];
        int[][] matrix = new int[row][];
        for (int i = 0; i < row; i++) {

            int[] line = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[i] = line;
        }

        String command;

        while (!"END".equals(command = scanner.nextLine())) {
            String[] input = command.split(" ");

            if (input.length != 5 || !input[0].equals("swap")) {
                System.out.println("Invalid input!");
            } else if (!isInside(input, row, col)) {
                System.out.println("Invalid input!");
            } else {
                matrix = swapMatrix(matrix, input);
                printMatrix(matrix);
            }
        }
    }

    public static void printMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] swapMatrix(int[][] matrix, String[] input) {
        int a = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);
        int a1 = Integer.parseInt(input[3]);
        int b1 = Integer.parseInt(input[4]);

        int temp = matrix[a][b];
        matrix[a][b] = matrix[a1][b1];
        matrix[a1][b1] = temp;

        return matrix;
    }

    private static boolean isInside(String[] input, int row, int col) {
        int a = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);
        int a1 = Integer.parseInt(input[3]);
        int b1 = Integer.parseInt(input[4]);

        if (a < 0 || a >= row || b < 0 || b >= col || a1 < 0 || a1 >= row || b1 < 0 || b1 >= col) {
            return false;
        }

        return true;
    }

}
