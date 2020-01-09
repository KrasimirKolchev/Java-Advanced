package FunctionalProgrammingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Predicate;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] names = reader.readLine().split("\\s+");
        HashMap<String, Predicate<String>> predicates = new HashMap<>();

        String command;

        while (!"Print".equals(command = reader.readLine())) {
            String[] tokens = command.split(";");
            String type = tokens[1];
            String cryteria = tokens[2];
            String fName = type + cryteria;


            if (tokens[0].contains("Add")) {
                Predicate<String> predicate = null;

                if (type.contains("Starts")) {
                    predicate = s -> s.startsWith(cryteria);
                } else if (type.contains("Ends")) {
                    predicate = s -> s.endsWith(cryteria);
                } else if (type.contains("Length")) {
                    predicate = s -> s.length() == Integer.parseInt(cryteria);
                } else {
                    predicate = s -> s.contains(cryteria);
                }

                predicates.putIfAbsent(fName, predicate);
            } else {
                predicates.remove(fName);
            }
        }

        Arrays.stream(names).forEach(name -> {
            boolean[] hasToBeFiltered = new boolean[1];
            predicates.forEach((k, v) -> {
                if (v.test(name)) {
                    hasToBeFiltered[0] = true;
                }
            });
            if (!hasToBeFiltered[0]) {
                System.out.print(name + " ");
            }
        });
    }
}
