package StackAndQueueEx;

import java.util.*;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\s+");
        int nElements = Integer.parseInt(line[0]);
        int sElements = Integer.parseInt(line[1]);
        int xElement = Integer.parseInt(line[2]);

        ArrayDeque<Integer> elements = new ArrayDeque<>();
        String[] numbers = scanner.nextLine().split("\\s+");

        for (int i = 0; i < nElements; i++) {
            elements.offer(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < sElements; i++) {
            elements.poll();
        }

        if (elements.contains(xElement)) {
            System.out.println("true");
        } else {
            if (elements.isEmpty()) {
                System.out.println(0);
            } else {
                int minElement = Collections.min(elements);
                System.out.println(minElement);
            }
        }
    }
}
