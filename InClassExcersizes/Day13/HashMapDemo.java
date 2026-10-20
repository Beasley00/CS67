import java.util.HashMap;

public class HashMapDemo {

    public static void main(String[] args) {
        // A HashMap stores key -> value pairs. Keys are unique.
        HashMap<String, Double> prices = new HashMap<String, Double>();

        // put() adds a key-value pair
        prices.put("milk", 3.49);
        prices.put("eggs", 4.29);
        prices.put("bread", 2.99);
        System.out.println(prices);

        // get() looks up a value by its key
        System.out.println("Price of eggs: $" + prices.get("eggs"));

        // get() returns null if the key isn't there
        System.out.println("Price of grapes: " + prices.get("grapes"));

        // put() with an existing key replaces the old value
        prices.put("milk", 3.99);
        System.out.println("New price of milk: $" + prices.get("milk"));

        // containsKey() checks whether a key exists
        if (prices.containsKey("bread")) {
            System.out.println("We sell bread!");
        }

        // remove() deletes a key and its value
        prices.remove("eggs");
        System.out.println("After removing eggs: " + prices);
        System.out.println("Size: " + prices.size());

        // Loop over every key and print its value
        for (String item : prices.keySet()) {
            System.out.println(item + " -> $" + prices.get(item));
        }
    }
}
