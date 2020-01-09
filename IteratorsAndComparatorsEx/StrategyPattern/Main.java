package IteratorsAndComparatorsEx.StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        TreeSet<Person> peopleOne = new TreeSet<>(new FirstComparator());
        TreeSet<Person> peopleTwo = new TreeSet<>(new SecondComparator());

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");

            Person person = new Person(input[0], Integer.parseInt(input[1]));
            peopleOne.add(person);
            peopleTwo.add(person);
        }

        peopleOne.forEach(Person::print);
        peopleTwo.forEach(Person::print);
    }
}
