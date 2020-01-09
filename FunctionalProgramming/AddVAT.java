package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Double> prices = Arrays.stream(reader.readLine().split(", "))
                .map(Double::parseDouble).collect(Collectors.toList());

        UnaryOperator<Double> addVAT = n -> n * 1.2;
        System.out.println("Prices with VAT:");

        for (Double num : prices) {
            System.out.println(String.format("%.2f", addVAT.apply(num)));
        }
    }
}
