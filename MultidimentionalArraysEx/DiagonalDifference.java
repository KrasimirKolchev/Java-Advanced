package MultidimentionalArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dim = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[dim][];

        for (int i = 0; i < matrix.length; i++) {
            int[] line = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = line;
        }
        System.out.println(Math.abs(CalculateDiagonals(matrix)));
    }

    public static int CalculateDiagonals(int[][] matrix) {
        int first = 0;
        int second = 0;
        int row = 0;

        while (row < matrix.length) {

            for (int j = 0, k = matrix.length - 1; j < matrix.length && k >= 0; j++, k--) {
                first += matrix[row][j];
                second += matrix[row][k];
                row++;
            }
        }

        return first - second;
    }
}
