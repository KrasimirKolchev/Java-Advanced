package IteratorsAndComparatorsEx.ListyIterator;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private static final int INITIAL_INDEX = 0;

    private List<String> text;
    private int index;

    public ListyIterator(List<String> text) {
        this.text = text;
        this.index = INITIAL_INDEX;
    }

    public boolean move() {
        if (hasNext()) {
            this.index += 1;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        if (this.index + 1 < this.text.size()) {
            return true;
        }
        return false;
    }

    public void print() {
        if (this.index < this.text.size()) {
            System.out.println(this.text.get(this.index));
        } else {
            System.out.println("Invalid Operation!");
        }

    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int newIndex = INITIAL_INDEX;

            @Override
            public boolean hasNext() {
                return this.newIndex < text.size();
            }

            @Override
            public String next() {
                return text.get(newIndex++);
            }
        };
    }
}
