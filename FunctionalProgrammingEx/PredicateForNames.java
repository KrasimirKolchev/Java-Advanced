package FunctionalProgrammingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split("\\s+");

        Predicate<String> checkLength = n -> n.length() <= length;

        Consumer<String[]> printName = name -> {
            for (String item : names) {
                if (checkLength.test(item)) {
                    System.out.println(item);
                }
            }
        };

        printName.accept(names);
    }
}
