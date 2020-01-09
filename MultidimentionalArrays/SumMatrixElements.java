package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int row = dim[0];
        int col = dim[1];

        System.out.printf("%d%n%d%n", row, col);

        int[][] matrix = new int[row][col];

        int result = 0;

        for (int i = 0; i < row; i++) {
            int[] line = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < col; j++) {
                matrix[i][j] = line[j];
                result += line[j];
            }
        }

        System.out.println(result);
    }
}
