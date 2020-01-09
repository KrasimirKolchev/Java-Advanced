package SetsAndMapsAdvancedEx;

import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command;
        Map<String, HashSet<String>> players = new LinkedHashMap<>();

        while (!"JOKER".equals(command = scanner.nextLine())) {
            String name = command.substring(0, command.indexOf(":"));

           ArrayList<String> hand = Arrays.stream(command.substring(command.indexOf(":") + 2).split(", "))
                   .collect(Collectors.toCollection(ArrayList::new));

            if (!players.containsKey(name)) {
                players.put(name, new HashSet<>());
                players.get(name).addAll(hand);
            } else {
                players.get(name).addAll(hand);
            }
        }

        for (Map.Entry<String, HashSet<String>> item : players.entrySet()) {
            
            int handPower = calculateHand(item.getValue());

            System.out.println(String.format("%s: %d", item.getKey(), handPower));

        }

    }

    private static int calculateHand(HashSet<String> hand) {

        int handPower = 0;

        for (String card : hand) {

            int power = 0;

            if (Character.isDigit(card.charAt(0)) && card.charAt(0) != '1') {
                power += card.charAt(0) - '0';
            } else {
                switch (card.charAt(0)) {
                    case '1' :
                        power += 10;
                        break;
                    case 'J' :
                        power += 11;
                        break;
                    case 'Q' :
                        power += 12;
                        break;
                    case 'K' :
                        power += 13;
                        break;
                    case 'A' :
                        power += 14;
                        break;
                }
            }

            switch (card.charAt(card.length() - 1)) {
                case 'D' :
                    power *= 2;
                    break;
                case 'H' :
                    power *= 3;
                    break;
                case 'S' :
                    power *= 4;
                    break;
            }
            handPower += power;
        }
        return handPower;
    }
}
