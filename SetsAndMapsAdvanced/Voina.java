package SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = playerCards(scanner.nextLine());
        Set<Integer> secondPlayer = playerCards(scanner.nextLine());


        for (int i = 0; i < 50; i++) {

            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                break;
            }

            int first = firstPlayer.iterator().next();
            firstPlayer.remove(first);
            int second = secondPlayer.iterator().next();
            secondPlayer.remove(second);

            if (first > second) {
                firstPlayer.add(first);
                firstPlayer.add(second);
            } else if (first < second) {
                secondPlayer.add(first);
                secondPlayer.add(second);
            }
        }


        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (firstPlayer.size() < secondPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    private static Set<Integer> playerCards(String line) {
        Set<Integer> cards = new LinkedHashSet<>();
        Arrays.stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(cards::add);

        return cards;
    }
}
