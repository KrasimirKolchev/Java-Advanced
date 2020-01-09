package GenericsEx.SwapMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<BoxI<Integer>> boxes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(reader.readLine());
            BoxI<Integer> box = new BoxI<>(num);

            boxes.add(box);
        }
        String[] num = reader.readLine().split("\\s+");

        swapElements(boxes, Integer.parseInt(num[0]), Integer.parseInt(num[1]));

        for (BoxI<Integer> b : boxes) {
            System.out.println(b.toString());
        }
    }

    private static void swapElements(List<BoxI<Integer>> boxes, int first, int second) {
        BoxI<Integer> temp = boxes.get(first);

        boxes.set(first, boxes.get(second));
        boxes.set(second, temp);
    }
}
