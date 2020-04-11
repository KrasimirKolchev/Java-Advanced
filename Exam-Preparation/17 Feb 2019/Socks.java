package ExamPrep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Socks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> leftSocksStack = new ArrayDeque<>();
        String[] line = reader.readLine().split("\\s+");
        for (String el : line) {
            leftSocksStack.push(Integer.parseInt(el));
        }

        ArrayDeque<Integer> rightSocksQueue = new ArrayDeque<>();
        String[] line1 = reader.readLine().split("\\s+");
        for (String el : line1) {
            rightSocksQueue.offer(Integer.parseInt(el));
        }

        List<Integer> pairs = new ArrayList<>();

        while (leftSocksStack.size() > 0 && rightSocksQueue.size() > 0) {
            int left = leftSocksStack.peek();
            int right = rightSocksQueue.peek();

            if (left > right) {
                pairs.add(left + right);
                leftSocksStack.pop();
                rightSocksQueue.poll();
            } else if (left < right) {
                leftSocksStack.pop();
            } else {
                rightSocksQueue.poll();
                leftSocksStack.push(leftSocksStack.pop() + 1);
            }
        }
        System.out.println(Collections.max(pairs));
        pairs.stream().forEach(e -> System.out.print(e + " "));
    }
}
