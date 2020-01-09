package SetsAndMapsAdvanced;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            studentsGrades.putIfAbsent(line[0], new ArrayList<>());
            studentsGrades.get(line[0]).add(Double.parseDouble(line[1]));
        }

        studentsGrades.entrySet().stream().forEach(e -> {
            System.out.print(e.getKey() + " -> ");
            double sum = 0;

            for (double el : e.getValue()) {
                sum += el;
                System.out.printf("%.2f ", el);
            }

            System.out.print(String.format("(avg: %.2f)%n", sum / e.getValue().size()));
        });
    }
}
