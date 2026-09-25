public class Instrument {
    private String brand;
    private double cost;

    public Instrument(String brand, double cost) {
        this.brand = brand;
        this.cost = cost;
    }

    public String getBrand() {
        return brand;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "brand: " + brand + ", cost: $" + cost;
    }
}
