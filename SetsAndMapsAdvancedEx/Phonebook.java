package SetsAndMapsAdvancedEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contacts = new LinkedHashMap<>();
        String command;

        while (!"search".equals(command = scanner.nextLine())) {

            String[] info = command.split("-");

            contacts.putIfAbsent(info[0], "");
            contacts.put(info[0], info[1]);
        }

        while (!"stop".equals(command = scanner.nextLine())) {

            if (contacts.containsKey(command)) {
                System.out.println(String.format("%s -> %s", command, contacts.get(command)));
            } else {
                System.out.println(String.format("Contact %s does not exist.", command));
            }
        }
    }
}
