package SetsAndMapsAdvanced;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> someMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s+");

            someMap.putIfAbsent(line[0], new LinkedHashMap<>());
            someMap.get(line[0]).putIfAbsent(line[1], new ArrayList<>());
            someMap.get(line[0]).get(line[1]).add(line[2]);
        }

        someMap.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + ":");
            e.getValue().entrySet().stream().forEach(e1 -> {
                System.out.println(String.format("  %s -> %s", e1.getKey(), Arrays.toString(e1.getValue().toArray()).replaceAll("\\[|\\]", "")));
            });

        });
    }
}
