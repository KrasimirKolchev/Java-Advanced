package GenericsEx.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> tList;

    public CustomList() {
        this.tList = new ArrayList<>();
    }

    public int size() {
        return this.tList.size();
    }

    public T get(int index) {
        return  this.tList.get(index);
    }

    public void add(T element) {
        this.tList.add(element);
    }

    public T remove(int index) {
        return this.tList.remove(index);
    }

    public boolean contains(T element) {
        return this.tList.contains(element);
    }

    public void swap(int first, int second) {
        Collections.swap(this.tList, first, second);
    }

    public int countGreaterThan(T element) {
        return (int) this.tList.stream().filter(value -> value.compareTo(element) > 0)
                .count();
    }

    public T getMax() {
        return Collections.max(this.tList);
    }

    public T getMin() {
        return Collections.min(this.tList);
    }

    public static <T extends Comparable<T>> void printList(CustomList tList) {
        tList.tList.stream().forEach(System.out::println);
    }

    //public void forEach(Consumer<T> consumer) {
    //    for (T element : tList) {
    //        consumer.accept(element);
    //    }
    //}

    public void sort(CustomList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    list.swap(i, j);
                }
            }
        }
    }


   @Override
   public Iterator<T> iterator() {
       return this.tList.iterator();
   }

    //@Override
    //public Iterator<T> iterator() {
    //    return new Iterator<T>() {
    //        private int index = 0;
//
//
    //        @Override
    //        public boolean hasNext() {
    //            return this.index < tList.size();
    //        }
//
    //        @Override
    //        public T next() {
    //            return tList.get(this.index++);
    //        }
    //    };
    //}
}
