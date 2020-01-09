package SetsAndMapsAdvancedEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command;
        Map<String, Map<String, Integer>> venueSingerAmount = new LinkedHashMap<>();

        while (!"End".equals(command = scanner.nextLine())) {
            String regex = "^(?<a>([A-Za-z]+[ ]?[A-Za-z]+[ ]?[A-Za-z]+)) @(?<b>([A-Za-z]+[ ]?[A-Za-z]+[ ]?[A-Za-z]+)) (?<c>[\\d]+) (?<d>[\\d]+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(command);

            while (matcher.find()) {
                String name = matcher.group("a");
                String venue = matcher.group("b");
                int price = Integer.parseInt(matcher.group("c"));
                int people = Integer.parseInt(matcher.group("d"));
                int sum = price * people;

                venueSingerAmount.putIfAbsent(venue, new LinkedHashMap<>());
                venueSingerAmount.get(venue).putIfAbsent(name, 0);
                venueSingerAmount.get(venue).put(name, venueSingerAmount.get(venue).get(name) + sum);
            }
        }

        venueSingerAmount.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey());
            e.getValue().entrySet().stream().sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(e1 -> System.out.println(String.format("#  %s -> %d", e1.getKey(), e1.getValue())));
        });
    }
}
