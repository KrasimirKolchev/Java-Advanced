package IteratorsAndComparatorsEx.ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        String input;

        while (!"END".equals(input = reader.readLine())) {
            String[] line = input.split("\\s+");

            Person personComp = new Person(line[0], Integer.parseInt(line[1]), line[2]);
            people.add(personComp);
        }

        int index = Integer.parseInt(reader.readLine()) - 1;

        Person person = people.get(index);

        int equal = 1;
        int total = people.size();
        people.remove(index);

        for (Person p : people) {
            if (person.compareTo(p) != 0) {

            } else {
                equal++;
            }
        }
        if (equal > 1) {
            System.out.println(String.format("%d %d %d", equal, total - equal, total));
        } else {
            System.out.println("No matches");
        }

    }
}
