// Piano.java
// Carter Beasley - Fork of Lanse's original code

public class Piano extends Instrument {
    private String type;

    public Piano(String brand, double cost, String type) {
        super(brand, cost);
        this.type = type;
    }

    // Piano-specific implementations override Instrument's play methods.
    @Override
    public void play() {
        System.out.println(getBrand() + " piano is playing a melody.");
    }

    @Override
    public void play(int durationSeconds) {
        System.out.println(getBrand() + " piano is playing for "
                + durationSeconds + " seconds.");
    }

    @Override
    public String toString() {
        return "brand: " + getBrand() + ", cost: $" + getCost()
                + ", type: " + type;
    }
}
