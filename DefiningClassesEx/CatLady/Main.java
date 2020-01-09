package DefiningClassesEx.CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Siamese> siameseMap = new LinkedHashMap<>();
        Map<String, Cymric> cymricMap = new LinkedHashMap<>();
        Map<String, StreetExtraordinaire> streetExtraordinaireMap = new LinkedHashMap<>();

        String command;

        while (!"End".equals(command = reader.readLine())) {

            String[] lineInfo = command.split("\\s+");

            String breed = lineInfo[0];
            String name = lineInfo[1];
            double characteristic = Double.parseDouble(lineInfo[2]);

            if (breed.equals("Siamese")) {
                Siamese siamese = new Siamese(name, characteristic);
                siameseMap.putIfAbsent(name, siamese);
            } else if (breed.equals("Cymric")) {
                Cymric cymric = new Cymric(name, characteristic);
                cymricMap.putIfAbsent(name, cymric);
            } else {
                StreetExtraordinaire streetExtraordinaire = new StreetExtraordinaire(name, characteristic);
                streetExtraordinaireMap.putIfAbsent(name, streetExtraordinaire);
            }
        }

        command = reader.readLine();

        if (siameseMap.containsKey(command)) {
            System.out.println(String.format("Siamese %s %.2f",
                    siameseMap.get(command).getName(), siameseMap.get(command).getEarSize()));
        } else if (cymricMap.containsKey(command)) {
            System.out.println(String.format("Cymric %s %.2f",
                    cymricMap.get(command).getName(), cymricMap.get(command).getFurLength()));
        } else if (streetExtraordinaireMap.containsKey(command)) {
            System.out.println(String.format("StreetExtraordinaire %s %.2f",
                    streetExtraordinaireMap.get(command).getName(), streetExtraordinaireMap.get(command).getMeowDecibels()));
        }
    }
}
