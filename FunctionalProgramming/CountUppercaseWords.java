package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] text = reader.readLine().split("\\s+");

        Predicate<String> isUpperCase = s -> Character.isUpperCase(s.charAt(0));
        List<String> result = Arrays.stream(text).filter(isUpperCase).collect(Collectors.toList());

        System.out.println(result.size());
        result.forEach(System.out::println);
    }
}
