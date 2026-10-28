import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides a static Java API for querying the SQLite Pokemon database ({@code pokemon.db}).
 * Manages database connections and exposes methods to retrieve Pokemon records
 * by ID, name, elemental type, generation, legendary status, and base stat totals.
 *
 * @author Carter Beasley
 */
public class PokemonAPI {

    /** JDBC connection URL for the local SQLite database file. */
    private static final String DB_URL = "jdbc:sqlite:pokemon.db";

    /**
     * Private constructor to prevent instantiation of this static utility API class.
     */
    private PokemonAPI() {
        // Static API class
    }

    /**
     * Retrieves all Pokemon stored in the database, ordered by their National Pokedex ID.
     *
     * @return a {@link List} of all {@link Pokemon} objects in the database
     */
    public static List<Pokemon> getAllPokemon() {
        List<Pokemon> list = new ArrayList<>();
        String sql = "SELECT * FROM Pokemon ORDER BY id";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(mapRowToPokemon(rs));
            }
        } catch (SQLException e) {
            System.out.println("Database error in getAllPokemon: " + e.getMessage());
        }
        return list;
    }

    /**
     * Retrieves a single Pokemon by its National Pokedex ID number.
     *
     * @param pokemonId the National Pokedex ID to look up (e.g., 1 to 386)
     * @return the matching {@link Pokemon} object, or {@code null} if no Pokemon with that ID exists
     */
    public static Pokemon getPokemonById(int pokemonId) {
        String sql = "SELECT * FROM Pokemon WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, pokemonId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRowToPokemon(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error in getPokemonById: " + e.getMessage());
        }
        return null;
    }

    /**
     * Searches for Pokemon whose names contain the specified search string (case-insensitive).
     *
     * @param nameQuery the partial or full Pokemon name to search for (e.g., "char", "Pikachu")
     * @return a {@link List} of {@link Pokemon} objects matching the name query, ordered by ID
     */
    public static List<Pokemon> searchPokemonByName(String nameQuery) {
        List<Pokemon> list = new ArrayList<>();
        String sql = "SELECT * FROM Pokemon WHERE LOWER(name) LIKE LOWER(?) ORDER BY id";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + nameQuery.trim() + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRowToPokemon(rs));
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error in searchPokemonByName: " + e.getMessage());
        }
        return list;
    }

    /**
     * Retrieves all Pokemon that have the specified elemental type as either their
     * primary type ({@code type1}) or secondary type ({@code type2}), case-insensitively.
     *
     * @param type the elemental type to filter by (e.g., "Fire", "Water", "Dragon")
     * @return a {@link List} of {@link Pokemon} objects that match the given type, ordered by ID
     */
    public static List<Pokemon> getPokemonByType(String type) {
        List<Pokemon> list = new ArrayList<>();
        String sql = "SELECT * FROM Pokemon WHERE LOWER(type1) = LOWER(?) OR LOWER(type2) = LOWER(?) ORDER BY id";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String cleanType = type.trim();
            ps.setString(1, cleanType);
            ps.setString(2, cleanType);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRowToPokemon(rs));
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error in getPokemonByType: " + e.getMessage());
        }
        return list;
    }

    /**
     * Retrieves all Pokemon introduced in a specific generation.
     *
     * @param generation the generation number to filter by (1 for Kanto, 2 for Johto, 3 for Hoenn)
     * @return a {@link List} of {@link Pokemon} objects from the specified generation, ordered by ID
     */
    public static List<Pokemon> getPokemonByGeneration(int generation) {
        List<Pokemon> list = new ArrayList<>();
        String sql = "SELECT * FROM Pokemon WHERE generation = ? ORDER BY id";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, generation);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRowToPokemon(rs));
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error in getPokemonByGeneration: " + e.getMessage());
        }
        return list;
    }

    /**
     * Retrieves all Pokemon whose Base Stat Total is greater than or equal to the specified minimum.
     * Results are ordered from highest Base Stat Total to lowest.
     *
     * @param minTotal the minimum Base Stat Total threshold (e.g., 600)
     * @return a {@link List} of {@link Pokemon} objects meeting or exceeding {@code minTotal}
     */
    public static List<Pokemon> getPokemonWithMinTotalStats(int minTotal) {
        List<Pokemon> list = new ArrayList<>();
        String sql = "SELECT * FROM Pokemon WHERE total >= ? ORDER BY total DESC, id ASC";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, minTotal);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRowToPokemon(rs));
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error in getPokemonWithMinTotalStats: " + e.getMessage());
        }
        return list;
    }

    /**
     * Retrieves all Legendary and Mythical Pokemon across Generations 1 through 3.
     *
     * @return a {@link List} of legendary {@link Pokemon} objects, ordered by ID
     */
    public static List<Pokemon> getLegendaryPokemon() {
        List<Pokemon> list = new ArrayList<>();
        String sql = "SELECT * FROM Pokemon WHERE is_legendary = 1 ORDER BY id";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(mapRowToPokemon(rs));
            }
        } catch (SQLException e) {
            System.out.println("Database error in getLegendaryPokemon: " + e.getMessage());
        }
        return list;
    }

    /**
     * Helper method that converts the current row of a {@link ResultSet} into a {@link Pokemon} object.
     *
     * @param rs the active {@link ResultSet} positioned at a valid row
     * @return a populated {@link Pokemon} instance
     * @throws SQLException if a column cannot be read from the result set
     */
    private static Pokemon mapRowToPokemon(ResultSet rs) throws SQLException {
        return new Pokemon(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("generation"),
                rs.getString("type1"),
                rs.getString("type2"),
                rs.getString("species"),
                rs.getInt("hp"),
                rs.getInt("attack"),
                rs.getInt("defense"),
                rs.getInt("sp_attack"),
                rs.getInt("sp_defense"),
                rs.getInt("speed"),
                rs.getInt("total"),
                rs.getDouble("height_m"),
                rs.getDouble("weight_kg"),
                rs.getBoolean("is_legendary")
        );
    }
}
