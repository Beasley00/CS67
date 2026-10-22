// Main.java
// Carter Beasley - Fork of Lanse's original code

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize the list of instruments.
        ArrayList<Instrument> instruments = new ArrayList<>();
        instruments.add(new Piano("Yamaha", 1200.00, "grand"));
        instruments.add(new Piano("Casio", 450.00, "electric keyboard"));
        instruments.add(new Guitar("Taylor", 900.00, "acoustic"));
        instruments.add(new Guitar("Fender", 700.00, "electric"));
        
        // Initialize the scanner for user input.
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // User.
        while (running) {
            System.out.println("\nInstrument Menu");
            System.out.println("1. View instruments");
            System.out.println("2. Play an instrument");
            System.out.println("3. Add an instrument");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    displayInstruments(instruments);
                    break;
                case "2":
                    playInstrument(scanner, instruments);
                    break;
                case "3":
                    addInstrument(scanner, instruments);
                    break;
                case "4":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Please choose an option from 1 to 4.");
            }
        }

        scanner.close();
    }

    // Display all instruments in the list.
    private static void displayInstruments(ArrayList<Instrument> instruments) {
        for (int i = 0; i < instruments.size(); i++) {
            System.out.println((i + 1) + ". " + instruments.get(i));
        }
    }

    // Play a selected instrument.
    private static void playInstrument(Scanner scanner,
            ArrayList<Instrument> instruments) {
        displayInstruments(instruments);
        int instrumentNumber = readInteger(scanner, "Choose an instrument: ");

        if (instrumentNumber < 1 || instrumentNumber > instruments.size()) {
            System.out.println("That instrument does not exist.");
            return;
        }
    
        Instrument instrument = instruments.get(instrumentNumber - 1);
        int duration = readInteger(scanner,
                "Enter duration in seconds, or 0 for the default: ");
        // The selected overload depends on whether a duration was entered.
        if (duration > 0) {
            instrument.play(duration);
        } else {
            instrument.play();
        }
    }

    // Add a new instrument to the list.
    private static void addInstrument(Scanner scanner,
            ArrayList<Instrument> instruments) {
        System.out.print("Enter instrument type (piano/guitar): ");
        String instrumentType = scanner.nextLine().toLowerCase();
        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();
        double cost = readDouble(scanner, "Enter cost: ");
        System.out.print("Enter style or type: ");
        String type = scanner.nextLine();

        if (instrumentType.equals("piano")) {
            instruments.add(new Piano(brand, cost, type));
        } else if (instrumentType.equals("guitar")) {
            instruments.add(new Guitar(brand, cost, type));
        } else {
            System.out.println("Unknown instrument type.");
            return;
        }

        System.out.println("Instrument added.");
    }

    // Read a double value from the user.
    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    // Read an integer value from the user.
    private static int readInteger(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception) {
                // Keep asking until the user enters a whole number.
                System.out.println("Please enter a whole number.");
            }
        }
    }
}
