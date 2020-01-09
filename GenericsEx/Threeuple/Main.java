package GenericsEx.Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = reader.readLine().split("\\s+");
        String name = line1[0] + " " + line1[1];
        String address = line1[2];
        String town = line1[3];

        String[] line2 = reader.readLine().split("\\s+");
        String name2 = line2[0];
        int beers = Integer.parseInt(line2[1]);
        boolean drunkOrNot = isDrunk(line2[2]);

        String[] line3 = reader.readLine().split("\\s+");
        String name3 = line3[0];
        double balance = Double.parseDouble(line3[1]);
        String bank = line3[2];

        Treeuple<String, String, String> first = new Treeuple<>(name, address, town);
        Treeuple<String, Integer, Boolean> second = new Treeuple<>(name2, beers, drunkOrNot);
        Treeuple<String, Double, String> third= new Treeuple<>(name3, balance, bank);

        System.out.println(first.toString());
        System.out.println(second.toString());
        System.out.println(third.toString());
    }

    private static boolean isDrunk(String s) {
        if (s.equals("drunk")) {
            return true;
        }
        return false;
    }
}
