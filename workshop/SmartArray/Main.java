package workshop.SmartArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        SmartArray smartArray = new SmartArray();
        smartArray.add(1);
        smartArray.add(2);
        smartArray.add(3);
        smartArray.add(4);
        smartArray.add(5);
        smartArray.add(1, 3);
        smartArray.contains(2);
        smartArray.get(3);
        smartArray.remove(3);
        smartArray.forEach(e -> System.out.println(e));
    }
}
