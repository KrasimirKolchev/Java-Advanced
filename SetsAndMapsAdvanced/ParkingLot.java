package SetsAndMapsAdvanced;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parkingLotCars = new HashSet<>();

        String command;

        while (!"END".equals(command = scanner.nextLine())) {
            String[] carInfo = command.split(",\\s+");

            switch (carInfo[0]) {
                case ("IN") :
                    parkingLotCars.add(carInfo[1]);
                    break;
                case ("OUT") :
                    parkingLotCars.remove(carInfo[1]);
                    break;
            }
        }

        if (parkingLotCars.size() > 0) {
            parkingLotCars.forEach(System.out::println);
        } else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
