package StackAndQueueEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        ArrayDeque<Character> brackets = new ArrayDeque<>();

        if (line.length() % 2 == 0) {
            for (int i = 0; i < line.length(); i++) {
                char bracket = line.charAt(i);

                if (bracket == '(' || bracket == '{' || bracket == '[') {
                    brackets.push(bracket);
                } else if (bracket == ')' || bracket == '}' || bracket == ']') {
                    switch (bracket) {
                        case (')') :
                            if ('(' == brackets.peek()) {
                                brackets.pop();
                            } else {
                                System.out.println("NO");
                                return;
                            }
                            break;
                        case ('}') :
                            if ('{' == brackets.peek()) {
                                brackets.pop();
                            } else {
                                System.out.println("NO");
                                return;
                            }
                            break;
                        case (']') :
                            if ('[' == brackets.peek()) {
                                brackets.pop();
                            } else {
                                System.out.println("NO");
                                return;
                            }
                            break;
                    }
                }
            }
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
