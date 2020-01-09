package DefiningClasses.CarInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] carInput = reader.readLine().split("\\s+");
            String make = carInput[0];

            if (carInput.length > 1) {

                String model = carInput[1];
                int horsePower = Integer.parseInt(carInput[2]);
                Car car = new Car(make, model, horsePower);
                cars.add(car);
            } else {
                Car car = new Car(make);
                cars.add(car);
            }

        }

        cars.forEach(car -> System.out.println(car.carInfo()));
    }
}
