package MultidimentionalArrays;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[row][col];
        char[][] secondMatrix = new char[row][col];

        for (int i = 0; i < row * 2; i++) {

            String[] line = scanner.nextLine().split("\\s+");

            for (int j = 0; j < col; j++) {

                if (i < row) {
                    firstMatrix[i][j] = line[j].charAt(0);
                } else {
                    secondMatrix[i - row][j] = line[j].charAt(0);
                }
            }
        }


        char[][] resultMatrix = new char[row][col];

        for (int row1 = 0; row1 < firstMatrix.length; row1++) {

            for (int col1 = 0; col1 < firstMatrix[row1].length; col1++) {

                if (firstMatrix[row1][col1] == secondMatrix[row1][col1]) {
                    resultMatrix[row1][col1] = firstMatrix[row1][col1];
                } else {
                    resultMatrix[row1][col1] = '*';
                }
            }
        }

        for (int i = 0; i < resultMatrix.length; i++) {
            System.out.println();
            for (int j = 0; j < resultMatrix[i].length; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
        }
    }
}
