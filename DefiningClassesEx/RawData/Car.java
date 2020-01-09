package DefiningClassesEx.RawData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Car {
    static List<Car> cars = new ArrayList<>();
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tires;

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType,
               double tire1Pres, int tire1age, double tire2Pres, int tire2age,
               double tire3Pres, int tire3age, double tire4Pres, int tire4age) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tires = new Tire(tire1Pres, tire1age, tire2Pres, tire2age, tire3Pres, tire3age, tire4Pres, tire4age);

        cars.add(this);
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tire getTires() {
        return tires;
    }

    void printModel() {
        System.out.println(this.model);
    }
}

class Engine {
    private int engineSpeed;
    private int enginePower;

    public Engine(int engineSpeed, int enginePower) {
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }

    public int getEnginePower() {
        return enginePower;
    }
}

class Cargo {
    private int cargoWeight;
    private String cargoType;

    public Cargo(int cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    public String getCargoType() {
        return cargoType;
    }
}

class Tire {
    private double tire1Pres;
    private int tire1age;
    private double tire2Pres;
    private int tire2age;
    private double tire3Pres;
    private int tire3age;
    private double tire4Pres;
    private int tire4age;

    public Tire(double tire1Pres, int tire1age, double tire2Pres, int tire2age,
                double tire3Pres, int tire3age, double tire4Pres, int tire4age) {
        this.tire1Pres = tire1Pres;
        this.tire1age = tire1age;
        this.tire2Pres = tire2Pres;
        this.tire2age = tire2age;
        this.tire3Pres = tire3Pres;
        this.tire3age = tire3age;
        this.tire4Pres = tire4Pres;
        this.tire4age = tire4age;
    }

    public double minPres() {
        return Collections.min(Arrays.asList(this.tire1Pres, this.tire2Pres, this.tire3Pres, this.tire4Pres));
    }
}
