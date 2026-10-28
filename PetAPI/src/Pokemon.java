/**
 * Represents a Pokemon record retrieved from the SQLite database (`pokemon.db`).
 * Stores Pokedex metadata, elemental types, base combat statistics, physical
 * dimensions, and legendary classification for Generation 1 through 3 Pokemon.
 *
 * @author Carter Beasley
 */
public class Pokemon {

    private int id;
    private String name;
    private int generation;
    private String type1;
    private String type2;
    private String species;
    private int hp;
    private int attack;
    private int defense;
    private int spAttack;
    private int spDefense;
    private int speed;
    private int total;
    private double heightM;
    private double weightKg;
    private boolean isLegendary;

    /**
     * Constructs a new Pokemon object with all attributes from the database.
     *
     * @param id          the National Pokedex number (1 to 386)
     * @param name        the name of the Pokemon
     * @param generation  the generation in which the Pokemon was introduced (1, 2, or 3)
     * @param type1       the primary elemental type (e.g., "Fire", "Water", "Grass")
     * @param type2       the secondary elemental type, or {@code null} if single-typed
     * @param species     the Pokedex classification species (e.g., "Flame Pokemon")
     * @param hp          the base Hit Points (HP) stat
     * @param attack      the base physical Attack stat
     * @param defense     the base physical Defense stat
     * @param spAttack    the base Special Attack stat
     * @param spDefense   the base Special Defense stat
     * @param speed       the base Speed stat
     * @param total       the sum of all six base stats (Base Stat Total)
     * @param heightM     the height of the Pokemon in meters
     * @param weightKg    the weight of the Pokemon in kilograms
     * @param isLegendary {@code true} if the Pokemon is Legendary or Mythical; {@code false} otherwise
     */
    public Pokemon(int id, String name, int generation, String type1, String type2,
                   String species, int hp, int attack, int defense, int spAttack,
                   int spDefense, int speed, int total, double heightM,
                   double weightKg, boolean isLegendary) {
        this.id = id;
        this.name = name;
        this.generation = generation;
        this.type1 = type1;
        this.type2 = type2;
        this.species = species;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spAttack = spAttack;
        this.spDefense = spDefense;
        this.speed = speed;
        this.total = total;
        this.heightM = heightM;
        this.weightKg = weightKg;
        this.isLegendary = isLegendary;
    }

    /**
     * Returns the National Pokedex ID of the Pokemon.
     *
     * @return the Pokedex ID number
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the name of the Pokemon.
     *
     * @return the Pokemon's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the generation in which the Pokemon was introduced.
     *
     * @return the generation number (1, 2, or 3)
     */
    public int getGeneration() {
        return generation;
    }

    /**
     * Returns the primary elemental type of the Pokemon.
     *
     * @return the primary type string
     */
    public String getType1() {
        return type1;
    }

    /**
     * Returns the secondary elemental type of the Pokemon, if any.
     *
     * @return the secondary type string, or {@code null} if the Pokemon has only one type
     */
    public String getType2() {
        return type2;
    }

    /**
     * Returns a formatted string combining the primary and secondary types
     * (for example, "Fire/Flying" or "Electric").
     *
     * @return the combined elemental type string
     */
    public String getFormattedTypes() {
        return (type2 != null && !type2.isEmpty()) ? type1 + "/" + type2 : type1;
    }

    /**
     * Returns the Pokedex species classification of the Pokemon.
     *
     * @return the species description string
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Returns the base HP (Hit Points) stat of the Pokemon.
     *
     * @return the base HP stat
     */
    public int getHp() {
        return hp;
    }

    /**
     * Returns the base Attack stat of the Pokemon.
     *
     * @return the base Attack stat
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Returns the base Defense stat of the Pokemon.
     *
     * @return the base Defense stat
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Returns the base Special Attack stat of the Pokemon.
     *
     * @return the base Special Attack stat
     */
    public int getSpAttack() {
        return spAttack;
    }

    /**
     * Returns the base Special Defense stat of the Pokemon.
     *
     * @return the base Special Defense stat
     */
    public int getSpDefense() {
        return spDefense;
    }

    /**
     * Returns the base Speed stat of the Pokemon.
     *
     * @return the base Speed stat
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Returns the Base Stat Total (sum of HP, Attack, Defense, Sp. Attack, Sp. Defense, and Speed).
     *
     * @return the total base stats
     */
    public int getTotal() {
        return total;
    }

    /**
     * Returns the height of the Pokemon in meters.
     *
     * @return the height in meters
     */
    public double getHeightM() {
        return heightM;
    }

    /**
     * Returns the weight of the Pokemon in kilograms.
     *
     * @return the weight in kilograms
     */
    public double getWeightKg() {
        return weightKg;
    }

    /**
     * Returns whether the Pokemon is classified as Legendary or Mythical.
     *
     * @return {@code true} if the Pokemon is Legendary or Mythical; {@code false} otherwise
     */
    public boolean isLegendary() {
        return isLegendary;
    }

    /**
     * Returns a formatted single-line string representation of the Pokemon suitable
     * for console output.
     *
     * @return a formatted string describing the Pokemon and its stats
     */
    @Override
    public String toString() {
        return String.format("#%-3d %-15s | Gen %d | %-15s | HP: %-3d Atk: %-3d Def: %-3d SpA: %-3d SpD: %-3d Spe: %-3d | Total: %-3d%s",
                id, name, generation, getFormattedTypes(),
                hp, attack, defense, spAttack, spDefense, speed, total,
                isLegendary ? " [LEGENDARY]" : "");
    }
}
