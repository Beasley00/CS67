/*
 * Creates pokemon.db and populates the Pokemon table with Generation 1 through 3 data.
 * Inspired by CreateDB.java.
 * Running this program again resets the table and its contents.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatePokemonDB {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:pokemon.db";

        // try-with-resources automatically closes the connection and statement.
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            // WARNING: Deletes the existing Pokemon table and all its records.
            // This allows us to start with the same sample data each time.
            statement.executeUpdate("DROP TABLE IF EXISTS Pokemon");

            String sql = "CREATE TABLE Pokemon (" +
                    "id INTEGER PRIMARY KEY, " +           // National Pokedex number (#1 - #386)
                    "name TEXT NOT NULL, " +               // Pokemon name
                    "generation INTEGER NOT NULL, " +      // Generation (1, 2, or 3)
                    "type1 TEXT NOT NULL, " +              // Primary type
                    "type2 TEXT, " +                       // Secondary type (or NULL)
                    "species TEXT, " +                     // Category / Classification
                    "hp INTEGER NOT NULL, " +              // Base HP
                    "attack INTEGER NOT NULL, " +          // Base Attack
                    "defense INTEGER NOT NULL, " +         // Base Defense
                    "sp_attack INTEGER NOT NULL, " +       // Base Special Attack
                    "sp_defense INTEGER NOT NULL, " +      // Base Special Defense
                    "speed INTEGER NOT NULL, " +           // Base Speed
                    "total INTEGER NOT NULL, " +           // Base Stat Total
                    "height_m REAL, " +                    // Height in meters
                    "weight_kg REAL, " +                   // Weight in kilograms
                    "is_legendary BOOLEAN NOT NULL" +      // SQLite stores true/false as 1/0
                    ")";
            statement.executeUpdate(sql);

            // Wrap inserts in a transaction so all 386 records insert instantaneously
            connection.setAutoCommit(false);

            // ==========================================
            // Generation 1: Kanto (1 - 151)
            // ==========================================
            statement.executeUpdate("insert into Pokemon values(1, 'Bulbasaur', 1, 'Grass', 'Poison', 'Seed Pokemon', 45, 49, 49, 65, 65, 45, 318, 0.7, 6.9, false)");
            statement.executeUpdate("insert into Pokemon values(2, 'Ivysaur', 1, 'Grass', 'Poison', 'Seed Pokemon', 60, 62, 63, 80, 80, 60, 405, 1.0, 13.0, false)");
            statement.executeUpdate("insert into Pokemon values(3, 'Venusaur', 1, 'Grass', 'Poison', 'Seed Pokemon', 80, 82, 83, 100, 100, 80, 525, 2.0, 100.0, false)");
            statement.executeUpdate("insert into Pokemon values(4, 'Charmander', 1, 'Fire', NULL, 'Lizard Pokemon', 39, 52, 43, 60, 50, 65, 309, 0.6, 8.5, false)");
            statement.executeUpdate("insert into Pokemon values(5, 'Charmeleon', 1, 'Fire', NULL, 'Flame Pokemon', 58, 64, 58, 80, 65, 80, 405, 1.1, 19.0, false)");
            statement.executeUpdate("insert into Pokemon values(6, 'Charizard', 1, 'Fire', 'Flying', 'Flame Pokemon', 78, 84, 78, 109, 85, 100, 534, 1.7, 90.5, false)");
            statement.executeUpdate("insert into Pokemon values(7, 'Squirtle', 1, 'Water', NULL, 'Tiny Turtle Pokemon', 44, 48, 65, 50, 64, 43, 314, 0.5, 9.0, false)");
            statement.executeUpdate("insert into Pokemon values(8, 'Wartortle', 1, 'Water', NULL, 'Turtle Pokemon', 59, 63, 80, 65, 80, 58, 405, 1.0, 22.5, false)");
            statement.executeUpdate("insert into Pokemon values(9, 'Blastoise', 1, 'Water', NULL, 'Shellfish Pokemon', 79, 83, 100, 85, 105, 78, 530, 1.6, 85.5, false)");
            statement.executeUpdate("insert into Pokemon values(10, 'Caterpie', 1, 'Bug', NULL, 'Worm Pokemon', 45, 30, 35, 20, 20, 45, 195, 0.3, 2.9, false)");
            statement.executeUpdate("insert into Pokemon values(11, 'Metapod', 1, 'Bug', NULL, 'Cocoon Pokemon', 50, 20, 55, 25, 25, 30, 205, 0.7, 9.9, false)");
            statement.executeUpdate("insert into Pokemon values(12, 'Butterfree', 1, 'Bug', 'Flying', 'Butterfly Pokemon', 60, 45, 50, 90, 80, 70, 395, 1.1, 32.0, false)");
            statement.executeUpdate("insert into Pokemon values(13, 'Weedle', 1, 'Bug', 'Poison', 'Hairy Bug Pokemon', 40, 35, 30, 20, 20, 50, 195, 0.3, 3.2, false)");
            statement.executeUpdate("insert into Pokemon values(14, 'Kakuna', 1, 'Bug', 'Poison', 'Cocoon Pokemon', 45, 25, 50, 25, 25, 35, 205, 0.6, 10.0, false)");
            statement.executeUpdate("insert into Pokemon values(15, 'Beedrill', 1, 'Bug', 'Poison', 'Poison Bee Pokemon', 65, 90, 40, 45, 80, 75, 395, 1.0, 29.5, false)");
            statement.executeUpdate("insert into Pokemon values(16, 'Pidgey', 1, 'Normal', 'Flying', 'Tiny Bird Pokemon', 40, 45, 40, 35, 35, 56, 251, 0.3, 1.8, false)");
            statement.executeUpdate("insert into Pokemon values(17, 'Pidgeotto', 1, 'Normal', 'Flying', 'Bird Pokemon', 63, 60, 55, 50, 50, 71, 349, 1.1, 30.0, false)");
            statement.executeUpdate("insert into Pokemon values(18, 'Pidgeot', 1, 'Normal', 'Flying', 'Bird Pokemon', 83, 80, 75, 70, 70, 101, 479, 1.5, 39.5, false)");
            statement.executeUpdate("insert into Pokemon values(19, 'Rattata', 1, 'Normal', NULL, 'Mouse Pokemon', 30, 56, 35, 25, 35, 72, 253, 0.3, 3.5, false)");
            statement.executeUpdate("insert into Pokemon values(20, 'Raticate', 1, 'Normal', NULL, 'Mouse Pokemon', 55, 81, 60, 50, 70, 97, 413, 0.7, 18.5, false)");
            statement.executeUpdate("insert into Pokemon values(21, 'Spearow', 1, 'Normal', 'Flying', 'Tiny Bird Pokemon', 40, 60, 30, 31, 31, 70, 262, 0.3, 2.0, false)");
            statement.executeUpdate("insert into Pokemon values(22, 'Fearow', 1, 'Normal', 'Flying', 'Beak Pokemon', 65, 90, 65, 61, 61, 100, 442, 1.2, 38.0, false)");
            statement.executeUpdate("insert into Pokemon values(23, 'Ekans', 1, 'Poison', NULL, 'Snake Pokemon', 35, 60, 44, 40, 54, 55, 288, 2.0, 6.9, false)");
            statement.executeUpdate("insert into Pokemon values(24, 'Arbok', 1, 'Poison', NULL, 'Cobra Pokemon', 60, 95, 69, 65, 79, 80, 448, 3.5, 65.0, false)");
            statement.executeUpdate("insert into Pokemon values(25, 'Pikachu', 1, 'Electric', NULL, 'Mouse Pokemon', 35, 55, 40, 50, 50, 90, 320, 0.4, 6.0, false)");
            statement.executeUpdate("insert into Pokemon values(26, 'Raichu', 1, 'Electric', NULL, 'Mouse Pokemon', 60, 90, 55, 90, 80, 110, 485, 0.8, 30.0, false)");
            statement.executeUpdate("insert into Pokemon values(27, 'Sandshrew', 1, 'Ground', NULL, 'Mouse Pokemon', 50, 75, 85, 20, 30, 40, 300, 0.6, 12.0, false)");
            statement.executeUpdate("insert into Pokemon values(28, 'Sandslash', 1, 'Ground', NULL, 'Mouse Pokemon', 75, 100, 110, 45, 55, 65, 450, 1.0, 29.5, false)");
            statement.executeUpdate("insert into Pokemon values(29, 'Nidoran (Female)', 1, 'Poison', NULL, 'Poison Pin Pokemon', 55, 47, 52, 40, 40, 41, 275, 0.4, 7.0, false)");
            statement.executeUpdate("insert into Pokemon values(30, 'Nidorina', 1, 'Poison', NULL, 'Poison Pin Pokemon', 70, 62, 67, 55, 55, 56, 365, 0.8, 20.0, false)");
            statement.executeUpdate("insert into Pokemon values(31, 'Nidoqueen', 1, 'Poison', 'Ground', 'Drill Pokemon', 90, 92, 87, 75, 85, 76, 505, 1.3, 60.0, false)");
            statement.executeUpdate("insert into Pokemon values(32, 'Nidoran (Male)', 1, 'Poison', NULL, 'Poison Pin Pokemon', 46, 57, 40, 40, 40, 50, 273, 0.5, 9.0, false)");
            statement.executeUpdate("insert into Pokemon values(33, 'Nidorino', 1, 'Poison', NULL, 'Poison Pin Pokemon', 61, 72, 57, 55, 55, 65, 365, 0.9, 19.5, false)");
            statement.executeUpdate("insert into Pokemon values(34, 'Nidoking', 1, 'Poison', 'Ground', 'Drill Pokemon', 81, 102, 77, 85, 75, 85, 505, 1.4, 62.0, false)");
            statement.executeUpdate("insert into Pokemon values(35, 'Clefairy', 1, 'Fairy', NULL, 'Fairy Pokemon', 70, 45, 48, 60, 65, 35, 323, 0.6, 7.5, false)");
            statement.executeUpdate("insert into Pokemon values(36, 'Clefable', 1, 'Fairy', NULL, 'Fairy Pokemon', 95, 70, 73, 95, 90, 60, 483, 1.3, 40.0, false)");
            statement.executeUpdate("insert into Pokemon values(37, 'Vulpix', 1, 'Fire', NULL, 'Fox Pokemon', 38, 41, 40, 50, 65, 65, 299, 0.6, 9.9, false)");
            statement.executeUpdate("insert into Pokemon values(38, 'Ninetales', 1, 'Fire', NULL, 'Fox Pokemon', 73, 76, 75, 81, 100, 100, 505, 1.1, 19.9, false)");
            statement.executeUpdate("insert into Pokemon values(39, 'Jigglypuff', 1, 'Normal', 'Fairy', 'Balloon Pokemon', 115, 45, 20, 45, 25, 20, 270, 0.5, 5.5, false)");
            statement.executeUpdate("insert into Pokemon values(40, 'Wigglytuff', 1, 'Normal', 'Fairy', 'Balloon Pokemon', 140, 70, 45, 85, 50, 45, 435, 1.0, 12.0, false)");
            statement.executeUpdate("insert into Pokemon values(41, 'Zubat', 1, 'Poison', 'Flying', 'Bat Pokemon', 40, 45, 35, 30, 40, 55, 245, 0.8, 7.5, false)");
            statement.executeUpdate("insert into Pokemon values(42, 'Golbat', 1, 'Poison', 'Flying', 'Bat Pokemon', 75, 80, 70, 65, 75, 90, 455, 1.6, 55.0, false)");
            statement.executeUpdate("insert into Pokemon values(43, 'Oddish', 1, 'Grass', 'Poison', 'Weed Pokemon', 45, 50, 55, 75, 65, 30, 320, 0.5, 5.4, false)");
            statement.executeUpdate("insert into Pokemon values(44, 'Gloom', 1, 'Grass', 'Poison', 'Weed Pokemon', 60, 65, 70, 85, 75, 40, 395, 0.8, 8.6, false)");
            statement.executeUpdate("insert into Pokemon values(45, 'Vileplume', 1, 'Grass', 'Poison', 'Flower Pokemon', 75, 80, 85, 110, 90, 50, 490, 1.2, 18.6, false)");
            statement.executeUpdate("insert into Pokemon values(46, 'Paras', 1, 'Bug', 'Grass', 'Mushroom Pokemon', 35, 70, 55, 45, 55, 25, 285, 0.3, 5.4, false)");
            statement.executeUpdate("insert into Pokemon values(47, 'Parasect', 1, 'Bug', 'Grass', 'Mushroom Pokemon', 60, 95, 80, 60, 80, 30, 405, 1.0, 29.5, false)");
            statement.executeUpdate("insert into Pokemon values(48, 'Venonat', 1, 'Bug', 'Poison', 'Insect Pokemon', 60, 55, 50, 40, 55, 45, 305, 1.0, 30.0, false)");
            statement.executeUpdate("insert into Pokemon values(49, 'Venomoth', 1, 'Bug', 'Poison', 'Poison Moth Pokemon', 70, 65, 60, 90, 75, 90, 450, 1.5, 12.5, false)");
            statement.executeUpdate("insert into Pokemon values(50, 'Diglett', 1, 'Ground', NULL, 'Mole Pokemon', 10, 55, 25, 35, 45, 95, 265, 0.2, 0.8, false)");
            statement.executeUpdate("insert into Pokemon values(51, 'Dugtrio', 1, 'Ground', NULL, 'Mole Pokemon', 35, 100, 50, 50, 70, 120, 425, 0.7, 33.3, false)");
            statement.executeUpdate("insert into Pokemon values(52, 'Meowth', 1, 'Normal', NULL, 'Scratch Cat Pokemon', 40, 45, 35, 40, 40, 90, 290, 0.4, 4.2, false)");
            statement.executeUpdate("insert into Pokemon values(53, 'Persian', 1, 'Normal', NULL, 'Classy Cat Pokemon', 65, 70, 60, 65, 65, 115, 440, 1.0, 32.0, false)");
            statement.executeUpdate("insert into Pokemon values(54, 'Psyduck', 1, 'Water', NULL, 'Duck Pokemon', 50, 52, 48, 65, 50, 55, 320, 0.8, 19.6, false)");
            statement.executeUpdate("insert into Pokemon values(55, 'Golduck', 1, 'Water', NULL, 'Duck Pokemon', 80, 82, 78, 95, 80, 85, 500, 1.7, 76.6, false)");
            statement.executeUpdate("insert into Pokemon values(56, 'Mankey', 1, 'Fighting', NULL, 'Pig Monkey Pokemon', 40, 80, 35, 35, 45, 70, 305, 0.5, 28.0, false)");
            statement.executeUpdate("insert into Pokemon values(57, 'Primeape', 1, 'Fighting', NULL, 'Pig Monkey Pokemon', 65, 105, 60, 60, 70, 95, 455, 1.0, 32.0, false)");
            statement.executeUpdate("insert into Pokemon values(58, 'Growlithe', 1, 'Fire', NULL, 'Puppy Pokemon', 55, 70, 45, 70, 50, 60, 350, 0.7, 19.0, false)");
            statement.executeUpdate("insert into Pokemon values(59, 'Arcanine', 1, 'Fire', NULL, 'Legendary Pokemon', 90, 110, 80, 100, 80, 95, 555, 1.9, 155.0, false)");
            statement.executeUpdate("insert into Pokemon values(60, 'Poliwag', 1, 'Water', NULL, 'Tadpole Pokemon', 40, 50, 40, 40, 40, 90, 300, 0.6, 12.4, false)");
            statement.executeUpdate("insert into Pokemon values(61, 'Poliwhirl', 1, 'Water', NULL, 'Tadpole Pokemon', 65, 65, 65, 50, 50, 90, 385, 1.0, 20.0, false)");
            statement.executeUpdate("insert into Pokemon values(62, 'Poliwrath', 1, 'Water', 'Fighting', 'Tadpole Pokemon', 90, 95, 95, 70, 90, 70, 510, 1.3, 54.0, false)");
            statement.executeUpdate("insert into Pokemon values(63, 'Abra', 1, 'Psychic', NULL, 'Psi Pokemon', 25, 20, 15, 105, 55, 90, 310, 0.9, 19.5, false)");
            statement.executeUpdate("insert into Pokemon values(64, 'Kadabra', 1, 'Psychic', NULL, 'Psi Pokemon', 40, 35, 30, 120, 70, 105, 400, 1.3, 56.5, false)");
            statement.executeUpdate("insert into Pokemon values(65, 'Alakazam', 1, 'Psychic', NULL, 'Psi Pokemon', 55, 50, 45, 135, 95, 120, 500, 1.5, 48.0, false)");
            statement.executeUpdate("insert into Pokemon values(66, 'Machop', 1, 'Fighting', NULL, 'Superpower Pokemon', 70, 80, 50, 35, 35, 35, 305, 0.8, 19.5, false)");
            statement.executeUpdate("insert into Pokemon values(67, 'Machoke', 1, 'Fighting', NULL, 'Superpower Pokemon', 80, 100, 70, 50, 60, 45, 405, 1.5, 70.5, false)");
            statement.executeUpdate("insert into Pokemon values(68, 'Machamp', 1, 'Fighting', NULL, 'Superpower Pokemon', 90, 130, 80, 65, 85, 55, 505, 1.6, 130.0, false)");
            statement.executeUpdate("insert into Pokemon values(69, 'Bellsprout', 1, 'Grass', 'Poison', 'Flower Pokemon', 50, 75, 35, 70, 30, 40, 300, 0.7, 4.0, false)");
            statement.executeUpdate("insert into Pokemon values(70, 'Weepinbell', 1, 'Grass', 'Poison', 'Flycatcher Pokemon', 65, 90, 50, 85, 45, 55, 390, 1.0, 6.4, false)");
            statement.executeUpdate("insert into Pokemon values(71, 'Victreebel', 1, 'Grass', 'Poison', 'Flycatcher Pokemon', 80, 105, 65, 100, 70, 70, 490, 1.7, 15.5, false)");
            statement.executeUpdate("insert into Pokemon values(72, 'Tentacool', 1, 'Water', 'Poison', 'Jellyfish Pokemon', 40, 40, 35, 50, 100, 70, 335, 0.9, 45.5, false)");
            statement.executeUpdate("insert into Pokemon values(73, 'Tentacruel', 1, 'Water', 'Poison', 'Jellyfish Pokemon', 80, 70, 65, 80, 120, 100, 515, 1.6, 55.0, false)");
            statement.executeUpdate("insert into Pokemon values(74, 'Geodude', 1, 'Rock', 'Ground', 'Rock Pokemon', 40, 80, 100, 30, 30, 20, 300, 0.4, 20.0, false)");
            statement.executeUpdate("insert into Pokemon values(75, 'Graveler', 1, 'Rock', 'Ground', 'Rock Pokemon', 55, 95, 115, 45, 45, 35, 390, 1.0, 105.0, false)");
            statement.executeUpdate("insert into Pokemon values(76, 'Golem', 1, 'Rock', 'Ground', 'Megaton Pokemon', 80, 120, 130, 55, 65, 45, 495, 1.4, 300.0, false)");
            statement.executeUpdate("insert into Pokemon values(77, 'Ponyta', 1, 'Fire', NULL, 'Fire Horse Pokemon', 50, 85, 55, 65, 65, 90, 410, 1.0, 30.0, false)");
            statement.executeUpdate("insert into Pokemon values(78, 'Rapidash', 1, 'Fire', NULL, 'Fire Horse Pokemon', 65, 100, 70, 80, 80, 105, 500, 1.7, 95.0, false)");
            statement.executeUpdate("insert into Pokemon values(79, 'Slowpoke', 1, 'Water', 'Psychic', 'Dopey Pokemon', 90, 65, 65, 40, 40, 15, 315, 1.2, 36.0, false)");
            statement.executeUpdate("insert into Pokemon values(80, 'Slowbro', 1, 'Water', 'Psychic', 'Hermit Crab Pokemon', 95, 75, 110, 100, 80, 30, 490, 1.6, 78.5, false)");
            statement.executeUpdate("insert into Pokemon values(81, 'Magnemite', 1, 'Electric', 'Steel', 'Magnet Pokemon', 25, 35, 70, 95, 55, 45, 325, 0.3, 6.0, false)");
            statement.executeUpdate("insert into Pokemon values(82, 'Magneton', 1, 'Electric', 'Steel', 'Magnet Pokemon', 50, 60, 95, 120, 70, 70, 465, 1.0, 60.0, false)");
            statement.executeUpdate("insert into Pokemon values(83, 'Farfetch''d', 1, 'Normal', 'Flying', 'Wild Duck Pokemon', 52, 90, 55, 58, 62, 60, 377, 0.8, 15.0, false)");
            statement.executeUpdate("insert into Pokemon values(84, 'Doduo', 1, 'Normal', 'Flying', 'Twin Bird Pokemon', 35, 85, 45, 35, 35, 75, 310, 1.4, 39.2, false)");
            statement.executeUpdate("insert into Pokemon values(85, 'Dodrio', 1, 'Normal', 'Flying', 'Triple Bird Pokemon', 60, 110, 70, 60, 60, 110, 470, 1.8, 85.2, false)");
            statement.executeUpdate("insert into Pokemon values(86, 'Seel', 1, 'Water', NULL, 'Sea Lion Pokemon', 65, 45, 55, 45, 70, 45, 325, 1.1, 90.0, false)");
            statement.executeUpdate("insert into Pokemon values(87, 'Dewgong', 1, 'Water', 'Ice', 'Sea Lion Pokemon', 90, 70, 80, 70, 95, 70, 475, 1.7, 120.0, false)");
            statement.executeUpdate("insert into Pokemon values(88, 'Grimer', 1, 'Poison', NULL, 'Sludge Pokemon', 80, 80, 50, 40, 50, 25, 325, 0.9, 30.0, false)");
            statement.executeUpdate("insert into Pokemon values(89, 'Muk', 1, 'Poison', NULL, 'Sludge Pokemon', 105, 105, 75, 65, 100, 50, 500, 1.2, 30.0, false)");
            statement.executeUpdate("insert into Pokemon values(90, 'Shellder', 1, 'Water', NULL, 'Bivalve Pokemon', 30, 65, 100, 45, 25, 40, 305, 0.3, 4.0, false)");
            statement.executeUpdate("insert into Pokemon values(91, 'Cloyster', 1, 'Water', 'Ice', 'Bivalve Pokemon', 50, 95, 180, 85, 45, 70, 525, 1.5, 132.5, false)");
            statement.executeUpdate("insert into Pokemon values(92, 'Gastly', 1, 'Ghost', 'Poison', 'Gas Pokemon', 30, 35, 30, 100, 35, 80, 310, 1.3, 0.1, false)");
            statement.executeUpdate("insert into Pokemon values(93, 'Haunter', 1, 'Ghost', 'Poison', 'Gas Pokemon', 45, 50, 45, 115, 55, 95, 405, 1.6, 0.1, false)");
            statement.executeUpdate("insert into Pokemon values(94, 'Gengar', 1, 'Ghost', 'Poison', 'Shadow Pokemon', 60, 65, 60, 130, 75, 110, 500, 1.5, 40.5, false)");
            statement.executeUpdate("insert into Pokemon values(95, 'Onix', 1, 'Rock', 'Ground', 'Rock Snake Pokemon', 35, 45, 160, 30, 45, 70, 385, 8.8, 210.0, false)");
            statement.executeUpdate("insert into Pokemon values(96, 'Drowzee', 1, 'Psychic', NULL, 'Hypnosis Pokemon', 60, 48, 45, 43, 90, 42, 328, 1.0, 32.4, false)");
            statement.executeUpdate("insert into Pokemon values(97, 'Hypno', 1, 'Psychic', NULL, 'Hypnosis Pokemon', 85, 73, 70, 73, 115, 67, 483, 1.6, 75.6, false)");
            statement.executeUpdate("insert into Pokemon values(98, 'Krabby', 1, 'Water', NULL, 'River Crab Pokemon', 30, 105, 90, 25, 25, 50, 325, 0.4, 6.5, false)");
            statement.executeUpdate("insert into Pokemon values(99, 'Kingler', 1, 'Water', NULL, 'Pincer Pokemon', 55, 130, 115, 50, 50, 75, 475, 1.3, 60.0, false)");
            statement.executeUpdate("insert into Pokemon values(100, 'Voltorb', 1, 'Electric', NULL, 'Ball Pokemon', 40, 30, 50, 55, 55, 100, 330, 0.5, 10.4, false)");
            statement.executeUpdate("insert into Pokemon values(101, 'Electrode', 1, 'Electric', NULL, 'Ball Pokemon', 60, 50, 70, 80, 80, 150, 490, 1.2, 66.6, false)");
            statement.executeUpdate("insert into Pokemon values(102, 'Exeggcute', 1, 'Grass', 'Psychic', 'Egg Pokemon', 60, 40, 80, 60, 45, 40, 325, 0.4, 2.5, false)");
            statement.executeUpdate("insert into Pokemon values(103, 'Exeggutor', 1, 'Grass', 'Psychic', 'Coconut Pokemon', 95, 95, 85, 125, 75, 55, 530, 2.0, 120.0, false)");
            statement.executeUpdate("insert into Pokemon values(104, 'Cubone', 1, 'Ground', NULL, 'Lonely Pokemon', 50, 50, 95, 40, 50, 35, 320, 0.4, 6.5, false)");
            statement.executeUpdate("insert into Pokemon values(105, 'Marowak', 1, 'Ground', NULL, 'Bone Keeper Pokemon', 60, 80, 110, 50, 80, 45, 425, 1.0, 45.0, false)");
            statement.executeUpdate("insert into Pokemon values(106, 'Hitmonlee', 1, 'Fighting', NULL, 'Kicking Pokemon', 50, 120, 53, 35, 110, 87, 455, 1.5, 49.8, false)");
            statement.executeUpdate("insert into Pokemon values(107, 'Hitmonchan', 1, 'Fighting', NULL, 'Punching Pokemon', 50, 105, 79, 35, 110, 76, 455, 1.4, 50.2, false)");
            statement.executeUpdate("insert into Pokemon values(108, 'Lickitung', 1, 'Normal', NULL, 'Licking Pokemon', 90, 55, 75, 60, 75, 30, 385, 1.2, 65.5, false)");
            statement.executeUpdate("insert into Pokemon values(109, 'Koffing', 1, 'Poison', NULL, 'Poison Gas Pokemon', 40, 65, 95, 60, 45, 35, 340, 0.6, 1.0, false)");
            statement.executeUpdate("insert into Pokemon values(110, 'Weezing', 1, 'Poison', NULL, 'Poison Gas Pokemon', 65, 90, 120, 85, 70, 60, 490, 1.2, 9.5, false)");
            statement.executeUpdate("insert into Pokemon values(111, 'Rhyhorn', 1, 'Ground', 'Rock', 'Spikes Pokemon', 80, 85, 95, 30, 30, 25, 345, 1.0, 115.0, false)");
            statement.executeUpdate("insert into Pokemon values(112, 'Rhydon', 1, 'Ground', 'Rock', 'Drill Pokemon', 105, 130, 120, 45, 45, 40, 485, 1.9, 120.0, false)");
            statement.executeUpdate("insert into Pokemon values(113, 'Chansey', 1, 'Normal', NULL, 'Egg Pokemon', 250, 5, 5, 35, 105, 50, 450, 1.1, 34.6, false)");
            statement.executeUpdate("insert into Pokemon values(114, 'Tangela', 1, 'Grass', NULL, 'Vine Pokemon', 65, 55, 115, 100, 40, 60, 435, 1.0, 35.0, false)");
            statement.executeUpdate("insert into Pokemon values(115, 'Kangaskhan', 1, 'Normal', NULL, 'Parent Pokemon', 105, 95, 80, 40, 80, 90, 490, 2.2, 80.0, false)");
            statement.executeUpdate("insert into Pokemon values(116, 'Horsea', 1, 'Water', NULL, 'Dragon Pokemon', 30, 40, 70, 70, 25, 60, 295, 0.4, 8.0, false)");
            statement.executeUpdate("insert into Pokemon values(117, 'Seadra', 1, 'Water', NULL, 'Dragon Pokemon', 55, 65, 95, 95, 45, 85, 440, 1.2, 25.0, false)");
            statement.executeUpdate("insert into Pokemon values(118, 'Goldeen', 1, 'Water', NULL, 'Goldfish Pokemon', 45, 67, 60, 35, 50, 63, 320, 0.6, 15.0, false)");
            statement.executeUpdate("insert into Pokemon values(119, 'Seaking', 1, 'Water', NULL, 'Goldfish Pokemon', 80, 92, 65, 65, 80, 68, 450, 1.3, 39.0, false)");
            statement.executeUpdate("insert into Pokemon values(120, 'Staryu', 1, 'Water', NULL, 'Star Shape Pokemon', 30, 45, 55, 70, 55, 85, 340, 0.8, 34.5, false)");
            statement.executeUpdate("insert into Pokemon values(121, 'Starmie', 1, 'Water', 'Psychic', 'Mysterious Pokemon', 60, 75, 85, 100, 85, 115, 520, 1.1, 80.0, false)");
            statement.executeUpdate("insert into Pokemon values(122, 'Mr. Mime', 1, 'Psychic', 'Fairy', 'Barrier Pokemon', 40, 45, 65, 100, 120, 90, 460, 1.3, 54.5, false)");
            statement.executeUpdate("insert into Pokemon values(123, 'Scyther', 1, 'Bug', 'Flying', 'Mantis Pokemon', 70, 110, 80, 55, 80, 105, 500, 1.5, 56.0, false)");
            statement.executeUpdate("insert into Pokemon values(124, 'Jynx', 1, 'Ice', 'Psychic', 'Human Shape Pokemon', 65, 50, 35, 115, 95, 95, 455, 1.4, 40.6, false)");
            statement.executeUpdate("insert into Pokemon values(125, 'Electabuzz', 1, 'Electric', NULL, 'Electric Pokemon', 65, 83, 57, 95, 85, 105, 490, 1.1, 30.0, false)");
            statement.executeUpdate("insert into Pokemon values(126, 'Magmar', 1, 'Fire', NULL, 'Spitfire Pokemon', 65, 95, 57, 100, 85, 93, 495, 1.3, 44.5, false)");
            statement.executeUpdate("insert into Pokemon values(127, 'Pinsir', 1, 'Bug', NULL, 'Stag Beetle Pokemon', 65, 125, 100, 55, 70, 85, 500, 1.5, 55.0, false)");
            statement.executeUpdate("insert into Pokemon values(128, 'Tauros', 1, 'Normal', NULL, 'Wild Bull Pokemon', 75, 100, 95, 40, 70, 110, 490, 1.4, 88.4, false)");
            statement.executeUpdate("insert into Pokemon values(129, 'Magikarp', 1, 'Water', NULL, 'Fish Pokemon', 20, 10, 55, 15, 20, 80, 200, 0.9, 10.0, false)");
            statement.executeUpdate("insert into Pokemon values(130, 'Gyarados', 1, 'Water', 'Flying', 'Atrocious Pokemon', 95, 125, 79, 60, 100, 81, 540, 6.5, 235.0, false)");
            statement.executeUpdate("insert into Pokemon values(131, 'Lapras', 1, 'Water', 'Ice', 'Transport Pokemon', 130, 85, 80, 85, 95, 60, 535, 2.5, 220.0, false)");
            statement.executeUpdate("insert into Pokemon values(132, 'Ditto', 1, 'Normal', NULL, 'Transform Pokemon', 48, 48, 48, 48, 48, 48, 288, 0.3, 4.0, false)");
            statement.executeUpdate("insert into Pokemon values(133, 'Eevee', 1, 'Normal', NULL, 'Evolution Pokemon', 55, 55, 50, 45, 65, 55, 325, 0.3, 6.5, false)");
            statement.executeUpdate("insert into Pokemon values(134, 'Vaporeon', 1, 'Water', NULL, 'Bubble Jet Pokemon', 130, 65, 60, 110, 95, 65, 525, 1.0, 29.0, false)");
            statement.executeUpdate("insert into Pokemon values(135, 'Jolteon', 1, 'Electric', NULL, 'Lightning Pokemon', 65, 65, 60, 110, 95, 130, 525, 0.8, 24.5, false)");
            statement.executeUpdate("insert into Pokemon values(136, 'Flareon', 1, 'Fire', NULL, 'Flame Pokemon', 65, 130, 60, 95, 110, 65, 525, 0.9, 25.0, false)");
            statement.executeUpdate("insert into Pokemon values(137, 'Porygon', 1, 'Normal', NULL, 'Virtual Pokemon', 65, 60, 70, 85, 75, 40, 395, 0.8, 36.5, false)");
            statement.executeUpdate("insert into Pokemon values(138, 'Omanyte', 1, 'Rock', 'Water', 'Spiral Pokemon', 35, 40, 100, 90, 55, 35, 355, 0.4, 7.5, false)");
            statement.executeUpdate("insert into Pokemon values(139, 'Omastar', 1, 'Rock', 'Water', 'Spiral Pokemon', 70, 60, 125, 115, 70, 55, 495, 1.0, 35.0, false)");
            statement.executeUpdate("insert into Pokemon values(140, 'Kabuto', 1, 'Rock', 'Water', 'Shellfish Pokemon', 30, 80, 90, 55, 45, 55, 355, 0.5, 11.5, false)");
            statement.executeUpdate("insert into Pokemon values(141, 'Kabutops', 1, 'Rock', 'Water', 'Shellfish Pokemon', 60, 115, 105, 65, 70, 80, 495, 1.3, 40.5, false)");
            statement.executeUpdate("insert into Pokemon values(142, 'Aerodactyl', 1, 'Rock', 'Flying', 'Fossil Pokemon', 80, 105, 65, 60, 75, 130, 515, 1.8, 59.0, false)");
            statement.executeUpdate("insert into Pokemon values(143, 'Snorlax', 1, 'Normal', NULL, 'Sleeping Pokemon', 160, 110, 65, 65, 110, 30, 540, 2.1, 460.0, false)");
            statement.executeUpdate("insert into Pokemon values(144, 'Articuno', 1, 'Ice', 'Flying', 'Freeze Pokemon', 90, 85, 100, 95, 125, 85, 580, 1.7, 55.4, true)");
            statement.executeUpdate("insert into Pokemon values(145, 'Zapdos', 1, 'Electric', 'Flying', 'Electric Pokemon', 90, 90, 85, 125, 90, 100, 580, 1.6, 52.6, true)");
            statement.executeUpdate("insert into Pokemon values(146, 'Moltres', 1, 'Fire', 'Flying', 'Flame Pokemon', 90, 100, 90, 125, 85, 90, 580, 2.0, 60.0, true)");
            statement.executeUpdate("insert into Pokemon values(147, 'Dratini', 1, 'Dragon', NULL, 'Dragon Pokemon', 41, 64, 45, 50, 50, 50, 300, 1.8, 3.3, false)");
            statement.executeUpdate("insert into Pokemon values(148, 'Dragonair', 1, 'Dragon', NULL, 'Dragon Pokemon', 61, 84, 65, 70, 70, 70, 420, 4.0, 16.5, false)");
            statement.executeUpdate("insert into Pokemon values(149, 'Dragonite', 1, 'Dragon', 'Flying', 'Dragon Pokemon', 91, 134, 95, 100, 100, 80, 600, 2.2, 210.0, false)");
            statement.executeUpdate("insert into Pokemon values(150, 'Mewtwo', 1, 'Psychic', NULL, 'Genetic Pokemon', 106, 110, 90, 154, 90, 130, 680, 2.0, 122.0, true)");
            statement.executeUpdate("insert into Pokemon values(151, 'Mew', 1, 'Psychic', NULL, 'New Species Pokemon', 100, 100, 100, 100, 100, 100, 600, 0.4, 4.0, true)");

            // ==========================================
            // Generation 2: Johto (152 - 251)
            // ==========================================
            statement.executeUpdate("insert into Pokemon values(152, 'Chikorita', 2, 'Grass', NULL, 'Leaf Pokemon', 45, 49, 65, 49, 65, 45, 318, 0.9, 6.4, false)");
            statement.executeUpdate("insert into Pokemon values(153, 'Bayleef', 2, 'Grass', NULL, 'Leaf Pokemon', 60, 62, 80, 63, 80, 60, 405, 1.2, 15.8, false)");
            statement.executeUpdate("insert into Pokemon values(154, 'Meganium', 2, 'Grass', NULL, 'Herb Pokemon', 80, 82, 100, 83, 100, 80, 525, 1.8, 100.5, false)");
            statement.executeUpdate("insert into Pokemon values(155, 'Cyndaquil', 2, 'Fire', NULL, 'Fire Mouse Pokemon', 39, 52, 43, 60, 50, 65, 309, 0.5, 7.9, false)");
            statement.executeUpdate("insert into Pokemon values(156, 'Quilava', 2, 'Fire', NULL, 'Volcano Pokemon', 58, 64, 58, 80, 65, 80, 405, 0.9, 19.0, false)");
            statement.executeUpdate("insert into Pokemon values(157, 'Typhlosion', 2, 'Fire', NULL, 'Volcano Pokemon', 78, 84, 78, 109, 85, 100, 534, 1.7, 79.5, false)");
            statement.executeUpdate("insert into Pokemon values(158, 'Totodile', 2, 'Water', NULL, 'Big Jaw Pokemon', 50, 65, 64, 44, 48, 43, 314, 0.6, 9.5, false)");
            statement.executeUpdate("insert into Pokemon values(159, 'Croconaw', 2, 'Water', NULL, 'Big Jaw Pokemon', 65, 80, 80, 59, 63, 58, 405, 1.1, 25.0, false)");
            statement.executeUpdate("insert into Pokemon values(160, 'Feraligatr', 2, 'Water', NULL, 'Big Jaw Pokemon', 85, 105, 100, 79, 83, 78, 530, 2.3, 88.8, false)");
            statement.executeUpdate("insert into Pokemon values(161, 'Sentret', 2, 'Normal', NULL, 'Scout Pokemon', 35, 46, 34, 35, 45, 20, 215, 0.8, 6.0, false)");
            statement.executeUpdate("insert into Pokemon values(162, 'Furret', 2, 'Normal', NULL, 'Long Body Pokemon', 85, 76, 64, 45, 55, 90, 415, 1.8, 32.5, false)");
            statement.executeUpdate("insert into Pokemon values(163, 'Hoothoot', 2, 'Normal', 'Flying', 'Owl Pokemon', 60, 30, 30, 36, 56, 50, 262, 0.7, 21.2, false)");
            statement.executeUpdate("insert into Pokemon values(164, 'Noctowl', 2, 'Normal', 'Flying', 'Owl Pokemon', 100, 50, 50, 86, 96, 70, 452, 1.6, 40.8, false)");
            statement.executeUpdate("insert into Pokemon values(165, 'Ledyba', 2, 'Bug', 'Flying', 'Five Star Pokemon', 40, 20, 30, 40, 80, 55, 265, 1.0, 10.8, false)");
            statement.executeUpdate("insert into Pokemon values(166, 'Ledian', 2, 'Bug', 'Flying', 'Five Star Pokemon', 55, 35, 50, 55, 110, 85, 390, 1.4, 35.6, false)");
            statement.executeUpdate("insert into Pokemon values(167, 'Spinarak', 2, 'Bug', 'Poison', 'String Spit Pokemon', 40, 60, 40, 40, 40, 30, 250, 0.5, 8.5, false)");
            statement.executeUpdate("insert into Pokemon values(168, 'Ariados', 2, 'Bug', 'Poison', 'Long Leg Pokemon', 70, 90, 70, 60, 70, 40, 400, 1.1, 33.5, false)");
            statement.executeUpdate("insert into Pokemon values(169, 'Crobat', 2, 'Poison', 'Flying', 'Bat Pokemon', 85, 90, 80, 70, 80, 130, 535, 1.8, 75.0, false)");
            statement.executeUpdate("insert into Pokemon values(170, 'Chinchou', 2, 'Water', 'Electric', 'Angler Pokemon', 75, 38, 38, 56, 56, 67, 330, 0.5, 12.0, false)");
            statement.executeUpdate("insert into Pokemon values(171, 'Lanturn', 2, 'Water', 'Electric', 'Light Pokemon', 125, 58, 58, 76, 76, 67, 460, 1.2, 22.5, false)");
            statement.executeUpdate("insert into Pokemon values(172, 'Pichu', 2, 'Electric', NULL, 'Tiny Mouse Pokemon', 20, 40, 15, 35, 35, 60, 205, 0.3, 2.0, false)");
            statement.executeUpdate("insert into Pokemon values(173, 'Cleffa', 2, 'Fairy', NULL, 'Star Shape Pokemon', 50, 25, 28, 45, 55, 15, 218, 0.3, 3.0, false)");
            statement.executeUpdate("insert into Pokemon values(174, 'Igglybuff', 2, 'Normal', 'Fairy', 'Balloon Pokemon', 90, 30, 15, 40, 20, 15, 210, 0.3, 1.0, false)");
            statement.executeUpdate("insert into Pokemon values(175, 'Togepi', 2, 'Fairy', NULL, 'Spike Ball Pokemon', 35, 20, 65, 40, 65, 20, 245, 0.3, 1.5, false)");
            statement.executeUpdate("insert into Pokemon values(176, 'Togetic', 2, 'Fairy', 'Flying', 'Happiness Pokemon', 55, 40, 85, 80, 105, 40, 405, 0.6, 3.2, false)");
            statement.executeUpdate("insert into Pokemon values(177, 'Natu', 2, 'Psychic', 'Flying', 'Tiny Bird Pokemon', 40, 50, 45, 70, 45, 70, 320, 0.2, 2.0, false)");
            statement.executeUpdate("insert into Pokemon values(178, 'Xatu', 2, 'Psychic', 'Flying', 'Mystic Pokemon', 65, 75, 70, 95, 70, 95, 470, 1.5, 15.0, false)");
            statement.executeUpdate("insert into Pokemon values(179, 'Mareep', 2, 'Electric', NULL, 'Wool Pokemon', 55, 40, 40, 65, 45, 35, 280, 0.6, 7.8, false)");
            statement.executeUpdate("insert into Pokemon values(180, 'Flaaffy', 2, 'Electric', NULL, 'Wool Pokemon', 70, 55, 55, 80, 60, 45, 365, 0.8, 13.3, false)");
            statement.executeUpdate("insert into Pokemon values(181, 'Ampharos', 2, 'Electric', NULL, 'Light Pokemon', 90, 75, 85, 115, 90, 55, 510, 1.4, 61.5, false)");
            statement.executeUpdate("insert into Pokemon values(182, 'Bellossom', 2, 'Grass', NULL, 'Flower Pokemon', 75, 80, 95, 90, 100, 50, 490, 0.4, 5.8, false)");
            statement.executeUpdate("insert into Pokemon values(183, 'Marill', 2, 'Water', 'Fairy', 'Aqua Mouse Pokemon', 70, 20, 50, 20, 50, 40, 250, 0.4, 8.5, false)");
            statement.executeUpdate("insert into Pokemon values(184, 'Azumarill', 2, 'Water', 'Fairy', 'Aqua Rabbit Pokemon', 100, 50, 80, 60, 80, 50, 420, 0.8, 28.5, false)");
            statement.executeUpdate("insert into Pokemon values(185, 'Sudowoodo', 2, 'Rock', NULL, 'Imitation Pokemon', 70, 100, 115, 30, 65, 30, 410, 1.2, 38.0, false)");
            statement.executeUpdate("insert into Pokemon values(186, 'Politoed', 2, 'Water', NULL, 'Frog Pokemon', 90, 75, 75, 90, 100, 70, 500, 1.1, 33.9, false)");
            statement.executeUpdate("insert into Pokemon values(187, 'Hoppip', 2, 'Grass', 'Flying', 'Cottonweed Pokemon', 35, 35, 40, 35, 55, 50, 250, 0.4, 0.5, false)");
            statement.executeUpdate("insert into Pokemon values(188, 'Skiploom', 2, 'Grass', 'Flying', 'Cottonweed Pokemon', 55, 45, 50, 45, 65, 80, 340, 0.6, 1.0, false)");
            statement.executeUpdate("insert into Pokemon values(189, 'Jumpluff', 2, 'Grass', 'Flying', 'Cottonweed Pokemon', 75, 55, 70, 55, 95, 110, 460, 0.8, 3.0, false)");
            statement.executeUpdate("insert into Pokemon values(190, 'Aipom', 2, 'Normal', NULL, 'Long Tail Pokemon', 55, 70, 55, 40, 55, 85, 360, 0.8, 11.5, false)");
            statement.executeUpdate("insert into Pokemon values(191, 'Sunkern', 2, 'Grass', NULL, 'Seed Pokemon', 30, 30, 30, 30, 30, 30, 180, 0.3, 1.8, false)");
            statement.executeUpdate("insert into Pokemon values(192, 'Sunflora', 2, 'Grass', NULL, 'Sun Pokemon', 75, 75, 55, 105, 85, 30, 425, 0.8, 8.5, false)");
            statement.executeUpdate("insert into Pokemon values(193, 'Yanma', 2, 'Bug', 'Flying', 'Clear Wing Pokemon', 65, 65, 45, 75, 45, 95, 390, 1.2, 38.0, false)");
            statement.executeUpdate("insert into Pokemon values(194, 'Wooper', 2, 'Water', 'Ground', 'Water Fish Pokemon', 55, 45, 45, 25, 25, 15, 210, 0.4, 8.5, false)");
            statement.executeUpdate("insert into Pokemon values(195, 'Quagsire', 2, 'Water', 'Ground', 'Water Fish Pokemon', 95, 85, 85, 65, 65, 35, 430, 1.4, 75.0, false)");
            statement.executeUpdate("insert into Pokemon values(196, 'Espeon', 2, 'Psychic', NULL, 'Sun Pokemon', 65, 65, 60, 130, 95, 110, 525, 0.9, 26.5, false)");
            statement.executeUpdate("insert into Pokemon values(197, 'Umbreon', 2, 'Dark', NULL, 'Moonlight Pokemon', 95, 65, 110, 60, 130, 65, 525, 1.0, 27.0, false)");
            statement.executeUpdate("insert into Pokemon values(198, 'Murkrow', 2, 'Dark', 'Flying', 'Darkness Pokemon', 60, 85, 42, 85, 42, 91, 405, 0.5, 2.1, false)");
            statement.executeUpdate("insert into Pokemon values(199, 'Slowking', 2, 'Water', 'Psychic', 'Royal Pokemon', 95, 75, 80, 100, 110, 30, 490, 2.0, 79.5, false)");
            statement.executeUpdate("insert into Pokemon values(200, 'Misdreavus', 2, 'Ghost', NULL, 'Screech Pokemon', 60, 60, 60, 85, 85, 85, 435, 0.7, 1.0, false)");
            statement.executeUpdate("insert into Pokemon values(201, 'Unown', 2, 'Psychic', NULL, 'Symbol Pokemon', 48, 72, 48, 72, 48, 48, 336, 0.5, 5.0, false)");
            statement.executeUpdate("insert into Pokemon values(202, 'Wobbuffet', 2, 'Psychic', NULL, 'Patient Pokemon', 190, 33, 58, 33, 58, 33, 405, 1.3, 28.5, false)");
            statement.executeUpdate("insert into Pokemon values(203, 'Girafarig', 2, 'Normal', 'Psychic', 'Long Neck Pokemon', 70, 80, 65, 90, 65, 85, 455, 1.5, 41.5, false)");
            statement.executeUpdate("insert into Pokemon values(204, 'Pineco', 2, 'Bug', NULL, 'Bagworm Pokemon', 50, 65, 90, 35, 35, 15, 290, 0.6, 7.2, false)");
            statement.executeUpdate("insert into Pokemon values(205, 'Forretress', 2, 'Bug', 'Steel', 'Bagworm Pokemon', 75, 90, 140, 60, 60, 40, 465, 1.2, 125.8, false)");
            statement.executeUpdate("insert into Pokemon values(206, 'Dunsparce', 2, 'Normal', NULL, 'Land Snake Pokemon', 100, 70, 70, 65, 65, 45, 415, 1.5, 14.0, false)");
            statement.executeUpdate("insert into Pokemon values(207, 'Gligar', 2, 'Ground', 'Flying', 'Fly Scorpion Pokemon', 65, 75, 105, 35, 65, 85, 430, 1.1, 64.8, false)");
            statement.executeUpdate("insert into Pokemon values(208, 'Steelix', 2, 'Steel', 'Ground', 'Iron Snake Pokemon', 75, 85, 200, 55, 65, 30, 510, 9.2, 400.0, false)");
            statement.executeUpdate("insert into Pokemon values(209, 'Snubbull', 2, 'Fairy', NULL, 'Fairy Pokemon', 60, 80, 50, 40, 40, 30, 300, 0.6, 7.8, false)");
            statement.executeUpdate("insert into Pokemon values(210, 'Granbull', 2, 'Fairy', NULL, 'Fairy Pokemon', 90, 120, 75, 60, 60, 45, 450, 1.4, 48.7, false)");
            statement.executeUpdate("insert into Pokemon values(211, 'Qwilfish', 2, 'Water', 'Poison', 'Balloon Pokemon', 65, 95, 85, 55, 55, 85, 440, 0.5, 3.9, false)");
            statement.executeUpdate("insert into Pokemon values(212, 'Scizor', 2, 'Bug', 'Steel', 'Pincer Pokemon', 70, 130, 100, 55, 80, 65, 500, 1.8, 118.0, false)");
            statement.executeUpdate("insert into Pokemon values(213, 'Shuckle', 2, 'Bug', 'Rock', 'Mold Pokemon', 20, 10, 230, 10, 230, 5, 505, 0.6, 20.5, false)");
            statement.executeUpdate("insert into Pokemon values(214, 'Heracross', 2, 'Bug', 'Fighting', 'Single Horn Pokemon', 80, 125, 75, 40, 95, 85, 500, 1.5, 54.0, false)");
            statement.executeUpdate("insert into Pokemon values(215, 'Sneasel', 2, 'Dark', 'Ice', 'Sharp Claw Pokemon', 55, 95, 55, 35, 75, 115, 430, 0.9, 28.0, false)");
            statement.executeUpdate("insert into Pokemon values(216, 'Teddiursa', 2, 'Normal', NULL, 'Little Bear Pokemon', 60, 80, 50, 50, 50, 40, 330, 0.6, 8.8, false)");
            statement.executeUpdate("insert into Pokemon values(217, 'Ursaring', 2, 'Normal', NULL, 'Hibernator Pokemon', 90, 130, 75, 75, 75, 55, 500, 1.8, 125.8, false)");
            statement.executeUpdate("insert into Pokemon values(218, 'Slugma', 2, 'Fire', NULL, 'Lava Pokemon', 40, 40, 40, 70, 40, 20, 250, 0.7, 35.0, false)");
            statement.executeUpdate("insert into Pokemon values(219, 'Magcargo', 2, 'Fire', 'Rock', 'Lava Pokemon', 60, 50, 120, 90, 80, 30, 430, 0.8, 55.0, false)");
            statement.executeUpdate("insert into Pokemon values(220, 'Swinub', 2, 'Ice', 'Ground', 'Pig Pokemon', 50, 50, 40, 30, 30, 50, 250, 0.4, 6.5, false)");
            statement.executeUpdate("insert into Pokemon values(221, 'Piloswine', 2, 'Ice', 'Ground', 'Swine Pokemon', 100, 100, 80, 60, 60, 50, 450, 1.1, 55.8, false)");
            statement.executeUpdate("insert into Pokemon values(222, 'Corsola', 2, 'Water', 'Rock', 'Coral Pokemon', 65, 55, 95, 65, 95, 35, 410, 0.6, 5.0, false)");
            statement.executeUpdate("insert into Pokemon values(223, 'Remoraid', 2, 'Water', NULL, 'Jet Pokemon', 35, 65, 35, 65, 35, 65, 300, 0.6, 12.0, false)");
            statement.executeUpdate("insert into Pokemon values(224, 'Octillery', 2, 'Water', NULL, 'Jet Pokemon', 75, 105, 75, 105, 75, 45, 480, 0.9, 28.5, false)");
            statement.executeUpdate("insert into Pokemon values(225, 'Delibird', 2, 'Ice', 'Flying', 'Delivery Pokemon', 45, 55, 45, 65, 45, 75, 330, 0.9, 16.0, false)");
            statement.executeUpdate("insert into Pokemon values(226, 'Mantine', 2, 'Water', 'Flying', 'Kite Pokemon', 85, 40, 70, 80, 140, 70, 485, 2.1, 220.0, false)");
            statement.executeUpdate("insert into Pokemon values(227, 'Skarmory', 2, 'Steel', 'Flying', 'Armor Bird Pokemon', 65, 80, 140, 40, 70, 70, 465, 1.7, 50.5, false)");
            statement.executeUpdate("insert into Pokemon values(228, 'Houndour', 2, 'Dark', 'Fire', 'Dark Pokemon', 45, 60, 30, 80, 50, 65, 330, 0.6, 10.8, false)");
            statement.executeUpdate("insert into Pokemon values(229, 'Houndoom', 2, 'Dark', 'Fire', 'Dark Pokemon', 75, 90, 50, 110, 80, 95, 500, 1.4, 35.0, false)");
            statement.executeUpdate("insert into Pokemon values(230, 'Kingdra', 2, 'Water', 'Dragon', 'Dragon Pokemon', 75, 95, 95, 95, 95, 85, 540, 1.8, 152.0, false)");
            statement.executeUpdate("insert into Pokemon values(231, 'Phanpy', 2, 'Ground', NULL, 'Long Nose Pokemon', 90, 60, 60, 40, 40, 40, 330, 0.5, 33.5, false)");
            statement.executeUpdate("insert into Pokemon values(232, 'Donphan', 2, 'Ground', NULL, 'Armor Pokemon', 90, 120, 120, 60, 60, 50, 500, 1.1, 120.0, false)");
            statement.executeUpdate("insert into Pokemon values(233, 'Porygon2', 2, 'Normal', NULL, 'Virtual Pokemon', 85, 80, 90, 105, 95, 60, 515, 0.6, 32.5, false)");
            statement.executeUpdate("insert into Pokemon values(234, 'Stantler', 2, 'Normal', NULL, 'Big Horn Pokemon', 73, 95, 62, 85, 65, 85, 465, 1.4, 71.2, false)");
            statement.executeUpdate("insert into Pokemon values(235, 'Smeargle', 2, 'Normal', NULL, 'Painter Pokemon', 55, 20, 35, 20, 45, 75, 250, 1.2, 58.0, false)");
            statement.executeUpdate("insert into Pokemon values(236, 'Tyrogue', 2, 'Fighting', NULL, 'Scuffle Pokemon', 35, 35, 35, 35, 35, 35, 210, 0.7, 21.0, false)");
            statement.executeUpdate("insert into Pokemon values(237, 'Hitmontop', 2, 'Fighting', NULL, 'Handstand Pokemon', 50, 95, 95, 35, 110, 70, 455, 1.4, 48.0, false)");
            statement.executeUpdate("insert into Pokemon values(238, 'Smoochum', 2, 'Ice', 'Psychic', 'Kiss Pokemon', 45, 30, 15, 85, 65, 65, 305, 0.4, 6.0, false)");
            statement.executeUpdate("insert into Pokemon values(239, 'Elekid', 2, 'Electric', NULL, 'Electric Pokemon', 45, 63, 37, 65, 55, 95, 360, 0.6, 23.5, false)");
            statement.executeUpdate("insert into Pokemon values(240, 'Magby', 2, 'Fire', NULL, 'Live Coal Pokemon', 45, 75, 37, 70, 55, 83, 365, 0.7, 21.4, false)");
            statement.executeUpdate("insert into Pokemon values(241, 'Miltank', 2, 'Normal', NULL, 'Milk Cow Pokemon', 95, 80, 105, 40, 70, 100, 490, 1.2, 75.5, false)");
            statement.executeUpdate("insert into Pokemon values(242, 'Blissey', 2, 'Normal', NULL, 'Happiness Pokemon', 255, 10, 10, 75, 135, 55, 540, 1.5, 46.8, false)");
            statement.executeUpdate("insert into Pokemon values(243, 'Raikou', 2, 'Electric', NULL, 'Thunder Pokemon', 90, 85, 75, 115, 100, 115, 580, 1.9, 178.0, true)");
            statement.executeUpdate("insert into Pokemon values(244, 'Entei', 2, 'Fire', NULL, 'Volcano Pokemon', 115, 115, 85, 90, 75, 100, 580, 2.1, 198.0, true)");
            statement.executeUpdate("insert into Pokemon values(245, 'Suicune', 2, 'Water', NULL, 'Aurora Pokemon', 100, 75, 115, 90, 115, 85, 580, 2.0, 187.0, true)");
            statement.executeUpdate("insert into Pokemon values(246, 'Larvitar', 2, 'Rock', 'Ground', 'Rock Skin Pokemon', 50, 64, 50, 45, 50, 41, 300, 0.6, 72.0, false)");
            statement.executeUpdate("insert into Pokemon values(247, 'Pupitar', 2, 'Rock', 'Ground', 'Hard Shell Pokemon', 70, 84, 70, 65, 70, 51, 410, 1.2, 152.0, false)");
            statement.executeUpdate("insert into Pokemon values(248, 'Tyranitar', 2, 'Rock', 'Dark', 'Armor Pokemon', 100, 134, 110, 95, 100, 61, 600, 2.0, 202.0, false)");
            statement.executeUpdate("insert into Pokemon values(249, 'Lugia', 2, 'Psychic', 'Flying', 'Diving Pokemon', 106, 90, 130, 90, 154, 110, 680, 5.2, 216.0, true)");
            statement.executeUpdate("insert into Pokemon values(250, 'Ho-Oh', 2, 'Fire', 'Flying', 'Rainbow Pokemon', 106, 130, 90, 110, 154, 90, 680, 3.8, 199.0, true)");
            statement.executeUpdate("insert into Pokemon values(251, 'Celebi', 2, 'Psychic', 'Grass', 'Time Travel Pokemon', 100, 100, 100, 100, 100, 100, 600, 0.6, 5.0, true)");

            // ==========================================
            // Generation 3: Hoenn (252 - 386)
            // ==========================================
            statement.executeUpdate("insert into Pokemon values(252, 'Treecko', 3, 'Grass', NULL, 'Wood Gecko Pokemon', 40, 45, 35, 65, 55, 70, 310, 0.5, 5.0, false)");
            statement.executeUpdate("insert into Pokemon values(253, 'Grovyle', 3, 'Grass', NULL, 'Wood Gecko Pokemon', 50, 65, 45, 85, 65, 95, 405, 0.9, 21.6, false)");
            statement.executeUpdate("insert into Pokemon values(254, 'Sceptile', 3, 'Grass', NULL, 'Forest Pokemon', 70, 85, 65, 105, 85, 120, 530, 1.7, 52.2, false)");
            statement.executeUpdate("insert into Pokemon values(255, 'Torchic', 3, 'Fire', NULL, 'Chick Pokemon', 45, 60, 40, 70, 50, 45, 310, 0.4, 2.5, false)");
            statement.executeUpdate("insert into Pokemon values(256, 'Combusken', 3, 'Fire', 'Fighting', 'Young Fowl Pokemon', 60, 85, 60, 85, 60, 55, 405, 0.9, 19.5, false)");
            statement.executeUpdate("insert into Pokemon values(257, 'Blaziken', 3, 'Fire', 'Fighting', 'Blaze Pokemon', 80, 120, 70, 110, 70, 80, 530, 1.9, 52.0, false)");
            statement.executeUpdate("insert into Pokemon values(258, 'Mudkip', 3, 'Water', NULL, 'Mud Fish Pokemon', 50, 70, 50, 50, 50, 40, 310, 0.4, 7.6, false)");
            statement.executeUpdate("insert into Pokemon values(259, 'Marshtomp', 3, 'Water', 'Ground', 'Mud Fish Pokemon', 70, 85, 70, 60, 70, 50, 405, 0.7, 28.0, false)");
            statement.executeUpdate("insert into Pokemon values(260, 'Swampert', 3, 'Water', 'Ground', 'Mud Fish Pokemon', 100, 110, 90, 85, 90, 60, 535, 1.5, 81.9, false)");
            statement.executeUpdate("insert into Pokemon values(261, 'Poochyena', 3, 'Dark', NULL, 'Bite Pokemon', 35, 55, 35, 30, 30, 35, 220, 0.5, 13.6, false)");
            statement.executeUpdate("insert into Pokemon values(262, 'Mightyena', 3, 'Dark', NULL, 'Bite Pokemon', 70, 90, 70, 60, 60, 70, 420, 1.0, 37.0, false)");
            statement.executeUpdate("insert into Pokemon values(263, 'Zigzagoon', 3, 'Normal', NULL, 'Tiny Raccoon Pokemon', 38, 30, 41, 30, 41, 60, 240, 0.4, 17.5, false)");
            statement.executeUpdate("insert into Pokemon values(264, 'Linoone', 3, 'Normal', NULL, 'Rushing Pokemon', 78, 70, 61, 50, 61, 100, 420, 0.5, 32.5, false)");
            statement.executeUpdate("insert into Pokemon values(265, 'Wurmple', 3, 'Bug', NULL, 'Worm Pokemon', 45, 45, 35, 20, 30, 20, 195, 0.3, 3.6, false)");
            statement.executeUpdate("insert into Pokemon values(266, 'Silcoon', 3, 'Bug', NULL, 'Cocoon Pokemon', 50, 35, 55, 25, 25, 15, 205, 0.6, 10.0, false)");
            statement.executeUpdate("insert into Pokemon values(267, 'Beautifly', 3, 'Bug', 'Flying', 'Butterfly Pokemon', 60, 70, 50, 100, 50, 65, 395, 1.0, 28.4, false)");
            statement.executeUpdate("insert into Pokemon values(268, 'Cascoon', 3, 'Bug', NULL, 'Cocoon Pokemon', 50, 35, 55, 25, 25, 15, 205, 0.7, 11.5, false)");
            statement.executeUpdate("insert into Pokemon values(269, 'Dustox', 3, 'Bug', 'Poison', 'Poison Moth Pokemon', 60, 50, 70, 50, 90, 65, 385, 1.2, 31.6, false)");
            statement.executeUpdate("insert into Pokemon values(270, 'Lotad', 3, 'Water', 'Grass', 'Water Weed Pokemon', 40, 30, 30, 40, 50, 30, 220, 0.5, 2.6, false)");
            statement.executeUpdate("insert into Pokemon values(271, 'Lombre', 3, 'Water', 'Grass', 'Jolly Pokemon', 60, 50, 50, 60, 70, 50, 340, 1.2, 32.5, false)");
            statement.executeUpdate("insert into Pokemon values(272, 'Ludicolo', 3, 'Water', 'Grass', 'Carefree Pokemon', 80, 70, 70, 90, 100, 70, 480, 1.5, 55.0, false)");
            statement.executeUpdate("insert into Pokemon values(273, 'Seedot', 3, 'Grass', NULL, 'Acorn Pokemon', 40, 40, 50, 30, 30, 30, 220, 0.5, 4.0, false)");
            statement.executeUpdate("insert into Pokemon values(274, 'Nuzleaf', 3, 'Grass', 'Dark', 'Wily Pokemon', 70, 70, 40, 60, 40, 60, 340, 1.0, 28.0, false)");
            statement.executeUpdate("insert into Pokemon values(275, 'Shiftry', 3, 'Grass', 'Dark', 'Wicked Pokemon', 90, 100, 60, 90, 60, 80, 480, 1.3, 59.6, false)");
            statement.executeUpdate("insert into Pokemon values(276, 'Taillow', 3, 'Normal', 'Flying', 'Tiny Swallow Pokemon', 40, 55, 30, 30, 30, 85, 270, 0.3, 2.3, false)");
            statement.executeUpdate("insert into Pokemon values(277, 'Swellow', 3, 'Normal', 'Flying', 'Swallow Pokemon', 60, 85, 60, 75, 50, 125, 455, 0.7, 19.8, false)");
            statement.executeUpdate("insert into Pokemon values(278, 'Wingull', 3, 'Water', 'Flying', 'Seagull Pokemon', 40, 30, 30, 55, 30, 85, 270, 0.6, 9.5, false)");
            statement.executeUpdate("insert into Pokemon values(279, 'Pelipper', 3, 'Water', 'Flying', 'Water Bird Pokemon', 60, 50, 100, 95, 70, 65, 440, 1.2, 28.0, false)");
            statement.executeUpdate("insert into Pokemon values(280, 'Ralts', 3, 'Psychic', 'Fairy', 'Feeling Pokemon', 28, 25, 25, 45, 35, 40, 198, 0.4, 6.6, false)");
            statement.executeUpdate("insert into Pokemon values(281, 'Kirlia', 3, 'Psychic', 'Fairy', 'Emotion Pokemon', 38, 35, 35, 65, 55, 50, 278, 0.8, 20.2, false)");
            statement.executeUpdate("insert into Pokemon values(282, 'Gardevoir', 3, 'Psychic', 'Fairy', 'Embrace Pokemon', 68, 65, 65, 125, 115, 80, 518, 1.6, 48.4, false)");
            statement.executeUpdate("insert into Pokemon values(283, 'Surskit', 3, 'Bug', 'Water', 'Pond Skater Pokemon', 40, 30, 32, 50, 52, 65, 269, 0.5, 1.7, false)");
            statement.executeUpdate("insert into Pokemon values(284, 'Masquerain', 3, 'Bug', 'Flying', 'Eyeball Pokemon', 70, 60, 62, 100, 82, 80, 454, 0.8, 3.6, false)");
            statement.executeUpdate("insert into Pokemon values(285, 'Shroomish', 3, 'Grass', NULL, 'Mushroom Pokemon', 60, 40, 60, 40, 60, 35, 295, 0.4, 4.5, false)");
            statement.executeUpdate("insert into Pokemon values(286, 'Breloom', 3, 'Grass', 'Fighting', 'Mushroom Pokemon', 60, 130, 80, 60, 60, 70, 460, 1.2, 39.2, false)");
            statement.executeUpdate("insert into Pokemon values(287, 'Slakoth', 3, 'Normal', NULL, 'Slacker Pokemon', 60, 60, 60, 35, 35, 30, 280, 0.8, 24.0, false)");
            statement.executeUpdate("insert into Pokemon values(288, 'Vigoroth', 3, 'Normal', NULL, 'Wild Monkey Pokemon', 80, 80, 80, 55, 55, 90, 440, 1.4, 46.5, false)");
            statement.executeUpdate("insert into Pokemon values(289, 'Slaking', 3, 'Normal', NULL, 'Lazy Pokemon', 150, 160, 100, 95, 65, 100, 670, 2.0, 130.5, false)");
            statement.executeUpdate("insert into Pokemon values(290, 'Nincada', 3, 'Bug', 'Ground', 'Trainee Pokemon', 31, 45, 90, 30, 30, 40, 266, 0.5, 5.5, false)");
            statement.executeUpdate("insert into Pokemon values(291, 'Ninjask', 3, 'Bug', 'Flying', 'Ninja Pokemon', 61, 90, 45, 50, 50, 160, 456, 0.8, 12.0, false)");
            statement.executeUpdate("insert into Pokemon values(292, 'Shedinja', 3, 'Bug', 'Ghost', 'Shed Pokemon', 1, 90, 45, 30, 30, 40, 236, 0.8, 1.2, false)");
            statement.executeUpdate("insert into Pokemon values(293, 'Whismur', 3, 'Normal', NULL, 'Whisper Pokemon', 64, 51, 23, 51, 23, 28, 240, 0.6, 16.3, false)");
            statement.executeUpdate("insert into Pokemon values(294, 'Loudred', 3, 'Normal', NULL, 'Big Voice Pokemon', 84, 71, 43, 71, 43, 48, 360, 1.0, 40.5, false)");
            statement.executeUpdate("insert into Pokemon values(295, 'Exploud', 3, 'Normal', NULL, 'Loud Noise Pokemon', 104, 91, 63, 91, 73, 68, 490, 1.5, 84.0, false)");
            statement.executeUpdate("insert into Pokemon values(296, 'Makuhita', 3, 'Fighting', NULL, 'Guts Pokemon', 72, 60, 30, 20, 30, 25, 237, 1.0, 86.4, false)");
            statement.executeUpdate("insert into Pokemon values(297, 'Hariyama', 3, 'Fighting', NULL, 'Arm Thrust Pokemon', 144, 120, 60, 40, 60, 50, 474, 2.3, 253.8, false)");
            statement.executeUpdate("insert into Pokemon values(298, 'Azurill', 3, 'Normal', 'Fairy', 'Polka Dot Pokemon', 50, 20, 40, 20, 40, 20, 190, 0.2, 2.0, false)");
            statement.executeUpdate("insert into Pokemon values(299, 'Nosepass', 3, 'Rock', NULL, 'Compass Pokemon', 30, 45, 135, 45, 90, 30, 375, 1.0, 97.0, false)");
            statement.executeUpdate("insert into Pokemon values(300, 'Skitty', 3, 'Normal', NULL, 'Kitten Pokemon', 50, 45, 45, 35, 35, 50, 260, 0.6, 11.0, false)");
            statement.executeUpdate("insert into Pokemon values(301, 'Delcatty', 3, 'Normal', NULL, 'Prim Pokemon', 70, 65, 65, 55, 55, 90, 400, 1.1, 32.6, false)");
            statement.executeUpdate("insert into Pokemon values(302, 'Sableye', 3, 'Dark', 'Ghost', 'Darkness Pokemon', 50, 75, 75, 65, 65, 50, 380, 0.5, 11.0, false)");
            statement.executeUpdate("insert into Pokemon values(303, 'Mawile', 3, 'Steel', 'Fairy', 'Deceiver Pokemon', 50, 85, 85, 55, 55, 50, 380, 0.6, 11.5, false)");
            statement.executeUpdate("insert into Pokemon values(304, 'Aron', 3, 'Steel', 'Rock', 'Iron Armor Pokemon', 50, 70, 100, 40, 40, 30, 330, 0.4, 60.0, false)");
            statement.executeUpdate("insert into Pokemon values(305, 'Lairon', 3, 'Steel', 'Rock', 'Iron Armor Pokemon', 60, 90, 140, 50, 50, 40, 430, 0.9, 120.0, false)");
            statement.executeUpdate("insert into Pokemon values(306, 'Aggron', 3, 'Steel', 'Rock', 'Iron Armor Pokemon', 70, 110, 180, 60, 60, 50, 530, 2.1, 360.0, false)");
            statement.executeUpdate("insert into Pokemon values(307, 'Meditite', 3, 'Fighting', 'Psychic', 'Meditate Pokemon', 30, 40, 55, 40, 55, 60, 280, 0.6, 11.2, false)");
            statement.executeUpdate("insert into Pokemon values(308, 'Medicham', 3, 'Fighting', 'Psychic', 'Meditate Pokemon', 60, 60, 75, 60, 75, 80, 410, 1.3, 31.5, false)");
            statement.executeUpdate("insert into Pokemon values(309, 'Electrike', 3, 'Electric', NULL, 'Lightning Pokemon', 40, 45, 40, 65, 40, 65, 295, 0.6, 15.2, false)");
            statement.executeUpdate("insert into Pokemon values(310, 'Manectric', 3, 'Electric', NULL, 'Discharge Pokemon', 70, 75, 60, 105, 60, 105, 475, 1.5, 40.2, false)");
            statement.executeUpdate("insert into Pokemon values(311, 'Plusle', 3, 'Electric', NULL, 'Cheering Pokemon', 60, 50, 40, 85, 75, 95, 405, 0.4, 4.2, false)");
            statement.executeUpdate("insert into Pokemon values(312, 'Minun', 3, 'Electric', NULL, 'Cheering Pokemon', 60, 40, 50, 75, 85, 95, 405, 0.4, 4.2, false)");
            statement.executeUpdate("insert into Pokemon values(313, 'Volbeat', 3, 'Bug', NULL, 'Firefly Pokemon', 65, 73, 75, 47, 85, 85, 430, 0.7, 17.7, false)");
            statement.executeUpdate("insert into Pokemon values(314, 'Illumise', 3, 'Bug', NULL, 'Firefly Pokemon', 65, 47, 75, 73, 85, 85, 430, 0.6, 17.7, false)");
            statement.executeUpdate("insert into Pokemon values(315, 'Roselia', 3, 'Grass', 'Poison', 'Thorn Pokemon', 50, 60, 45, 100, 80, 65, 400, 0.3, 2.0, false)");
            statement.executeUpdate("insert into Pokemon values(316, 'Gulpin', 3, 'Poison', NULL, 'Stomach Pokemon', 70, 43, 53, 43, 53, 40, 302, 0.4, 10.3, false)");
            statement.executeUpdate("insert into Pokemon values(317, 'Swalot', 3, 'Poison', NULL, 'Poison Bag Pokemon', 100, 73, 83, 73, 83, 55, 467, 1.7, 80.0, false)");
            statement.executeUpdate("insert into Pokemon values(318, 'Carvanha', 3, 'Water', 'Dark', 'Savage Pokemon', 45, 90, 20, 65, 20, 65, 305, 0.8, 20.8, false)");
            statement.executeUpdate("insert into Pokemon values(319, 'Sharpedo', 3, 'Water', 'Dark', 'Brutal Pokemon', 70, 120, 40, 95, 40, 95, 460, 1.8, 88.8, false)");
            statement.executeUpdate("insert into Pokemon values(320, 'Wailmer', 3, 'Water', NULL, 'Ball Whale Pokemon', 130, 70, 35, 70, 35, 60, 400, 2.0, 130.0, false)");
            statement.executeUpdate("insert into Pokemon values(321, 'Wailord', 3, 'Water', NULL, 'Float Whale Pokemon', 170, 90, 45, 90, 45, 60, 500, 14.5, 398.0, false)");
            statement.executeUpdate("insert into Pokemon values(322, 'Numel', 3, 'Fire', 'Ground', 'Numb Pokemon', 60, 60, 40, 65, 45, 35, 305, 0.7, 24.0, false)");
            statement.executeUpdate("insert into Pokemon values(323, 'Camerupt', 3, 'Fire', 'Ground', 'Eruption Pokemon', 70, 100, 70, 105, 75, 40, 460, 1.9, 220.0, false)");
            statement.executeUpdate("insert into Pokemon values(324, 'Torkoal', 3, 'Fire', NULL, 'Coal Pokemon', 70, 85, 140, 85, 70, 20, 470, 0.5, 80.4, false)");
            statement.executeUpdate("insert into Pokemon values(325, 'Spoink', 3, 'Psychic', NULL, 'Bounce Pokemon', 60, 25, 35, 70, 80, 60, 330, 0.7, 30.6, false)");
            statement.executeUpdate("insert into Pokemon values(326, 'Grumpig', 3, 'Psychic', NULL, 'Manipulate Pokemon', 80, 45, 65, 90, 110, 80, 470, 0.9, 71.5, false)");
            statement.executeUpdate("insert into Pokemon values(327, 'Spinda', 3, 'Normal', NULL, 'Spot Panda Pokemon', 60, 60, 60, 60, 60, 60, 360, 1.1, 5.0, false)");
            statement.executeUpdate("insert into Pokemon values(328, 'Trapinch', 3, 'Ground', NULL, 'Ant Pit Pokemon', 45, 100, 45, 45, 45, 10, 290, 0.7, 15.0, false)");
            statement.executeUpdate("insert into Pokemon values(329, 'Vibrava', 3, 'Ground', 'Dragon', 'Vibration Pokemon', 50, 70, 50, 50, 50, 70, 340, 1.1, 15.3, false)");
            statement.executeUpdate("insert into Pokemon values(330, 'Flygon', 3, 'Ground', 'Dragon', 'Mystic Pokemon', 80, 100, 80, 80, 80, 100, 520, 2.0, 82.0, false)");
            statement.executeUpdate("insert into Pokemon values(331, 'Cacnea', 3, 'Grass', NULL, 'Cactus Pokemon', 50, 85, 40, 85, 40, 35, 335, 0.4, 51.3, false)");
            statement.executeUpdate("insert into Pokemon values(332, 'Cacturne', 3, 'Grass', 'Dark', 'Scarecrow Pokemon', 70, 115, 60, 115, 60, 55, 475, 1.3, 77.4, false)");
            statement.executeUpdate("insert into Pokemon values(333, 'Swablu', 3, 'Normal', 'Flying', 'Cotton Bird Pokemon', 45, 40, 60, 40, 75, 50, 310, 0.4, 1.2, false)");
            statement.executeUpdate("insert into Pokemon values(334, 'Altaria', 3, 'Dragon', 'Flying', 'Humming Pokemon', 75, 70, 90, 70, 105, 80, 490, 1.1, 20.6, false)");
            statement.executeUpdate("insert into Pokemon values(335, 'Zangoose', 3, 'Normal', NULL, 'Cat Ferret Pokemon', 73, 115, 60, 60, 60, 90, 458, 1.3, 40.3, false)");
            statement.executeUpdate("insert into Pokemon values(336, 'Seviper', 3, 'Poison', NULL, 'Fang Snake Pokemon', 73, 100, 60, 100, 60, 65, 458, 2.7, 52.5, false)");
            statement.executeUpdate("insert into Pokemon values(337, 'Lunatone', 3, 'Rock', 'Psychic', 'Meteorite Pokemon', 90, 55, 65, 95, 85, 70, 460, 1.0, 168.0, false)");
            statement.executeUpdate("insert into Pokemon values(338, 'Solrock', 3, 'Rock', 'Psychic', 'Meteorite Pokemon', 90, 95, 85, 55, 65, 70, 460, 1.2, 154.0, false)");
            statement.executeUpdate("insert into Pokemon values(339, 'Barboach', 3, 'Water', 'Ground', 'Whiskers Pokemon', 50, 48, 43, 46, 41, 60, 288, 0.4, 1.9, false)");
            statement.executeUpdate("insert into Pokemon values(340, 'Whiscash', 3, 'Water', 'Ground', 'Whiskers Pokemon', 110, 78, 73, 76, 71, 60, 468, 0.9, 23.6, false)");
            statement.executeUpdate("insert into Pokemon values(341, 'Corphish', 3, 'Water', NULL, 'Ruffian Pokemon', 43, 80, 65, 50, 35, 35, 308, 0.6, 11.5, false)");
            statement.executeUpdate("insert into Pokemon values(342, 'Crawdaunt', 3, 'Water', 'Dark', 'Rogue Pokemon', 63, 120, 85, 90, 55, 55, 468, 1.1, 32.8, false)");
            statement.executeUpdate("insert into Pokemon values(343, 'Baltoy', 3, 'Ground', 'Psychic', 'Clay Doll Pokemon', 40, 40, 55, 40, 70, 55, 300, 0.5, 21.5, false)");
            statement.executeUpdate("insert into Pokemon values(344, 'Claydol', 3, 'Ground', 'Psychic', 'Clay Doll Pokemon', 60, 70, 105, 70, 120, 75, 500, 1.5, 108.0, false)");
            statement.executeUpdate("insert into Pokemon values(345, 'Lileep', 3, 'Rock', 'Grass', 'Sea Lily Pokemon', 66, 41, 77, 61, 87, 23, 355, 1.0, 23.8, false)");
            statement.executeUpdate("insert into Pokemon values(346, 'Cradily', 3, 'Rock', 'Grass', 'Barnacle Pokemon', 86, 81, 97, 81, 107, 43, 495, 1.5, 60.4, false)");
            statement.executeUpdate("insert into Pokemon values(347, 'Anorith', 3, 'Rock', 'Bug', 'Old Shrimp Pokemon', 45, 95, 50, 40, 50, 75, 355, 0.7, 12.5, false)");
            statement.executeUpdate("insert into Pokemon values(348, 'Armaldo', 3, 'Rock', 'Bug', 'Plate Pokemon', 75, 125, 100, 70, 80, 45, 495, 1.5, 68.2, false)");
            statement.executeUpdate("insert into Pokemon values(349, 'Feebas', 3, 'Water', NULL, 'Fish Pokemon', 20, 15, 20, 10, 55, 80, 200, 0.6, 7.4, false)");
            statement.executeUpdate("insert into Pokemon values(350, 'Milotic', 3, 'Water', NULL, 'Tender Pokemon', 95, 60, 79, 100, 125, 81, 540, 6.2, 162.0, false)");
            statement.executeUpdate("insert into Pokemon values(351, 'Castform', 3, 'Normal', NULL, 'Weather Pokemon', 70, 70, 70, 70, 70, 70, 420, 0.3, 0.8, false)");
            statement.executeUpdate("insert into Pokemon values(352, 'Kecleon', 3, 'Normal', NULL, 'Color Swap Pokemon', 60, 90, 70, 60, 120, 40, 440, 1.0, 22.0, false)");
            statement.executeUpdate("insert into Pokemon values(353, 'Shuppet', 3, 'Ghost', NULL, 'Puppet Pokemon', 44, 75, 35, 63, 33, 45, 295, 0.6, 2.3, false)");
            statement.executeUpdate("insert into Pokemon values(354, 'Banette', 3, 'Ghost', NULL, 'Marionette Pokemon', 64, 115, 65, 83, 63, 65, 455, 1.1, 12.5, false)");
            statement.executeUpdate("insert into Pokemon values(355, 'Duskull', 3, 'Ghost', NULL, 'Requiem Pokemon', 20, 40, 90, 30, 90, 25, 295, 0.8, 15.0, false)");
            statement.executeUpdate("insert into Pokemon values(356, 'Dusclops', 3, 'Ghost', NULL, 'Beckon Pokemon', 40, 70, 130, 60, 130, 25, 455, 1.6, 30.6, false)");
            statement.executeUpdate("insert into Pokemon values(357, 'Tropius', 3, 'Grass', 'Flying', 'Fruit Pokemon', 99, 68, 83, 72, 87, 51, 460, 2.0, 100.0, false)");
            statement.executeUpdate("insert into Pokemon values(358, 'Chimecho', 3, 'Psychic', NULL, 'Wind Chime Pokemon', 75, 50, 80, 95, 90, 65, 455, 0.6, 1.0, false)");
            statement.executeUpdate("insert into Pokemon values(359, 'Absol', 3, 'Dark', NULL, 'Disaster Pokemon', 65, 130, 60, 75, 60, 75, 465, 1.2, 47.0, false)");
            statement.executeUpdate("insert into Pokemon values(360, 'Wynaut', 3, 'Psychic', NULL, 'Bright Pokemon', 95, 23, 48, 23, 48, 23, 260, 0.6, 14.0, false)");
            statement.executeUpdate("insert into Pokemon values(361, 'Snorunt', 3, 'Ice', NULL, 'Snow Hat Pokemon', 50, 50, 50, 50, 50, 50, 300, 0.7, 16.8, false)");
            statement.executeUpdate("insert into Pokemon values(362, 'Glalie', 3, 'Ice', NULL, 'Face Pokemon', 80, 80, 80, 80, 80, 80, 480, 1.5, 256.5, false)");
            statement.executeUpdate("insert into Pokemon values(363, 'Spheal', 3, 'Ice', 'Water', 'Clap Pokemon', 70, 40, 50, 55, 50, 25, 290, 0.8, 39.5, false)");
            statement.executeUpdate("insert into Pokemon values(364, 'Sealeo', 3, 'Ice', 'Water', 'Ball Roll Pokemon', 90, 60, 70, 75, 70, 45, 410, 1.1, 87.6, false)");
            statement.executeUpdate("insert into Pokemon values(365, 'Walrein', 3, 'Ice', 'Water', 'Ice Break Pokemon', 110, 80, 90, 95, 90, 65, 530, 1.4, 150.6, false)");
            statement.executeUpdate("insert into Pokemon values(366, 'Clamperl', 3, 'Water', NULL, 'Bivalve Pokemon', 35, 64, 85, 74, 55, 32, 345, 0.4, 52.5, false)");
            statement.executeUpdate("insert into Pokemon values(367, 'Huntail', 3, 'Water', NULL, 'Deep Sea Pokemon', 55, 104, 105, 94, 75, 52, 485, 1.7, 27.0, false)");
            statement.executeUpdate("insert into Pokemon values(368, 'Gorebyss', 3, 'Water', NULL, 'South Sea Pokemon', 55, 84, 105, 114, 75, 52, 485, 1.8, 22.6, false)");
            statement.executeUpdate("insert into Pokemon values(369, 'Relicanth', 3, 'Water', 'Rock', 'Longevity Pokemon', 100, 90, 130, 45, 65, 55, 485, 1.0, 23.4, false)");
            statement.executeUpdate("insert into Pokemon values(370, 'Luvdisc', 3, 'Water', NULL, 'Rendezvous Pokemon', 43, 30, 55, 40, 65, 97, 330, 0.6, 8.7, false)");
            statement.executeUpdate("insert into Pokemon values(371, 'Bagon', 3, 'Dragon', NULL, 'Rock Head Pokemon', 45, 75, 60, 40, 30, 50, 300, 0.6, 42.1, false)");
            statement.executeUpdate("insert into Pokemon values(372, 'Shelgon', 3, 'Dragon', NULL, 'Endurance Pokemon', 65, 95, 100, 60, 50, 50, 420, 1.1, 110.5, false)");
            statement.executeUpdate("insert into Pokemon values(373, 'Salamence', 3, 'Dragon', 'Flying', 'Dragon Pokemon', 95, 135, 80, 110, 80, 100, 600, 1.5, 102.6, false)");
            statement.executeUpdate("insert into Pokemon values(374, 'Beldum', 3, 'Steel', 'Psychic', 'Iron Ball Pokemon', 40, 55, 80, 35, 60, 30, 300, 0.6, 95.2, false)");
            statement.executeUpdate("insert into Pokemon values(375, 'Metang', 3, 'Steel', 'Psychic', 'Iron Claw Pokemon', 60, 75, 100, 55, 80, 50, 420, 1.2, 202.5, false)");
            statement.executeUpdate("insert into Pokemon values(376, 'Metagross', 3, 'Steel', 'Psychic', 'Iron Leg Pokemon', 80, 135, 130, 95, 90, 70, 600, 1.6, 550.0, false)");
            statement.executeUpdate("insert into Pokemon values(377, 'Regirock', 3, 'Rock', NULL, 'Rock Peak Pokemon', 80, 100, 200, 50, 100, 50, 580, 1.7, 230.0, true)");
            statement.executeUpdate("insert into Pokemon values(378, 'Regice', 3, 'Ice', NULL, 'Iceberg Pokemon', 80, 50, 100, 100, 200, 50, 580, 1.8, 175.0, true)");
            statement.executeUpdate("insert into Pokemon values(379, 'Registeel', 3, 'Steel', NULL, 'Iron Pokemon', 80, 75, 150, 75, 150, 50, 580, 1.9, 205.0, true)");
            statement.executeUpdate("insert into Pokemon values(380, 'Latias', 3, 'Dragon', 'Psychic', 'Eon Pokemon', 80, 80, 90, 110, 130, 110, 600, 1.4, 40.0, true)");
            statement.executeUpdate("insert into Pokemon values(381, 'Latios', 3, 'Dragon', 'Psychic', 'Eon Pokemon', 80, 90, 80, 130, 110, 110, 600, 2.0, 60.0, true)");
            statement.executeUpdate("insert into Pokemon values(382, 'Kyogre', 3, 'Water', NULL, 'Sea Basin Pokemon', 100, 100, 90, 150, 140, 90, 670, 4.5, 352.0, true)");
            statement.executeUpdate("insert into Pokemon values(383, 'Groudon', 3, 'Ground', NULL, 'Continent Pokemon', 100, 150, 140, 100, 90, 90, 670, 3.5, 950.0, true)");
            statement.executeUpdate("insert into Pokemon values(384, 'Rayquaza', 3, 'Dragon', 'Flying', 'Sky High Pokemon', 105, 150, 90, 150, 90, 95, 680, 7.0, 206.5, true)");
            statement.executeUpdate("insert into Pokemon values(385, 'Jirachi', 3, 'Steel', 'Psychic', 'Wish Pokemon', 100, 100, 100, 100, 100, 100, 600, 0.3, 1.1, true)");
            statement.executeUpdate("insert into Pokemon values(386, 'Deoxys', 3, 'Psychic', NULL, 'DNA Pokemon', 50, 150, 50, 150, 50, 150, 600, 1.7, 60.8, true)");

            // Commit transaction and restore autocommit
            connection.commit();
            connection.setAutoCommit(true);

            // Display contents of the Pokemon table
            String sqlQuery = "SELECT * FROM Pokemon";
            ResultSet rs = statement.executeQuery(sqlQuery);

            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.printf("%-5s | %-15s | %-5s | %-15s | %-6s | %-6s | %-6s | %-9s%n",
                    "ID", "Name", "Gen", "Type", "HP", "Atk", "Def", "Legendary");
            System.out.println("-----------------------------------------------------------------------------------------");

            int count = 0;
            while (rs.next()) {
                count++;
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int gen = rs.getInt("generation");
                String type1 = rs.getString("type1");
                String type2 = rs.getString("type2");
                String typeStr = (type2 != null) ? type1 + "/" + type2 : type1;
                int hp = rs.getInt("hp");
                int atk = rs.getInt("attack");
                int def = rs.getInt("defense");
                boolean isLeg = rs.getBoolean("is_legendary");

                // Preview first few of each gen and summary
                if (id <= 5 || id == 151 || id == 152 || id == 251 || id == 252 || id >= 384) {
                    System.out.printf("#%-4d | %-15s | Gen %d | %-15s | %-6d | %-6d | %-6d | %-9s%n",
                            id, name, gen, typeStr, hp, atk, def, isLeg ? "Yes" : "No");
                } else if (id == 6) {
                    System.out.println("  ... (Pokemon #006 - #150 Kanto omitted for display) ...");
                } else if (id == 153) {
                    System.out.println("  ... (Pokemon #153 - #250 Johto omitted for display) ...");
                } else if (id == 253) {
                    System.out.println("  ... (Pokemon #253 - #383 Hoenn omitted for display) ...");
                }
            }
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Successfully populated pokemon.db with " + count + " Pokemon across Generations 1, 2, and 3!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
