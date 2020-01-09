package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, data);

        int n = Integer.parseInt(scanner.nextLine());
        int times = 0;

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }

            if (!isPrimeNumber(++times)) {
                System.out.println("Removed " + queue.poll());
            } else {
                System.out.println("Prime " + queue.peek());
            }

        }

        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrimeNumber(int n) {

        if (n == 2) {
            return true;
        }

        if (n < 2 || n % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= n ; i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
