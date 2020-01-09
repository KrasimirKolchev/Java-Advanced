package FunctionalProgrammingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rangeTo = Integer.parseInt(reader.readLine());

        int[] numbersToCheck = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Predicate<Integer> checkNumbers = num -> {

            for (int n : numbersToCheck) {
                if (num % n != 0) {
                    return false;
                }
            }
            return true;
        };

        IntStream.rangeClosed(1, rangeTo).filter(s -> checkNumbers.test(s)).forEach(s -> System.out.print(s + " "));
    }
}
