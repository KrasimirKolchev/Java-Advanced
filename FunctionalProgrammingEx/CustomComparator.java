package FunctionalProgrammingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = reader.readLine().split("\\s+");
        Integer[] numbers = new Integer[line.length];

        for (int i = 0; i < line.length; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }

        Comparator<Integer> comparator = (first, second) -> {
            int result;

            if (first % 2 == 0 && second % 2 != 0) {
                result = -1;
            } else if (second % 2 == 0 && first % 2 != 0) {
                result = 1;
            } else {
                result = first - second;
            }
            return result;
        };

        Arrays.sort(numbers, comparator);
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
    }
}
