package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();


        String line;

        while (!"Home".equals(line = scanner.nextLine())) {

            if ("back".equals(line)) {
                if (history.size() > 1) {
                    forward.push(history.poll());
                    System.out.println(history.peek());
                } else {
                    System.out.println("no previous URLs");
                }

            } else if ("forward". equals(line)) {
                if (!forward.isEmpty()) {
                    history.push(forward.poll());
                    System.out.println(history.peek());
                } else {
                    System.out.println("no next URLs");
                }
            } else {
                history.push(line);
                System.out.println(line);
                if (!forward.isEmpty()) {
                    forward.clear();
                }
            }
        }
    }
}
//stack uses LIFO System.out.println("no next URLs");
//queue uses FIFO System.out.println("no previous URLs");