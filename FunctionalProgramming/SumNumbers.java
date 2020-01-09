package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> numbers = Arrays.stream(reader.readLine().split(",\\s+")).collect(Collectors.toList());

        if (numbers.size() < 2) {
            if (numbers.size() == 1) {
                System.out.println(String.format("Count = %d\nSum = %s", numbers.size(), numbers.get(0)));
            } else {
                System.out.println("Count = 0\nSum = 0");
            }

        } else {
            Function<String, Integer> function = n -> Integer.parseInt(n);

            int sum = 0;

            for (String n : numbers) {
                sum += function.apply(n);
            }
            System.out.println(String.format("Count = %d\nSum = %d", numbers.size(), sum));
        }
    }
}
