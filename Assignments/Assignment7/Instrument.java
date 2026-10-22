// Instrument.java
// Carter Beasley - Fork of Lanse's original code

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

    // They can be overridden by subclasses for specific behaviors.
    public void play() {
        System.out.println(getBrand() + " is being played.");
    }

    public void play(int durationSeconds) {
        System.out.println(getBrand() + " is being played for "
                + durationSeconds + " seconds.");
    }

    @Override
    public String toString() {
        return "brand: " + brand + ", cost: $" + cost;
    }
}
