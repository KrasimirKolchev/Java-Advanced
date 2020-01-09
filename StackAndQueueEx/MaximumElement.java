package StackAndQueueEx;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        Deque<Integer> elements = new ArrayDeque<>();

        while (lines-- > 0) {

            String[] commands = scanner.nextLine().split("\\s+");

            switch (commands[0]) {
                case ("1") :
                    elements.push(Integer.parseInt(commands[1]));
                    break;
                case ("2") :
                    elements.poll();
                    break;
                case ("3") :
                    if (elements.isEmpty()) {
                        System.out.println(0);
                    } else {
                        int maxElement = Collections.max(elements);
                        System.out.println(maxElement);
                    }
                    break;
            }
        }
    }
}
