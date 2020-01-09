package StackAndQueueEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(";");

        String[] robotsNames = new String[input.length];
        int[] processTime = new int[input.length];
        int[] workingTime = new int[input.length];


        for (int i = 0; i < input.length; i++) {
            String[] line = input[i].split("-");
            robotsNames[i] = line[0];
            processTime[i] = Integer.parseInt(line[1]);
        }

        String startTime = scanner.nextLine();
        ArrayDeque<String> products = new ArrayDeque<>();

        String inputProduct;

        while (!"End".equals(inputProduct = scanner.nextLine())) {
            products.offer(inputProduct);
        }

        String[] timeData = startTime.split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        int startSeconds = hours * 3600 + minutes * 60 + seconds;

        while (!products.isEmpty()) {
            startSeconds++;

            String product = products.poll();
            boolean isAssigned = false;

            for (int i = 0; i < robotsNames.length; i++) {
                if (workingTime[i] == 0 && !isAssigned) {
                    workingTime[i] = processTime[i];
                    isAssigned = true;
                    printRobotData(robotsNames[i], product, startSeconds);
                }

                if (workingTime[i] > 0) {
                    workingTime[i]--;
                }
            }

            if (!isAssigned) {
                products.offer(product);
            }
        }
    }

    private static void printRobotData(String robot, String product, int startSeconds) {
        long second = startSeconds % 60;
        long minute = (startSeconds / 60) % 60;
        long hour = (startSeconds / (60 * 60)) % 24;

        System.out.println(String.format("%s - %s [%02d:%02d:%02d]", robot, product, hour, minute, second));
    }
}
