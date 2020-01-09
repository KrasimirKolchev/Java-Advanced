package MultidimentionalArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum3x3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int dimA = dim[0];
        int dimB = dim[1];
        int[][] matrix = new int[dimA][];

        for (int i = 0; i < dimA; i++) {
            int[] line = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = line;
        }

        int sum = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < dimA - 2; i++) {
            for (int j = 0; j < dimB - 2; j++) {
                if ((matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] +
                        matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2] +
                        matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2] > sum) ) {
                    sum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] +
                            matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2] +
                            matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                    sb = new StringBuilder();

                    sb.append(matrix[i][j]).append(" ").append(matrix[i][j + 1]).append(" ").append(matrix[i][j + 2])
                            .append(System.lineSeparator()).append(matrix[i + 1][j]).append(" ")
                            .append(matrix[i + 1][j + 1]).append(" ").append(matrix[i + 1][j + 2]).append(System.lineSeparator())
                    .append(matrix[i + 2][j]).append(" ").append(matrix[i + 2][j + 1]).append(" ").append(matrix[i + 2][j + 2]);
                }
            }
        }

        System.out.println("Sum = " + sum);
        System.out.println(sb.toString());
    }
}
