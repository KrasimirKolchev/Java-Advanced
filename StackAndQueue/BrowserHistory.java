package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> linkedURL = new ArrayDeque<>();

        String line = "";

        while (!"Home".equals(line = scanner.nextLine())) {
            if (!"back".equals(line)) {
                linkedURL.push(line);
                System.out.println(line);
            } else {
                if (linkedURL.size() > 1) {
                    linkedURL.pop();
                    System.out.println(linkedURL.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            }
        }

    }

}
