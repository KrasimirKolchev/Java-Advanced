package ExamPrep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheGarden {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());

        char[][] garden = new char[rows][];

        for (int i = 0; i < rows; i++) {
            String[] info = reader.readLine().split("\\s+");
            char[] chars = new char[info.length];

            for (int j = 0; j < info.length; j++) {
                chars[j] = info[j].charAt(0);
            }
            garden[i] = chars;
        }
        int carrot = 0;
        int letuce = 0;
        int potato = 0;
        int damaged = 0;
        String command;

        while (!"End of Harvest".equals(command = reader.readLine())) {
            String[] info = command.split("\\s+");
            int row = Integer.parseInt(info[1]);
            int col = Integer.parseInt(info[2]);

            switch (info[0]) {
                case "Harvest" :
                    if (isValid(garden, row, col)) {

                        char vegetable = garden[row][col];
                        if (vegetable == 'C') {
                            carrot++;
                        } else if (vegetable == 'L') {
                            letuce++;
                        } else if (vegetable == 'P') {
                            potato++;
                        }
                        garden[row][col] = ' ';
                    }
                    break;
                case "Mole" :
                    String direction = info[3];

                    switch (direction) {
                        case "up" :
                            while (isValid(garden, row, col)) {
                                garden[row][col] = ' ';
                                damaged++;
                                row-=2;
                            }
                            break;
                        case "down" :
                            while (isValid(garden, row, col)) {
                                garden[row][col] = ' ';
                                damaged++;
                                row+=2;
                            }
                            break;
                        case "left" :
                            while (isValid(garden, row, col)) {
                                garden[row][col] = ' ';
                                damaged++;
                                col-=2;
                            }
                            break;
                        case "right" :
                            while (isValid(garden, row, col)) {
                                garden[row][col] = ' ';
                                damaged++;
                                col+=2;
                            }
                            break;
                    }
                    break;
            }
        }
        printMatrix(garden);
        System.out.println(String.format("Carrots: %d\nPotatoes: %d\nLettuce: %d\nHarmed vegetables: %d",
                carrot, potato, letuce, damaged));
    }

    private static void printMatrix(char[][] garden) {

        for (int i = 0; i < garden.length; i++) {
            for (int j = 0; j < garden[i].length; j++) {
                System.out.print(garden[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValid(char[][] garden, int row, int col) {
        return row >= 0 && col >= 0 && row < garden.length && col < garden[row].length
                && isValidSymbol(garden, row, col);
    }

    private static boolean isValidSymbol(char[][] garden, int row, int col) {
        return garden[row][col] == 'L' || garden[row][col] == 'P' || garden[row][col] == 'C';
    }
}
