package StackAndQueueEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < line.length; i++) {
            String exp = line[i];
            char symbol = exp.charAt(0);

            if (Character.isDigit(symbol) || Character.isAlphabetic(symbol)) {
                System.out.print(exp + " ");
            } else if (symbol == '(') {
                stack.push(symbol);
            } else if (symbol == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    System.out.print(stack.pop() + " ");
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && Precedence(symbol) <= Precedence(stack.peek()))
                    System.out.print(stack.pop() + " ");
                stack.push(symbol);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static int Precedence(char symbol) {
        switch (symbol) {
            case '+':
                return 1;
            case '-' :
                return 1;
            case '*' :
                return 2;
            case '/' :
                return 2;
        }
        return -1;
    }
}
