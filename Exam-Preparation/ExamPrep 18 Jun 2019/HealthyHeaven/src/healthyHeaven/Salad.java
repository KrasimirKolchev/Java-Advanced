package healthyHeaven;


import java.util.ArrayList;
import java.util.List;

public class Salad {
    private List<Vegetable> products;

    private String name;


    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Vegetable> getProducts() {
        return products;
    }

    public void add(Vegetable vegetable) {
        this.products.add(vegetable);
    }

    public int getTotalCalories() {
        int sum = 0;
        for (Vegetable n : products) {
            sum += n.getCalories();
        }
        return sum;
    }

    public int getProductCount() {
        return products.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("* Salad %s is %d calories and have %d products: ",
                getName(), getTotalCalories(), getProductCount()));

        for (Vegetable v : this.getProducts()) {
            sb.append(System.lineSeparator());
            sb.append(String.format(" - %s have %d calories", v.getName(), v.getCalories()));
        }

        return sb.toString();
    }
}
