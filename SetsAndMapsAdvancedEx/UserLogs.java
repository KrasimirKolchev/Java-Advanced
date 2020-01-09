package SetsAndMapsAdvancedEx;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> userIPTimes = new TreeMap<>();
        String command;

        while (!"end".equals(command = scanner.nextLine())) {
            String[] line = command.split("\\s+");
            String address = line[0].substring(3);
            String name = line[2].substring(5);

            userIPTimes.putIfAbsent(name, new LinkedHashMap<>());
            userIPTimes.get(name).putIfAbsent(address, 0);
            userIPTimes.get(name).put(address, userIPTimes.get(name).get(address) + 1);
        }

        userIPTimes.entrySet().stream().forEach(e -> {
            System.out.println(String.format("%s:", e.getKey()));
            System.out.print(e.getValue().toString().replaceAll("\\{|\\}", "")
            .replaceAll("=", " => "));
            System.out.print(".");
            System.out.println();
        });
    }
}
