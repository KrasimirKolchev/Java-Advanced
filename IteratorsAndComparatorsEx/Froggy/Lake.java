package IteratorsAndComparatorsEx.Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {

    private int[] numbers;

    public Lake(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = 0;
            private int lastIndex = numbers.length - 1;

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return null;
            }
        };
    }

}
