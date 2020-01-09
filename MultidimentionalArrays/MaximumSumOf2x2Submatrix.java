package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int row = dim[0];
        int col = dim[1];

        int[][] matrix = new int[row][];

        for (int i = 0; i < row; i++) {
            int[] line = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < col; j++) {
                matrix[i] = line;
            }
        }

        int result = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < matrix.length - 1; i++) {

            for (int j = 0; j < matrix[i].length - 1; j++) {
                if ((matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1] > result) ) {
                    result = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
                    sb = new StringBuilder();
                    sb.append(matrix[i][j]).append(" ").append(matrix[i][j + 1]).append(System.lineSeparator())
                            .append(matrix[i + 1][j]).append(" ").append(matrix[i + 1][j + 1]);
                }
            }
        }

        System.out.println(sb);
        System.out.println(result);
    }
}
