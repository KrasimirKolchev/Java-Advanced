package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String line = scanner.nextLine();

        String[] asd = line.split("\\s+");

        for (int i = asd.length - 1; i >= 0; i--) {
            stack.push(asd[i]);
        }

        while (stack.size() > 1) {
            int firstNum = Integer.valueOf(stack.pop());
            String operator = stack.pop();
            int secondNum = Integer.valueOf(stack.pop());

            if (operator.equals("+")) {
                stack.push(firstNum + secondNum + "");
            } else {
                stack.push(firstNum - secondNum + "");
            }
        }

        System.out.println(stack.peek());
    }
}
