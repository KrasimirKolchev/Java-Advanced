package DefiningClassesEx.SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] info = reader.readLine().split("\\s+");

            SpeedCar.speedCarMap.putIfAbsent(info[0], new SpeedCar(info[0], Double.parseDouble(info[1]), Double.parseDouble(info[2])));
        }

        String command;
        while (!"End".equals(command = reader.readLine())) {
            String[] info = command.split("\\s+");

            if (SpeedCar.speedCarMap.containsKey(info[1])) {
                double fuel = SpeedCar.speedCarMap.get(info[1]).getFuelAmount();
                double fuelCost = SpeedCar.speedCarMap.get(info[1]).getFuelPerKM();
                double currentFuel = SpeedCar.speedCarMap.get(info[1]).getFuelAmount();
                int currentDist = SpeedCar.speedCarMap.get(info[1]).getDistanceTraveled();

                if (fuel >= (fuelCost * Integer.parseInt(info[2])) && currentFuel > 0) {
                    SpeedCar.speedCarMap.get(info[1]).setDistanceTraveled(currentDist + Integer.parseInt(info[2]));
                    SpeedCar.speedCarMap.get(info[1]).setFuelAmount(currentFuel - (fuelCost * Integer.parseInt(info[2])));
                } else {
                    System.out.println("Insufficient fuel for the drive");
                }
            }
        }

        SpeedCar.speedCarMap.entrySet().stream().forEach(e ->
                System.out.println(String.format("%s %.2f %d",
                        e.getValue().getModel(), e.getValue().getFuelAmount(), e.getValue().getDistanceTraveled())));
    }
}