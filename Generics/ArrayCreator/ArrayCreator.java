package Generics.ArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {


    public static <T> T[] create(int length, T item) {
        Object[] array = new Object[length];

        for (int i = 0; i < array.length; i++) {
            array[i] = item;
        }
        return (T[]) array;
    }

    public static <T> T[] create(Class<T> tClass, int length, T item) {
        T[] tArray = (T[]) Array.newInstance(tClass, length);

        for (int i = 0; i < tArray.length; i++) {
            tArray[i] = item;
        }
        return tArray;
    }
}
