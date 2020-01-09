package DefiningClassesEx.CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] lineInfo;
        Map<CarSale, Engine> carEngine = new LinkedHashMap<>();
        Map<String, Engine> nameEngine = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            lineInfo = reader.readLine().split("\\s+");
            String engineModel = lineInfo[0];
            int enginePower = Integer.parseInt(lineInfo[1]);

            Engine engine = new Engine(engineModel, enginePower);
            if (lineInfo.length == 3) {
                if (Character.isDigit(lineInfo[2].charAt(0))) {
                    engine.setDisplacement(lineInfo[2]);
                } else {
                    engine.setEfficiency(lineInfo[2]);
                }
            } else if (lineInfo.length == 4) {
                engine.setDisplacement(lineInfo[2]);
                engine.setEfficiency(lineInfo[3]);
            }
            nameEngine.put(engineModel, engine);
        }

        n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            lineInfo = reader.readLine().split("\\s+");

            String model = lineInfo[0];
            String engine1 = lineInfo[1];
            CarSale carSale = new CarSale(model, engine1);

            if (lineInfo.length == 3) {
                if (Character.isDigit(lineInfo[2].charAt(0))) {
                    carSale.setWeight(lineInfo[2]);
                } else {
                    carSale.setColor(lineInfo[2]);
                }
            } else if (lineInfo.length == 4) {
                carSale.setWeight(lineInfo[2]);
                carSale.setColor(lineInfo[3]);
            }

            carEngine.put(carSale, nameEngine.get(engine1));
        }

        carEngine.entrySet().stream()
                .forEach(e -> System.out.println(
                        String.format("%s:\n%s:\nPower: %s\nDisplacement: %s\nEfficiency: %s\n" +
                                        "Weight: %s\nColor: %s",
                                e.getKey().getModel(), e.getValue().getEngineModel(), e.getValue().getEnginePower(),
                                e.getValue().getDisplacement(), e.getValue().getEfficiency(),
                                e.getKey().getWeight(), e.getKey().getColor()
                        )));
    }
}











