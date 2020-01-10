package ExamPrep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class TrojanInvasion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int waves = Integer.parseInt(reader.readLine());

        ArrayDeque<Integer> platesQ = new ArrayDeque<>();
        ArrayDeque<Integer> warriorsS = new ArrayDeque<>();
        String[] line = reader.readLine().split("\\s+");
        for (String l : line) {
            platesQ.offer(Integer.parseInt(l));
        }

        for (int i = 1; i <= waves && !platesQ.isEmpty(); i++) {

            String[] wave = reader.readLine().split("\\s+");

            for (String w : wave) {
                warriorsS.push(Integer.parseInt(w));
            }

            if (i % 3 == 0) {
                platesQ.offer(Integer.parseInt(reader.readLine()));
            }

            while (!platesQ.isEmpty() && !warriorsS.isEmpty()) {
                int plate = platesQ.poll();
                int warrior = warriorsS.pop();

                if (plate > warrior) {
                    plate -= warrior;
                    platesQ.addFirst(plate);
                } else if (plate < warrior) {
                    warrior -= plate;
                    warriorsS.push(warrior);
                }
            }
        }

        if (platesQ.isEmpty()) {
            System.out.println("The Trojans successfully destroyed the Spartan defense.");
            System.out.println(String.format("Warriors left: %s", String.join(", ",
                    warriorsS.toString().replaceAll("\\[|\\]", ""))));
        } else {
            System.out.println("The Spartans successfully repulsed the Trojan attack.");
            System.out.println(String.format("Plates left: %s", String.join(", ",
                    platesQ.toString().replaceAll("\\[|\\]", ""))));
        }
    }
}
