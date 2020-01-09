package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String exp = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < exp.length(); i++) {
            char symbol = exp.charAt(i);

            if (symbol == '(') {
                stack.push(i);
            } else if (symbol == ')') {
                int start = stack.pop();
                String content = exp.substring(start, i + 1);
                System.out.println(content);
            }
        }
    }
}
