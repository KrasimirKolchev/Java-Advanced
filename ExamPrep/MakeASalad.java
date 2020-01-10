package ExamPrep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class MakeASalad {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String> vegetableQueue = new ArrayDeque();
        String[] veg = reader.readLine().split("\\s+");
        for (String v : veg) {
            vegetableQueue.offer(v);
        }

        ArrayDeque<Integer> caloriesStack = new ArrayDeque();
        String[] cal = reader.readLine().split("\\s+");
        for (String c : cal) {
            caloriesStack.push(Integer.parseInt(c));
        }

        while (caloriesStack.size() > 0 && vegetableQueue.size() > 0) {
            int calories = caloriesStack.peek();

            while (calories > 0 && vegetableQueue.size() > 0) {
                String vegetable = vegetableQueue.poll();

                switch (vegetable) {
                    case "tomato" :
                        calories -= 80;
                        break;
                    case "carrot" :
                        calories -= 136;
                        break;
                    case "lettuce" :
                        calories -= 109;
                        break;
                    case  "potato" :
                        calories -= 215;
                        break;
                }

            }
            System.out.print(caloriesStack.pop() + " ");
        }
        System.out.println();

        if (vegetableQueue.size() != 0) {
            for (String v : vegetableQueue) {
                System.out.print(v + " ");
            }
        } else if (caloriesStack.size() != 0) {
            for (Integer c : caloriesStack) {
                System.out.print(c + " ");
            }
        }
    }
}
