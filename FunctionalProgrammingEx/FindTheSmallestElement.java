package FunctionalProgrammingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Consumer<int[]> print = n -> {
            int min = n[0];
            int index = 0;

            for (int i = 0; i < n.length; i++) {
                if (n[i] <= min) {
                    min = n[i];
                    index = i;
                }
            }
            System.out.println(index);
        };

        print.accept(numbers);
    }
}
