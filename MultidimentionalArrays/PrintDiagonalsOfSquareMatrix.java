package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dim = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[dim][];

        for (int i = 0; i < dim; i++) {
            int[] line = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = line;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.print(matrix[i][j] + " ");
                i++;
            }
        }
        System.out.println();

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < dim; j++) {
                System.out.print(matrix[i][j] + " ");
                i--;
            }
        }
    }
}
