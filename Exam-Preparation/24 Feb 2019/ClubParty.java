package ExamPrep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ClubParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int capacity = Integer.parseInt(reader.readLine());

        ArrayDeque<String> inputInfoS = new ArrayDeque<>();
        String[] line = reader.readLine().split("\\s+");
        for (String s : line) {
            inputInfoS.push(s);
        }

        ArrayDeque<String> hallQ = new ArrayDeque<>();
        int currentCap = 0;
        List<String> reservations = new ArrayList<>();

        while (inputInfoS.size() > 0) {
            String item = inputInfoS.pop();

            if (!Character.isDigit(item.charAt(0))) {
                hallQ.offer(item);
            } else {
                int reservation = Integer.parseInt(item);

                if (!hallQ.isEmpty()) {
                    if (currentCap + reservation <= capacity) {
                        currentCap += reservation;
                        reservations.add(item);
                        if (currentCap == capacity) {
                            System.out.println(String.format("%s -> %s", hallQ.poll(),
                                    reservations.toString().replaceAll("\\[|\\]", "")));
                            currentCap = 0;
                            reservations.clear();
                        }
                    } else {
                        System.out.println(String.format("%s -> %s", hallQ.poll(),
                                reservations.toString().replaceAll("\\[|\\]", "")));
                        reservations.clear();
                        if (!hallQ.isEmpty()) {
                            currentCap = reservation;
                            reservations.add(item);
                        } else {
                            currentCap = 0;
                        }
                    }
                }
            }
        }
    }
}
