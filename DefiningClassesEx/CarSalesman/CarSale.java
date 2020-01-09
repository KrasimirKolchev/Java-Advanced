package DefiningClassesEx.CarSalesman;

import java.util.ArrayList;
import java.util.List;

public class CarSale {
    static List<CarSale> carSales = new ArrayList<>();
    private String model;
    private String engine;
    private String weight;
    private String color;

    public CarSale(String model, String engine) {
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public String getModel() {
        return model;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

