package Generics.ListUtilities;

import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> elements) {
        if (elements == null || elements.size() == 0) {
            throw new IllegalArgumentException();
        }

        T first = elements.get(0);
        for (T element : elements) {
            if (first.compareTo(element) > 0) {
                first = element;
            }
        }

        return first;
    }

    public static <T extends Comparable<T>> T getMax(List<T> elements){
        if (elements == null || elements.size() == 0) {
            throw new IllegalArgumentException();
        }

        T first = elements.get(0);

        for (T element : elements) {
            if (first.compareTo(element) < 0) {
                first = element;
            }
        }
        return first;
    }
}
