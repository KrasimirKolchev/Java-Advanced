package StackAndQueueEx;

import java.util.Scanner;
import java.util.Stack;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\s+");
        int nElements = Integer.parseInt(line[0]);
        int sElements = Integer.parseInt(line[1]);
        int xElement = Integer.parseInt(line[2]);

        Stack<Integer> elements = new Stack<>();
        String[] numbers = scanner.nextLine().split("\\s+");

        for (int i = 0; i < nElements; i++) {
            elements.push(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < sElements; i++) {
            elements.pop();
        }

        if (elements.contains(xElement)) {
            System.out.println("true");
        } else {
            if (elements.isEmpty()) {
                System.out.println(0);
            } else {
                elements.sort((a, b) -> b - a);
                System.out.println(elements.peek());
            }
        }

    }
}
