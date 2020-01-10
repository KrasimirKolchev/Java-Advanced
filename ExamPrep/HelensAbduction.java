package ExamPrep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelensAbduction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int energy = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        int rowP = 0;
        int colP = 0;

        char[][] ground = new char[n][];

        for (int i = 0; i < n; i++) {
            String[] info = reader.readLine().split("");
            char[] chars = new char[info.length];

            for (int j = 0; j < info.length; j++) {
                chars[j] = info[j].charAt(0);
                if (chars[j] == 'P') {
                    rowP = i;
                    colP = j;
                }
            }
            ground[i] = chars;
        }


            while (true) {
            String[] info = reader.readLine().split("\\s+");
            String direction = info[0];
            int row = Integer.parseInt(info[1]);
            int col = Integer.parseInt(info[2]);

            boolean isDead = false;
            boolean isWithHelena = false;

            spawn(ground, row, col);

            switch (direction) {
                case "up" :
                    if (rowP - 1 >= 0 && rowP - 1 < ground.length) {
                        ground[rowP][colP] = '-';
                        rowP--;
                        energy--;

                        if (ground[rowP][colP] == 'H') {
                            ground[rowP][colP] = '-';
                            isWithHelena = true;
                        }
                        if (energy == 0) {
                            isDead = true;
                            ground[rowP][colP] = 'X';
                        }

                        if (ground[rowP][colP] == 'S') {
                            if (energy - 2 > 0) {
                                energy -= 2;
                                ground[rowP][colP] = 'P';
                            } else {
                                ground[rowP][colP] = 'X';
                                isDead = true;
                            }


                        }
                    } else {
                        energy--;
                        if (energy == 0) {
                            isDead = true;
                            ground[rowP][colP] = 'X';
                        }
                    }
                    break;
                    case "down" :
                        if (rowP + 1 > 0 && rowP + 1 < ground.length) {
                            ground[rowP][colP] = '-';
                            rowP++;
                            energy--;

                            if (ground[rowP][colP] == 'H') {
                                ground[rowP][colP] = '-';
                                isWithHelena = true;
                            }
                            if (energy == 0) {
                                isDead = true;
                                ground[rowP][colP] = 'X';
                            }

                            if (ground[rowP][colP] == 'S') {
                                if (energy - 2 > 0) {
                                    energy -= 2;
                                    ground[rowP][colP] = 'P';
                                } else {
                                    ground[rowP][colP] = 'X';
                                    isDead = true;
                                }
                            }
                        } else {
                            energy--;
                            if (energy == 0) {
                                isDead = true;
                                ground[rowP][colP] = 'X';
                            }
                        }
                        break;
                    case "left" :
                        if (colP - 1 >= 0 && colP - 1 < ground[0].length) {
                            ground[rowP][colP] = '-';
                            colP--;
                            energy--;

                            if (ground[rowP][colP] == 'H') {
                                ground[rowP][colP] = '-';
                                isWithHelena = true;
                            }
                            if (energy == 0) {
                                isDead = true;
                                ground[rowP][colP] = 'X';
                            }

                            if (ground[rowP][colP] == 'S') {
                                if (energy - 2 > 0) {
                                    energy -= 2;
                                    ground[rowP][colP] = 'P';
                                } else {
                                    ground[rowP][colP] = 'X';
                                    isDead = true;
                                }
                            }
                        } else {
                            energy--;
                            if (energy == 0) {
                                isDead = true;
                                ground[rowP][colP] = 'X';
                            }
                        }
                        break;
                    case "right" :
                        if (colP + 1 > 0 && colP + 1 < ground[0].length) {
                            ground[rowP][colP] = '-';
                            colP++;
                            energy--;

                            if (ground[rowP][colP] == 'H') {
                                ground[rowP][colP] = '-';
                                isWithHelena = true;
                            }
                            if (energy == 0) {
                                isDead = true;
                                ground[rowP][colP] = 'X';
                            }

                            if (ground[rowP][colP] == 'S') {
                                if (energy - 2 > 0) {
                                    energy -= 2;
                                    ground[rowP][colP] = 'P';
                                } else {
                                    ground[rowP][colP] = 'X';
                                    isDead = true;
                                }
                            }
                        } else {
                            energy--;
                            if (energy == 0) {
                                isDead = true;
                                ground[rowP][colP] = 'X';
                            }
                        }
                        break;
                }

            if (isDead) {
                System.out.printf("Paris died at %d;%d.%n", rowP, colP);
                printGround(ground);
                return;
            }

            if (isWithHelena) {
                System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
                printGround(ground);
                return;
            }
        }
    }

    private static void printGround(char[][] ground) {

        for (int i = 0; i < ground.length; i++) {
            for (int j = 0; j < ground[i].length; j++) {
                System.out.print(ground[i][j]);
            }
            System.out.println();
        }
    }

    private static void spawn(char[][] ground, int row, int col) {
        ground[row][col] = 'S';
    }


}
