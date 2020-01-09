package SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> numbersCount = new LinkedHashMap<>();

        double[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();

        for (Double num : numbers) {
            numbersCount.putIfAbsent(num, 0);
            numbersCount.put(num, numbersCount.get(num) + 1);
        }

        numbersCount.entrySet().stream().forEach(e ->
                System.out.println(String.format("%.1f -> %d", e.getKey(), e.getValue())));
    }
}
