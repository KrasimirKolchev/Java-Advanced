package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> inputNumbers = Arrays.stream(reader.readLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        inputNumbers.removeIf(n -> n % 2 != 0);
        System.out.println(inputNumbers.toString().replaceAll("\\[|\\]", ""));
        inputNumbers.sort(Comparator.naturalOrder());
        System.out.println(inputNumbers.toString().replaceAll("\\[|\\]", ""));
    }
}
