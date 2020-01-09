package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queuePrinter = new ArrayDeque<>();
        String input;

        while (!"print".equals(input = scanner.nextLine())) {
            if (!"cancel".equals(input)) {
                queuePrinter.offer(input);
            } else {
                if (!queuePrinter.isEmpty()) {
                    System.out.println("Canceled " + queuePrinter.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            }
        }

        while (!queuePrinter.isEmpty()) {
            System.out.println(queuePrinter.poll());
        }

    }
}
