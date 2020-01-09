package SetsAndMapsAdvancedEx;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAgregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, Integer>> userIPLogs = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            userIPLogs.putIfAbsent(line[1], new TreeMap<>());
            userIPLogs.get(line[1]).putIfAbsent(line[0], 0);
            userIPLogs.get(line[1]).put(line[0], userIPLogs.get(line[1]).get(line[0]) + Integer.parseInt(line[2]));
        }

        userIPLogs.entrySet().stream().forEach(e -> {
            int sum = 0;
            for (int num : e.getValue().values()) {
                sum += num;
            }

            System.out.print(String.format("%s: %d ", e.getKey(), sum));
            System.out.print(e.getValue().keySet().toString() + "\n");
        });
    }
}
