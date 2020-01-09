package Generics.Jar;

import java.util.ArrayDeque;
import java.util.Deque;


public class Jar<T> {
    private Deque<T> element;

    public Jar() {
        this.element = new ArrayDeque<>();
    }

    public void add(T entity) {
        this.element.push(entity);
    }

    public T remove() {
        return this.element.pop();
    }
}
