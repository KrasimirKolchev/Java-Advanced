package GenericsEx.CountMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double n = Double.parseDouble(reader.readLine());
        List<CountBoxI<Double>> boxes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            double num = Double.parseDouble(reader.readLine());
            CountBoxI<Double> countBox = new CountBoxI<>(num);

            boxes.add(countBox);
        }

        Double value = Double.parseDouble(reader.readLine());

        int count = countGreater(boxes, value);
        System.out.println(count);
    }

    private static <T extends Comparable<T>> int countGreater(List<CountBoxI<T>> boxes, T value) {
        int count = 0;
        for (CountBoxI<T> box : boxes) {
            if (box.getData().compareTo(value) > 0) {
                count++;
            }
        }
        return count;
    }
}
