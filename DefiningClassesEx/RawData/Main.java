package DefiningClassesEx.RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] lineInfo = reader.readLine().split("\\s+");

            new Car(lineInfo[0], Integer.parseInt(lineInfo[1]), Integer.parseInt(lineInfo[2]),
            Integer.parseInt(lineInfo[3]), lineInfo[4], Double.parseDouble(lineInfo[5]), Integer.parseInt(lineInfo[6]),
            Double.parseDouble(lineInfo[7]), Integer.parseInt(lineInfo[8]), Double.parseDouble(lineInfo[9]),
            Integer.parseInt(lineInfo[10]), Double.parseDouble(lineInfo[11]), Integer.parseInt(lineInfo[12]));
        }

        String command = reader.readLine();

        if (command.equals("fragile")) {
            Car.cars.stream().filter(car -> car.getCargo().getCargoType().equals("fragile"))
                    .filter(car -> car.getTires().minPres() < 1).forEach(Car::printModel);
        } else {
            Car.cars.stream().filter(car -> car.getCargo().getCargoType().equals("flamable"))
                    .filter(car -> car.getEngine().getEnginePower() > 250)
                    .forEach(Car::printModel);
        }
    }
}
