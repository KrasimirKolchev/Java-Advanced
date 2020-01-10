package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class spaceshipCrafting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        String[] line = reader.readLine().split("\\s+");
        for (String l : line) {
            liquids.offer(Integer.parseInt(l));
        }

        ArrayDeque<Integer> physicalEl = new ArrayDeque<>();
        String[] line2 = reader.readLine().split("\\s+");
        for (String p : line2) {
            physicalEl.push(Integer.parseInt(p));
        }

        int aluminium = 0;
        int carbon = 0;
        int glass = 0;
        int lithium = 0;

        while (!liquids.isEmpty() && !physicalEl.isEmpty()) {
            int liquid = liquids.peek();
            int item = physicalEl.peek();
            int sum = liquid + item;
            if (sum == 25 || sum == 50 || sum == 75 || sum == 100) {
                liquids.poll();
                physicalEl.pop();
                switch (sum) {
                    case 25 :
                        glass++;
                        break;
                    case 50 :
                        aluminium++;
                        break;
                    case 75 :
                        lithium++;
                        break;
                    case 100 :
                        carbon++;
                        break;
                }
            } else {
                liquids.poll();
                physicalEl.addFirst(physicalEl.poll() + 3);
            }
        }

        if (aluminium > 0 && carbon > 0 && glass > 0 && lithium > 0) {
            System.out.println("Wohoo! You succeeded in building the spaceship!");
            if (liquids.isEmpty()) {
                System.out.println("Liquids left: none");
            } else {
                System.out.println(String.format("Liquids left: %s",
                        liquids.toString().replaceAll("\\[|\\]", "")));
            }
            if (physicalEl.isEmpty()) {
                System.out.println("Physical items left: none");
            } else {
                System.out.println(String.format("Physical items left: %s",
                        physicalEl.toString().replaceAll("\\[|\\]", "")));
            }

        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
            if (liquids.isEmpty()) {
                System.out.println("Liquids left: none");
            } else {
                System.out.println(String.format("Liquids left: %s",
                        liquids.toString().replaceAll("\\[|\\]", "")));
            }
            if (physicalEl.isEmpty()) {
                System.out.println("Physical items left: none");
            } else {
                System.out.println(String.format("Physical items left: %s",
                        physicalEl.toString().replaceAll("\\[|\\]", "")));
            }
        }

        System.out.println(String.format("Aluminium: %d%nCarbon fiber: %d%nGlass: %d%nLithium: %d",
                aluminium, carbon, glass, lithium));
    }
}
