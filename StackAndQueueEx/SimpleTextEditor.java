package StackAndQueueEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder part = new StringBuilder();
        ArrayDeque<StringBuilder> text = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s+");

            switch (line[0]) {
                case "1" :
                    part.append(line[1]);
                    text.push(new StringBuilder(part));
                    break;
                case "2" :
                    if (Integer.parseInt(line[1]) < part.length()) {
                        part.substring(part.length() - Integer.parseInt(line[1]), part.length());
                    } else {
                        part.setLength(0);
                    }
                    text.push(new StringBuilder(part));
                    break;
                case "3" :
                    part = text.peek();
                    System.out.println(part.charAt(Integer.parseInt(line[1]) - 1));
                    break;
                case "4" :
                    if (text.size() > 0) {
                        text.pop();
                        if (text.size() > 0) {
                            part = text.peek();
                        } else {
                            part.setLength(0);
                        }
                    }
                    break;
            }
        }
    }
}
