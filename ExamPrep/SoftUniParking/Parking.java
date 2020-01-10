package ExamPrep.SoftUniParking;

import java.util.LinkedHashMap;
import java.util.Map;

public class Parking {
    private Map<String, Car> cars;
    private int capacity;

    public Parking(int capacity) {
        this.cars = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public String addCar(Car car) {
        if (this.cars.containsKey(car.getRegistrationNumber())) {
            return "Car with that registration number, already exists!";
        } else if (this.cars.size() == this.capacity) {
            return "Parking is full!";
        }
        this.cars.put(car.getRegistrationNumber(), car);
        return String.format("Successfully added new car %s %s", car.getMake(), car.getRegistrationNumber());
    }

    public String removeCar(String number) {
        if (!this.cars.containsKey(number)) {
            return "Car with that registration number, doesn't exists!";
        }
        this.cars.remove(number);
        return String.format("Successfully removed %s", number);
    }

    public Car getCar(String plate) {
        return this.cars.get(plate);
    }

    public int getCount() {
        return this.cars.size();
    }
}
