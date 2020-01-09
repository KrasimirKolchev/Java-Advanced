package SetsAndMapsAdvancedEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();
        String command;

        while (!"stop".equals(command = scanner.nextLine())) {
            int quantity = Integer.parseInt(scanner.nextLine());

            resources.putIfAbsent(command, 0);
            resources.put(command, resources.get(command) + quantity);
        }

        resources.entrySet().stream()
                .forEach(e -> System.out.println(String.format("%s -> %d", e.getKey(), e.getValue())));
    }
}
