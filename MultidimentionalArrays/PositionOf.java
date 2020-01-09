package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int row = dim[0];
        int col = dim[1];

        int[][] matrix = new int[row][];

        for (int i = 0; i < row; i++) {
            int[] line = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = line;
        }

        int numToCheck = Integer.parseInt(scanner.nextLine());
        boolean found = false;

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                if (numToCheck == matrix[i][j]) {
                    System.out.println(i + " " + j);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("not found");
        }
    }
}
