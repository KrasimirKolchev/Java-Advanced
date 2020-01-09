package StackAndQueueEx;

import java.util.Scanner;

public class RecursiveFibonacciStackAndQueue {

    private static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        memory = new long[n + 1];

        long result = getFibonacci(n);

        System.out.println(result);
    }

    private static long getFibonacci(int n) {

        if (n < 2) {
            return 1;
        }

        if (memory[n] != 0) {
            return memory[n];
        }

        return memory[n] = getFibonacci(n - 1) + getFibonacci(n - 2);
    }
}
