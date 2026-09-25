//Repository Test
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Instrument> instruments = new ArrayList<>();
        instruments.add(new Piano("Yamaha", 1200.00, "grand"));
        instruments.add(new Piano("Casio", 450.00, "electric keyboard"));
        instruments.add(new Guitar("Taylor", 900.00, "acoustic"));
        instruments.add(new Guitar("Fender", 700.00, "electric"));

        for (Instrument instrument : instruments) {
            System.out.println(instrument);
        }
    }
}
