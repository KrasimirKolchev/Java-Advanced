package DefiningClassesEx.OpinionPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        while (n-- > 0) {
            String[] line = reader.readLine().split("\\s+");
            String name = line[0];
            int age = Integer.parseInt(line[1]);

            Person person = new Person(name, age);
            people.add(person);
        }

        people.stream().filter(e -> e.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(name -> System.out.println(name.toString()));
    }
}
