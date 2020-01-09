package DefiningClassesEx.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;

public class SpeedCar {

    static Map<String, SpeedCar> speedCarMap = new LinkedHashMap<>();

    private String model;
    private double fuelAmount;
    private double fuelPerKM;
    private int distanceTraveled;

    public SpeedCar(String model, double fuelAmount, double fuelPerKM) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelPerKM = fuelPerKM;
        this.distanceTraveled = 0;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelPerKM() {
        return fuelPerKM;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }
}
