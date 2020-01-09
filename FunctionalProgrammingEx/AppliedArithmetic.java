package FunctionalProgrammingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(ArrayList::new));

        Function<ArrayList<Integer>, ArrayList<Integer>> increment = n -> n.stream()
                .map(e -> e += 1).collect(Collectors.toCollection(ArrayList::new));
        UnaryOperator<ArrayList<Integer>> multiply = n -> n.stream()
                .map(e -> e *= 2).collect(Collectors.toCollection(ArrayList::new));
        UnaryOperator<ArrayList<Integer>> subtract = n -> n.stream()
                .map(e -> e -= 1).collect(Collectors.toCollection(ArrayList::new));
        Consumer<ArrayList<Integer>> printNumbers = n -> n.forEach(e -> System.out.print(e + " "));

        String command;

        while (!"end".equals(command = reader.readLine())) {

            switch (command) {
                case "add" :
                    numbers = increment.apply(numbers);
                    break;
                case "multiply" :
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract" :
                    numbers = subtract.apply(numbers);
                    break;
                case "print" :
                    printNumbers.accept(numbers);
                    System.out.println();
                    break;
            }
        }
    }
}
