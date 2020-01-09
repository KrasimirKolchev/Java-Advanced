package SetsAndMapsAdvancedEx;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> table = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] chem = scanner.nextLine().split("\\s+");
            table.addAll(Arrays.asList(chem));
        }

        table.forEach(e -> System.out.print(e + " "));
    }
}
