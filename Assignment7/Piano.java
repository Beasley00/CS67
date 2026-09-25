public class Piano extends Instrument {
    private String type;

    public Piano(String brand, double cost, String type) {
        super(brand, cost);
        this.type = type;
    }

    @Override
    public String toString() {
        return "brand: " + getBrand() + ", cost: $" + getCost()
                + ", type: " + type;
    }
}
