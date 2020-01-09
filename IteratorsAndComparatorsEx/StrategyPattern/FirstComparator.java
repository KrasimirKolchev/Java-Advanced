package IteratorsAndComparatorsEx.StrategyPattern;

import java.util.Comparator;

public class FirstComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        int compare;

        if (p1.getName().length() == p2.getName().length()) {
            compare = Integer.compare(p1.getName().toLowerCase().charAt(0), p2.getName().toLowerCase().charAt(0));
        } else {
            compare = Integer.compare(p1.getName().length(), p2.getName().length());
        }

        return compare;
    }
}
