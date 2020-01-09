package IteratorsAndComparatorsEx.ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> line = Arrays.stream(reader.readLine().split("\\s+")).skip(1)
                .collect(Collectors.toCollection(ArrayList::new));

        ListyIterator listyIterator = new ListyIterator(line);

        String command;

        while (!"END".equals(command = reader.readLine())) {

            switch (command) {
                case "Move" :
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext" :
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print" :
                    listyIterator.print();
                    break;
                case "PrintAll" :
                    for (String t : listyIterator) {
                        System.out.print(t + " ");
                    }
                    System.out.println();
                    break;
            }
        }
    }
}
