package MultidimentionalArraysEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Crossfie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        ArrayList<ArrayList<Integer>> matrix = fillMatrix(rows, cols);

        String command;

        while (!"Nuke it from orbit".equals(command = scanner.nextLine())) {
            int[] line = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int row = line[0];
            int col = line[1];
            int rad = line[2];

            for (int r = row - rad; r <= row + rad ; r++) {
                if (isInside(matrix, r, col)) {
                    matrix.get(r).set(col, 0);
                }
            }

            for (int c = col - rad; c <= col + rad; c++) {
                if (isInside(matrix, row, c)) {
                    matrix.get(row).set(c, 0);
                }
            }

            for (int i = 0; i < matrix.size(); i++) {
                matrix.get(i).removeAll(new ArrayList<Integer>(){{add(0);}});

                if (matrix.get(i).size() == 0) {
                    matrix.remove(i);
                    i--;
                }
            }
        }

        printMatrix(matrix);
    }

    private static boolean isInside(ArrayList<ArrayList<Integer>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> fillMatrix(int rows, int cols) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        int num = 1;
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(num);
                num++;
            }
            matrix.add(row);
        }
        return matrix;
    }
}
