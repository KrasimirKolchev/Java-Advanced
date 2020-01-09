package SetsAndMapsAdvancedEx;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] n = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Set<Integer> first = new LinkedHashSet<>();
        for (int i = 0; i < n[0]; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            first.add(num);
        }

        Set<Integer> second = new LinkedHashSet<>();
        for (int i = 0; i < n[1]; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            second.add(num);
        }

        first.retainAll(second);

        first.forEach(e -> System.out.print(e + " "));
    }
}
