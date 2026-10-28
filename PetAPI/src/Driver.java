import java.util.List;
import java.util.Scanner;

/**
 * Console-based driver program that allows a user to interact with the
 * SQLite Pokemon database ({@code pokemon.db}) through the {@link PokemonAPI} class.
 * Presents an interactive menu of search and filter operations.
 *
 * @author Carter Beasley
 */
public class Driver {

    /**
     * Private constructor to prevent instantiation of the Driver class.
     */
    private Driver() {
        // Driver main class
    }

    /**
     * Main entry point for the console-based Pokemon database driver program.
     * Displays a menu, prompts the user for input, invokes {@link PokemonAPI} methods,
     * and prints the retrieved Pokemon information until the user chooses to exit.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("==================================================");
        System.out.println("   Pokemon Database API Console Driver (Gen 1-3)  ");
        System.out.println("==================================================");

        while (running) {
            printMenu();
            int choice = readInt(scanner, "Enter your choice: ");

            switch (choice) {
                case 1:
                    List<Pokemon> allPokemon = PokemonAPI.getAllPokemon();
                    displayPokemonList(allPokemon, "All Pokemon (Generations 1 - 3)");
                    break;

                case 2:
                    int id = readInt(scanner, "Enter Pokedex ID (1-386): ");
                    Pokemon pokemon = PokemonAPI.getPokemonById(id);
                    if (pokemon != null) {
                        System.out.println("\n--- Pokemon Found ---");
                        System.out.println(pokemon);
                        System.out.printf("Species: %s | Height: %.1f m | Weight: %.1f kg%n",
                                pokemon.getSpecies(), pokemon.getHeightM(), pokemon.getWeightKg());
                    } else {
                        System.out.println("No Pokemon found with ID #" + id + ".");
                    }
                    break;

                case 3:
                    System.out.print("Enter Pokemon name to search: ");
                    String nameQuery = scanner.nextLine().trim();
                    List<Pokemon> nameMatches = PokemonAPI.searchPokemonByName(nameQuery);
                    displayPokemonList(nameMatches, "Search Results for \"" + nameQuery + "\"");
                    break;

                case 4:
                    System.out.print("Enter elemental type (e.g., Fire, Water, Grass, Dragon): ");
                    String type = scanner.nextLine().trim();
                    List<Pokemon> typeMatches = PokemonAPI.getPokemonByType(type);
                    displayPokemonList(typeMatches, "Pokemon of Type: " + type);
                    break;

                case 5:
                    int gen = readInt(scanner, "Enter generation (1, 2, or 3): ");
                    List<Pokemon> genMatches = PokemonAPI.getPokemonByGeneration(gen);
                    displayPokemonList(genMatches, "Generation " + gen + " Pokemon");
                    break;

                case 6:
                    int minTotal = readInt(scanner, "Enter minimum Base Stat Total (e.g., 600): ");
                    List<Pokemon> strongPokemon = PokemonAPI.getPokemonWithMinTotalStats(minTotal);
                    displayPokemonList(strongPokemon, "Pokemon with Base Stat Total >= " + minTotal);
                    break;

                case 7:
                    List<Pokemon> legendaries = PokemonAPI.getLegendaryPokemon();
                    displayPokemonList(legendaries, "Legendary & Mythical Pokemon");
                    break;

                case 8:
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
                    break;
            }
        }

        scanner.close();
    }

    /**
     * Prints the main interactive menu options to the console.
     */
    private static void printMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Display all Pokemon");
        System.out.println("2. Find a Pokemon by ID");
        System.out.println("3. Search for a Pokemon by name");
        System.out.println("4. Display Pokemon by elemental type");
        System.out.println("5. Display Pokemon by generation (1, 2, or 3)");
        System.out.println("6. Display Pokemon with minimum Base Stat Total");
        System.out.println("7. Display all Legendary Pokemon");
        System.out.println("8. Exit");
    }

    /**
     * Displays a formatted list of {@link Pokemon} objects along with a section title and total count.
     *
     * @param list  the list of {@link Pokemon} objects to print
     * @param title the heading to display above the results
     */
    private static void displayPokemonList(List<Pokemon> list, String title) {
        System.out.println("\n=== " + title + " ===");
        if (list == null || list.isEmpty()) {
            System.out.println("No matching Pokemon found.");
            return;
        }
        for (Pokemon p : list) {
            System.out.println(p);
        }
        System.out.println("Total results: " + list.size());
    }

    /**
     * Prompts the user and reads a valid integer from standard input, reprompting on invalid input.
     *
     * @param scanner the {@link Scanner} reading from standard input
     * @param prompt  the prompt message to display to the user
     * @return the integer entered by the user
     */
    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
}
