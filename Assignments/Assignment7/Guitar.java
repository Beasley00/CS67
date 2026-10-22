// Guitar.java
// Carter Beasley - Fork of Lanse's original code

public class Guitar extends Instrument {
    private String type;

    public Guitar(String brand, double cost, String type) {
        super(brand, cost);
        this.type = type;
    }

    // Guitar-specific implementations override Instrument's play methods.
    @Override
    public void play() {
        System.out.println(getBrand() + " guitar is playing a chord.");
    }

    @Override
    public void play(int durationSeconds) {
        System.out.println(getBrand() + " guitar is playing for "
                + durationSeconds + " seconds.");
    }

    @Override
    public String toString() {
        return "brand: " + getBrand() + ", cost: $" + getCost()
                + ", type: " + type;
    }
}
