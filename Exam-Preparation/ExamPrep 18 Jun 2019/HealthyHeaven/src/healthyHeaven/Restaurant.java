package healthyHeaven;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurant {
    private List<Salad> salads;

    private String name;

    public Restaurant(String name) {
        this.name = name;
        this.salads = new ArrayList<>();
    }

    public void add(Salad salad) {
        this.salads.add(salad);
    }

    public boolean buy(String salad) {

        if (salads.contains(salad)) {
            salads.remove(salad);
            return true;
        } else {
            return false;
        }
    }

    public String getHealthiestSalad() {
        Salad salad = salads.stream().min(Comparator.comparingInt(Salad::getTotalCalories)).orElse(null);

        return salad == null ? "" : salad.getName();
    }

    public String generateMenu() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%s have %d salads:", this.name, this.salads.size()));
        for (Salad salad: salads) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(salad.toString());
        }
        return stringBuilder.toString();
    }
}
