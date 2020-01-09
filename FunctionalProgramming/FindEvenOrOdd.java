package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvenOrOdd {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] line = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String type = reader.readLine();

        Predicate<Integer> even = n -> n % 2 == 0;
        Predicate<Integer> odd = n -> n % 2 != 0;
        Predicate<Integer> byType = even;

        if (type.equals("odd")) {
            byType = odd;
        }

        IntStream.range(line[0], line[1] + 1).boxed()
                .filter(byType).forEach(n -> System.out.print(n + " "));


    }
}
