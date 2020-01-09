package SetsAndMapsAdvanced;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftuniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> ticketsRegular = new TreeSet<>();
        Set<String> ticketsVIP = new TreeSet<>();

        String command;

        while (!"PARTY".equals(command = scanner.nextLine())) {

            if (Character.isDigit(command.charAt(0))) {
                ticketsVIP.add(command);
            } else {
                ticketsRegular.add(command);
            }
        }

        while (!"END".equals(command = scanner.nextLine())) {

            if (Character.isDigit(command.charAt(0))) {
                ticketsVIP.remove(command);
            } else {
                ticketsRegular.remove(command);
            }
        }

        System.out.println(ticketsRegular.size() + ticketsVIP.size());

        if (!ticketsVIP.isEmpty()) {
            ticketsVIP.forEach(System.out::println);
        }
        if (!ticketsRegular.isEmpty()) {
            ticketsRegular.stream().forEach(System.out::println);
        }
    }
}
