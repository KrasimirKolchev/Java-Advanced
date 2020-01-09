package SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Double> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String student = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Double::parseDouble).collect(Collectors.toList());

            double average = 0;

            for (double num : grades) {
                average += num;
            }

            students.put(student, average / grades.size());
        }

        students.entrySet().stream().forEach(e ->
                System.out.println(String.format("%s is graduated with %s", e.getKey(), e.getValue())));

    }
}
