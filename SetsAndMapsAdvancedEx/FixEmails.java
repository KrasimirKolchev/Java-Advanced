package SetsAndMapsAdvancedEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emails = new LinkedHashMap<>();

        String line;

        while (!"stop".equals(line = scanner.nextLine())) {
            String email = scanner.nextLine();

            emails.putIfAbsent(line, "");
            emails.put(line, email);
        }

        emails.entrySet().stream().filter(e -> {
            String[] info = e.getValue().split("\\.");
            if (info[1].equals("us") || info[1].equals("uk") || info[1].equals("com")) {
                return false;
            } else {
                return true;
            }
        }).forEach(e -> System.out.println(String.format("%s -> %s", e.getKey(), e.getValue())));
    }
}
