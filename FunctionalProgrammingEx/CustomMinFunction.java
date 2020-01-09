package FunctionalProgrammingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Function<int[], Integer> smallestNumber = n -> {
            int min = Integer.MAX_VALUE;
            //int min = Arrays.stream(n).min().getAsInt();

            for (int num : n) {
                if (num < min) {
                    min = num;
                }
            }
            return min;
        };

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        System.out.println(smallestNumber.apply(numbers));
    }
}
