import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PokemonExample {
    public static void main(String[] args) throws SQLException {
        // Connect to the Pokemon database created by CreatePokemonDB
        Connection connection = DriverManager.getConnection("jdbc:sqlite:pokemon.db");
        Statement statement = connection.createStatement();

        System.out.println("=== Query 1: Legendary Pokemon across Gen 1 - 3 ===");
        String legendaryQuery = "SELECT id, name, generation, type1, type2, total " +
                                "FROM Pokemon " +
                                "WHERE is_legendary = true " +
                                "ORDER BY id";
        ResultSet rs1 = statement.executeQuery(legendaryQuery);
        while (rs1.next()) {
            int id = rs1.getInt("id");
            String name = rs1.getString("name");
            int gen = rs1.getInt("generation");
            String type1 = rs1.getString("type1");
            String type2 = rs1.getString("type2");
            String types = (type2 != null) ? type1 + "/" + type2 : type1;
            int total = rs1.getInt("total");

            System.out.printf("#%-3d %-12s (Gen %d) Type: %-15s Total Stats: %d%n", id, name, gen, types, total);
        }

        System.out.println("\n=== Query 2: Top 5 Highest Attack Pokemon in Generation 3 ===");
        String topAttackQuery = "SELECT name, attack, type1, total " +
                                "FROM Pokemon " +
                                "WHERE generation = 3 " +
                                "ORDER BY attack DESC " +
                                "LIMIT 5";
        ResultSet rs2 = statement.executeQuery(topAttackQuery);
        while (rs2.next()) {
            String name = rs2.getString("name");
            int attack = rs2.getInt("attack");
            String type1 = rs2.getString("type1");
            int total = rs2.getInt("total");

            System.out.printf("%-12s | Type: %-8s | Attack: %-3d | Total: %d%n", name, type1, attack, total);
        }

        System.out.println("\n=== Query 3: Count of Pokemon per Generation ===");
        String countQuery = "SELECT generation, COUNT(*) AS count, AVG(total) AS avg_stat " +
                            "FROM Pokemon " +
                            "GROUP BY generation " +
                            "ORDER BY generation";
        ResultSet rs3 = statement.executeQuery(countQuery);
        while (rs3.next()) {
            int gen = rs3.getInt("generation");
            int count = rs3.getInt("count");
            double avgStat = rs3.getDouble("avg_stat");

            System.out.printf("Generation %d: %d Pokemon (Average Base Stat Total: %.1f)%n", gen, count, avgStat);
        }

        connection.close();
    }
}

