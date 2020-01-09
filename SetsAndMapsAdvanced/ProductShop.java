package SetsAndMapsAdvanced;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shopsProductPrice = new LinkedHashMap<>();

        String command;

        while (!"Revision".equals(command = scanner.nextLine())) {
            String[] input = command.split(", ");

            shopsProductPrice.putIfAbsent(input[0], new LinkedHashMap());
            shopsProductPrice.get(input[0]).put(input[1], Double.parseDouble(input[2]));
        }

        shopsProductPrice.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(e -> {
            System.out.println(e.getKey() + "->");
            e.getValue().entrySet().stream().forEach(e1 ->
                    System.out.println(String.format("Product: %s, Price: %.1f", e1.getKey(), e1.getValue())));
        });
    }
}
