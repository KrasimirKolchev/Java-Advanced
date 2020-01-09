package SetsAndMapsAdvancedEx;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> someMap = new TreeMap<>();

        String line = scanner.nextLine();

        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);

            someMap.putIfAbsent(symbol, 0);
            someMap.put(symbol, someMap.get(symbol) + 1);
        }

        someMap.entrySet().stream().forEach(e ->
                System.out.println(String.format("%c: %d time/s", e.getKey(), e.getValue())));
    }
}
