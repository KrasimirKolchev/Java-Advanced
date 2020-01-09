package GenericsEx.Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line1 = reader.readLine();
        String names = line1.substring(0, line1.lastIndexOf(' '));
        String address = line1.substring(line1.lastIndexOf(' ') + 1);

        String line2 = reader.readLine();
        String name = line2.substring(0, line2.lastIndexOf(' '));
        int value2 = Integer.parseInt(line2.substring(line2.lastIndexOf(' ') + 1));

        String line3 = reader.readLine();
        int val1 = Integer.parseInt(line3.substring(0, line3.lastIndexOf(' ')));
        double val2 = Double.parseDouble(line3.substring(line3.lastIndexOf(' ') + 1));

        Tuple<String, String> first = new Tuple<>(names, address);
        Tuple<String, Integer> second = new Tuple<>(name, value2);
        Tuple<Integer, Double> third = new Tuple<>(val1, val2);

        System.out.println(String.format("%s -> %s",first.getItem1(), first.getItem2()));
        System.out.println(String.format("%s -> %s",second.getItem1(), second.getItem2()));
        System.out.println(String.format("%s -> %s",third.getItem1(), third.getItem2()));

    }
}
