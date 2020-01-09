package SetsAndMapsAdvancedEx;

        import java.util.LinkedHashMap;
        import java.util.Map;
        import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> population = new LinkedHashMap<>();
        String command;

        while (!"report".equals(command = scanner.nextLine())) {
            String[] inputInfo = command.split("\\|");

            population.putIfAbsent(inputInfo[1], new LinkedHashMap<>());
            population.get(inputInfo[1]).put(inputInfo[0], Long.parseLong(inputInfo[2]));
        }

        population.entrySet().stream().sorted((a, b) ->
                b.getValue().values().stream().reduce(0L, Long::sum)
                        .compareTo(a.getValue().values().stream().reduce(0L, Long::sum)))
                .forEach(s -> {
                    System.out.println(String.format("%s (total population: %d)",
                            s.getKey(), s.getValue().values().stream().reduce(0L, Long::sum)));
                    population.get(s.getKey()).entrySet().stream().sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                            .forEach(e -> System.out.println(String.format("=>%s: %d", e.getKey(), e.getValue())));
                });

    }
}
