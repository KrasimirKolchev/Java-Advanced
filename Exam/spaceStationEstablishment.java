package Exam;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class spaceStationEstablishment {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        String[][] matrix = new String[n][n];
        int rowS = 0;
        int colS = 0;
        int h1Row = -1;
        int h1Col = -1;
        int h2Row = -1;
        int h2Col = -1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("");
            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = line[j];
                if (line[j].equals("S")) {
                    rowS = i;
                    colS = j;
                } else if (line[j].equals("O")) {
                    if (count == 0) {
                        h1Row = i;
                        h1Col = j;
                        count++;
                    } else {
                        h2Row = i;
                        h2Col = j;
                    }
                }
            }
        }

        int power = 0;

        while (true) {
            String command = reader.readLine();

            switch (command) {
                case "up" :
                    matrix[rowS][colS] = "-";
                    rowS--;
                    break;
                case "down" :
                    matrix[rowS][colS] = "-";
                    rowS++;
                    break;
                case "left" :
                    matrix[rowS][colS] = "-";
                    colS--;
                    break;
                case "right" :
                    matrix[rowS][colS] = "-";
                    colS++;
                    break;
            }

            if (rowS >= 0 && rowS < matrix.length && colS >= 0 && colS < matrix[0].length) {
                if (matrix[rowS][colS].equals("O")) {
                    matrix[rowS][colS] = "-";
                    if (rowS == h1Row) {
                        rowS = h2Row;
                        colS = h2Col;
                    } else {
                        rowS = h1Row;
                        colS = h1Col;
                    }
                } else if (!matrix[rowS][colS].equals("-") && !matrix[rowS][colS].equals("0")) {
                    power += Integer.parseInt(matrix[rowS][colS]);
                    matrix[rowS][colS] = "S";
                    if (power >= 50) {
                        System.out.println("Good news! Stephen succeeded in collecting enough star power!");
                        System.out.println("Star power collected: " + power);
                        printMatrixx(matrix);
                        return;
                    }
                }

            } else {
                System.out.println("Bad news, the spaceship went to the void.");
                System.out.println("Star power collected: " + power);
                printMatrixx(matrix);
                return;
            }
        }

    }

    private static void printMatrixx(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
