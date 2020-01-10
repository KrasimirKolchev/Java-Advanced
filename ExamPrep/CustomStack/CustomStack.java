package ExamPrep.CustomStack;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack {
    private static final int INITIAL_CAPACITY = 4;

    private int[] stackData;
    private int size;
    private int capacity;

    public CustomStack() {
        this.capacity = INITIAL_CAPACITY;
        this.stackData = new int[this.capacity];
    }

    public int getSize() {
        return this.size;
    }

    public void push(int element) {
        if (this.size == this.capacity) {
            this.resize();
        }

        this.stackData[this.size++] = element;
    }

    private void resize() {
        this.capacity *= 2;
        int[] newStackData = new int[this.capacity];

        System.arraycopy(this.stackData, 0, newStackData, 0, this.size);
        this.stackData = newStackData;
    }

    public int pop() {
        checkIfEmpty();

        int element = this.stackData[this.size - 1];
        this.stackData[this.size - 1] = 0;
        this.size--;

        return element;
    }

    private void checkIfEmpty() {
        if (this.size == 0) {
            throw new NoSuchElementException("Няма такъв елемент!");
        }
    }

    public int peek() {
        checkIfEmpty();

        int element = this.stackData[this.size - 1];
        return element;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.stackData[i]);
        }
    }
}
