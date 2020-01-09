package FunctionalProgrammingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(reader.readLine().split("\\s+")).
                collect(Collectors.toList());

        String line;

        while (!"Party!".equals(line = reader.readLine())) {
            String[] command = line.split("\\s+");
            Predicate<String> predicate = null;
            String criteria = command[2];

            switch (command[1].toLowerCase()) {
                case "startswith" :
                    predicate = n -> n.startsWith(criteria);
                    break;
                case "endswith" :
                    predicate = n -> n.endsWith(criteria);
                    break;
                case "length" :
                    predicate = n -> n.length() == Integer.parseInt(criteria);
                    break;
            }

            if (command[0].toLowerCase().equals("double")) {
                for (int i = 0; i < names.size(); i++) {
                    if (predicate.test(names.get(i))) {
                        names.add(0, names.get(i));
                        i++;
                    }
                }
            } else if (command[0].toLowerCase().equals("remove")) {
                for (int i = 0; i < names.size(); i++) {
                    if (predicate.test(names.get(i))) {
                        names.remove(i);
                        i--;
                    }
                }
            }
        }

        if (names.size() != 0) {
            Collections.sort(names);
            System.out.println(String.format("%s are going to the party!",
                    names.toString().replaceAll("\\[|\\]", "")));
        } else {
            System.out.println("Nobody is going to the party!");
        }

    }
}
