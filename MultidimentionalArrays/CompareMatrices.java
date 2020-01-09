package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int row1 = dim[0];
        int col1 = dim[1];

        int[][] firstMatrix = new int[row1][];

        for (int i = 0; i < row1; i++) {
            int[] line = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            firstMatrix[i] = line;
        }

        dim = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int row2 = dim[0];
        int col2 = dim[1];

        int[][] secondMatrix = new int[row2][];

        for (int i = 0; i < row2; i++) {
            int[] line = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            secondMatrix[i] = line;
        }

        if (row1 != row2 || col1 != col2) {
            System.out.println("not equal");
            return;
        } else {
            for (int row = 0; row < firstMatrix.length; row++) {

                for (int col = 0; col < firstMatrix[row].length; col++) {

                    if (firstMatrix[row][col] != secondMatrix[row][col]) {
                        System.out.println("not equal");
                        return;
                    }
                }
            }
        }
        System.out.println("equal");
    }
}
