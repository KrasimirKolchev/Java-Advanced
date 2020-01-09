package MultidimentionalArraysEx;

import java.util.ArrayList;
import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double damagePerTurn = Double.parseDouble(scanner.nextLine());
        double heiganHealth = 3000000.0;
        int playerHealth = 18500;
        int[] playerRowCol = {7, 7};
        boolean spellEffect = false;
        String spell = "";

        while (heiganHealth > 0) {
            heiganHealth -= damagePerTurn;

            if (spellEffect) {
                playerHealth -= 3500;
                spellEffect = false;
            }

            if (heiganHealth <= 0 || playerHealth <= 0) {
                break;
            }

            String[] line = scanner.nextLine().split("\\s+");
            spell = line[0];
            int spellRow = Integer.parseInt(line[1]);
            int spellCol = Integer.parseInt(line[2]);
            int times = 0;
            ArrayList<String> targetedArea = new ArrayList<>();
            targetArea(spellRow, spellCol, targetedArea, times);
            int damage = 0;


            switch (spell) {
                case "Cloud" :
                    damage = 3500;
                    if (playerRowCol[0] == spellRow && playerRowCol[1] == spellCol) {
                        playerHealth -= damage;
                    } else {
                        playerHealth = getPlayerHealth(playerHealth, playerRowCol, targetedArea, damage);
                    }

                    if (targetedArea.contains(String.format("%d,%d", playerRowCol[0], playerRowCol[1]))) {
                        spellEffect = true;
                    }
                    break;
                case "Eruption" :
                    damage = 6000;
                    if (playerRowCol[0] == spellRow && playerRowCol[1] == spellCol) {
                        playerHealth -= damage;
                    } else {
                        playerHealth = getPlayerHealth(playerHealth, playerRowCol, targetedArea, damage);
                    }
                    break;
            }
            if (playerHealth <= 0) {
                break;
            }
        }

        printWinner(heiganHealth, playerHealth, playerRowCol, spell);
    }

    private static void printWinner(double heiganHealth, int playerHealth, int[] playerRowCol, String spell) {
        if (heiganHealth <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f\n", heiganHealth);
        }
        if (spell.equals("Cloud")) {
            spell = "Plague Cloud";
        }

        if (playerHealth <= 0) {
            System.out.printf("Player: Killed by %s\n", spell);
        } else {
            System.out.printf("Player: %d\n", playerHealth);
        }
        System.out.printf("Final position: %d, %d\n", playerRowCol[0], playerRowCol[1]);
    }

    private static void targetArea(int spellRow, int spellCol, ArrayList<String> targetedArea, int times) {

        for (int i = spellRow - 1; i <= spellRow + 1; i++) {
            for (int j = spellCol - 1; j <= spellCol + 1; j++) {
                if (spellRow >= 0 && spellCol >= 0) {
                    targetedArea.add(times, String.format("%d,%d", i, j));
                    times++;
                }
            }
        }
    }

    private static Integer getPlayerHealth(int playerHealth, int[] playerRowCol, ArrayList<String> targetedArea, int dmg) {
        boolean positionFlag = false;

        if (targetedArea.contains(String.format("%d,%d", playerRowCol[0], playerRowCol[1]))) {
            if (playerRowCol[0] - 1 >= 0) {
                playerRowCol[0] -= 1;
                positionFlag = true;
            }
            if (targetedArea.contains(String.format("%d,%d", playerRowCol[0], playerRowCol[1]))) {
                if (positionFlag) {
                    playerRowCol[0] += 1;
                    positionFlag = false;
                }
                if (playerRowCol[1] + 1 <= 14) {
                    playerRowCol[1] += 1;
                    positionFlag = true;
                }
                if (targetedArea.contains(String.format("%d,%d", playerRowCol[0], playerRowCol[1]))) {
                    if (positionFlag) {
                        playerRowCol[1] -= 1;
                        positionFlag = false;
                    }
                    if (playerRowCol[0] + 1 <= 14) {
                        playerRowCol[0] += 1;
                        positionFlag = true;
                    }
                    if (targetedArea.contains(String.format("%d,%d", playerRowCol[0], playerRowCol[1]))) {
                        if (positionFlag) {
                            playerRowCol[0] -= 1;
                            positionFlag = false;
                        }
                        if (playerRowCol[1] - 1 >= 0) {
                            playerRowCol[1] -= 1;
                            positionFlag = true;
                        }
                        if (targetedArea.contains(String.format("%d,%d", playerRowCol[0], playerRowCol[1]))) {
                            if (positionFlag) {
                                playerRowCol[1] += 1;
                                positionFlag = false;
                            }
                            playerHealth -= dmg;
                        }
                    }
                }
            }
        }
        return playerHealth;
    }
}
