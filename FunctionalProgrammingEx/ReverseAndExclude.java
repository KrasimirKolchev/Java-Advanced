package FunctionalProgrammingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numberList = Arrays.stream(reader.readLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());
        int n = Integer.parseInt(reader.readLine());

        Predicate<Integer> divisible = num -> num % n != 0;

        Consumer<List<Integer>> printNumber = numbers -> {
            for (int i = numbers.size() - 1; i >= 0; i--) {
                if (divisible.test(numberList.get(i))) {
                    System.out.print(numberList.get(i) + " ");
                }
            }
        };

        printNumber.accept(numberList);
    }
}
