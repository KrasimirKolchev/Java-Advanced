package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(",\\s+");
            people.put(line[0], Integer.parseInt(line[1]));
        }

        String condition = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        String type = reader.readLine();


        BiPredicate<Map.Entry<String, Integer>, Integer> younger = (p, ageLimit) -> p.getValue() <= ageLimit;
        BiPredicate<Map.Entry<String, Integer>, Integer> older = (p, ageLimit) -> p.getValue() >= ageLimit;

        Consumer<Map.Entry<String, Integer>> printName = p -> System.out.println(p.getKey());
        Consumer<Map.Entry<String, Integer>> printAge = p -> System.out.println(p.getValue());
        Consumer<Map.Entry<String, Integer>> printNameAge = p ->
                System.out.println(String.format("%s - %d", p.getKey(), p.getValue()));

        people.entrySet().stream().filter(p -> condition.equals("younger") ? younger.test(p, age) :
                    older.test(p, age)
        ).forEach(p -> {
            switch (type) {
                case "name":
                    printName.accept(p);
                    break;
                case "age":
                    printAge.accept(p);
                    break;
                case "name age" :
                    printNameAge.accept(p);
                    break;
            }
        });

    }
}
