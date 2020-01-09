package FunctionalProgrammingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class KnightsOfHonour {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Consumer<String> printName = name -> System.out.println("Sir " + name);

        Arrays.stream(reader.readLine().split("\\s+")).forEach(printName);
    }
}
