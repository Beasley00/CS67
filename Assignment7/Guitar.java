public class Guitar extends Instrument {
    private String type;

    public Guitar(String brand, double cost, String type) {
        super(brand, cost);
        this.type = type;
    }

    @Override
    public String toString() {
        return "brand: " + getBrand() + ", cost: $" + getCost()
                + ", type: " + type;
    }
}
