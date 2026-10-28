# Assignment #10: Building a Java API for a SQLite Database

**Author:** Carter Beasley  
**Course:** CS 67 – Object-Oriented Programming  

---

## 1. Project Description

### Database Topic & Data Source
The SQLite database (`pokemon.db`) stores Pokedex and base combat statistics for all **386 Pokemon across Generations 1 through 3** (Kanto #1–#151, Johto #152–#251, and Hoenn #252–#386). Each record in the `Pokemon` table includes:
- `id`: National Pokedex number (`1`–`386`)
- `name`: Pokemon name
- `generation`: Generation introduced (`1`, `2`, or `3`)
- `type1` and `type2`: Primary and optional secondary elemental types (e.g., `Fire`, `Water`, `Dragon/Flying`)
- `species`: Pokedex classification (e.g., `Flame Pokemon`, `Seed Pokemon`)
- Base stats: `hp`, `attack`, `defense`, `sp_attack`, `sp_defense`, `speed`, and `total` (Base Stat Total)
- Physical dimensions: `height_m` (meters) and `weight_kg` (kilograms)
- `is_legendary`: Boolean flag (`true` / `false`) indicating Legendary or Mythical status

**Data Source Identification:** The sample Pokemon dataset and `CreatePokemonDB.java` database builder script were generated with the assistance of an AI tool based on standard National Pokedex data (Generations 1–3) and modeled after the `CreateDB.java` SQLite setup provided in class.

### Purpose of the Program
This project provides a clean, reusable Java Application Programming Interface (`PokemonAPI`) that wraps SQLite JDBC queries and returns structured `Pokemon` model objects. A console-based driver program (`Driver`) interacts with `PokemonAPI` through a numbered menu, allowing users to query, filter, and explore Pokemon data without writing SQL queries directly.

### Questions the API Can Answer
Using the static methods in `PokemonAPI`, the program can answer questions such as:
- **What are all the Pokemon in the database?** (`PokemonAPI.getAllPokemon()`)
- **Which Pokemon has a specific Pokedex ID, and what are its stats and species?** (`PokemonAPI.getPokemonById(int pokemonId)`)
- **Which Pokemon have names matching a given search term?** (`PokemonAPI.searchPokemonByName(String nameQuery)`)
- **Which Pokemon belong to a specific elemental type (primary or secondary), such as Dragon or Fire?** (`PokemonAPI.getPokemonByType(String type)`)
- **Which Pokemon were introduced in Generation 1, 2, or 3?** (`PokemonAPI.getPokemonByGeneration(int generation)`)
- **Which Pokemon have a Base Stat Total at or above a given threshold (e.g., 600+)?** (`PokemonAPI.getPokemonWithMinTotalStats(int minTotal)`)
- **Which Pokemon across Generations 1–3 are Legendary or Mythical?** (`PokemonAPI.getLegendaryPokemon()`)

---

## 2. Example Test Run

```text
==================================================
   Pokemon Database API Console Driver (Gen 1-3)  
==================================================

--- Main Menu ---
1. Display all Pokemon
2. Find a Pokemon by ID
3. Search for a Pokemon by name
4. Display Pokemon by elemental type
5. Display Pokemon by generation (1, 2, or 3)
6. Display Pokemon with minimum Base Stat Total
7. Display all Legendary Pokemon
8. Exit
Enter your choice: 2
Enter Pokedex ID (1-386): 258

--- Pokemon Found ---
#258 Mudkip          | Gen 3 | Water           | HP: 50  Atk: 70  Def: 50  SpA: 50  SpD: 50  Spe: 40  | Total: 310
Species: Mud Fish Pokemon | Height: 0.4 m | Weight: 7.6 kg

--- Main Menu ---
1. Display all Pokemon
2. Find a Pokemon by ID
3. Search for a Pokemon by name
4. Display Pokemon by elemental type
5. Display Pokemon by generation (1, 2, or 3)
6. Display Pokemon with minimum Base Stat Total
7. Display all Legendary Pokemon
8. Exit
Enter your choice: 3
Enter Pokemon name to search: char

=== Search Results for "char" ===
#4   Charmander      | Gen 1 | Fire            | HP: 39  Atk: 52  Def: 43  SpA: 60  SpD: 50  Spe: 65  | Total: 309
#5   Charmeleon      | Gen 1 | Fire            | HP: 58  Atk: 64  Def: 58  SpA: 80  SpD: 65  Spe: 80  | Total: 405
#6   Charizard       | Gen 1 | Fire/Flying     | HP: 78  Atk: 84  Def: 78  SpA: 109 SpD: 85  Spe: 100 | Total: 534
Total results: 3

--- Main Menu ---
1. Display all Pokemon
2. Find a Pokemon by ID
3. Search for a Pokemon by name
4. Display Pokemon by elemental type
5. Display Pokemon by generation (1, 2, or 3)
6. Display Pokemon with minimum Base Stat Total
7. Display all Legendary Pokemon
8. Exit
Enter your choice: 4
Enter elemental type (e.g., Fire, Water, Grass, Dragon): Dragon

=== Pokemon of Type: Dragon ===
#147 Dratini         | Gen 1 | Dragon          | HP: 41  Atk: 64  Def: 45  SpA: 50  SpD: 50  Spe: 50  | Total: 300
#148 Dragonair       | Gen 1 | Dragon          | HP: 61  Atk: 84  Def: 65  SpA: 70  SpD: 70  Spe: 70  | Total: 420
#149 Dragonite       | Gen 1 | Dragon/Flying   | HP: 91  Atk: 134 Def: 95  SpA: 100 SpD: 100 Spe: 80  | Total: 600
#230 Kingdra         | Gen 2 | Water/Dragon    | HP: 75  Atk: 95  Def: 95  SpA: 95  SpD: 95  Spe: 85  | Total: 540
#329 Vibrava         | Gen 3 | Ground/Dragon   | HP: 50  Atk: 70  Def: 50  SpA: 50  SpD: 50  Spe: 70  | Total: 340
#330 Flygon          | Gen 3 | Ground/Dragon   | HP: 80  Atk: 100 Def: 80  SpA: 80  SpD: 80  Spe: 100 | Total: 520
#334 Altaria         | Gen 3 | Dragon/Flying   | HP: 75  Atk: 70  Def: 90  SpA: 70  SpD: 105 Spe: 80  | Total: 490
#371 Bagon           | Gen 3 | Dragon          | HP: 45  Atk: 75  Def: 60  SpA: 40  SpD: 30  Spe: 50  | Total: 300
#372 Shelgon         | Gen 3 | Dragon          | HP: 65  Atk: 95  Def: 100 SpA: 60  SpD: 50  Spe: 50  | Total: 420
#373 Salamence       | Gen 3 | Dragon/Flying   | HP: 95  Atk: 135 Def: 80  SpA: 110 SpD: 80  Spe: 100 | Total: 600
#380 Latias          | Gen 3 | Dragon/Psychic  | HP: 80  Atk: 80  Def: 90  SpA: 110 SpD: 130 Spe: 110 | Total: 600 [LEGENDARY]
#381 Latios          | Gen 3 | Dragon/Psychic  | HP: 80  Atk: 90  Def: 80  SpA: 130 SpD: 110 Spe: 110 | Total: 600 [LEGENDARY]
#384 Rayquaza        | Gen 3 | Dragon/Flying   | HP: 105 Atk: 150 Def: 90  SpA: 150 SpD: 90  Spe: 95  | Total: 680 [LEGENDARY]
Total results: 13

--- Main Menu ---
1. Display all Pokemon
2. Find a Pokemon by ID
3. Search for a Pokemon by name
4. Display Pokemon by elemental type
5. Display Pokemon by generation (1, 2, or 3)
6. Display Pokemon with minimum Base Stat Total
7. Display all Legendary Pokemon
8. Exit
Enter your choice: 6
Enter minimum Base Stat Total (e.g., 600): 600

=== Pokemon with Base Stat Total >= 600 ===
#150 Mewtwo          | Gen 1 | Psychic         | HP: 106 Atk: 110 Def: 90  SpA: 154 SpD: 90  Spe: 130 | Total: 680 [LEGENDARY]
#249 Lugia           | Gen 2 | Psychic/Flying  | HP: 106 Atk: 90  Def: 130 SpA: 90  SpD: 154 Spe: 110 | Total: 680 [LEGENDARY]
#250 Ho-Oh           | Gen 2 | Fire/Flying     | HP: 106 Atk: 130 Def: 90  SpA: 110 SpD: 154 Spe: 90  | Total: 680 [LEGENDARY]
#384 Rayquaza        | Gen 3 | Dragon/Flying   | HP: 105 Atk: 150 Def: 90  SpA: 150 SpD: 90  Spe: 95  | Total: 680 [LEGENDARY]
#289 Slaking         | Gen 3 | Normal          | HP: 150 Atk: 160 Def: 100 SpA: 95  SpD: 65  Spe: 100 | Total: 670
#382 Kyogre          | Gen 3 | Water           | HP: 100 Atk: 100 Def: 90  SpA: 150 SpD: 140 Spe: 90  | Total: 670 [LEGENDARY]
#383 Groudon         | Gen 3 | Ground          | HP: 100 Atk: 150 Def: 140 SpA: 100 SpD: 90  Spe: 90  | Total: 670 [LEGENDARY]
#149 Dragonite       | Gen 1 | Dragon/Flying   | HP: 91  Atk: 134 Def: 95  SpA: 100 SpD: 100 Spe: 80  | Total: 600
#151 Mew             | Gen 1 | Psychic         | HP: 100 Atk: 100 Def: 100 SpA: 100 SpD: 100 Spe: 100 | Total: 600 [LEGENDARY]
#248 Tyranitar       | Gen 2 | Rock/Dark       | HP: 100 Atk: 134 Def: 110 SpA: 95  SpD: 100 Spe: 61  | Total: 600
#251 Celebi          | Gen 2 | Psychic/Grass   | HP: 100 Atk: 100 Def: 100 SpA: 100 SpD: 100 Spe: 100 | Total: 600 [LEGENDARY]
#373 Salamence       | Gen 3 | Dragon/Flying   | HP: 95  Atk: 135 Def: 80  SpA: 110 SpD: 80  Spe: 100 | Total: 600
#376 Metagross       | Gen 3 | Steel/Psychic   | HP: 80  Atk: 135 Def: 130 SpA: 95  SpD: 90  Spe: 70  | Total: 600
#380 Latias          | Gen 3 | Dragon/Psychic  | HP: 80  Atk: 80  Def: 90  SpA: 110 SpD: 130 Spe: 110 | Total: 600 [LEGENDARY]
#381 Latios          | Gen 3 | Dragon/Psychic  | HP: 80  Atk: 90  Def: 80  SpA: 130 SpD: 110 Spe: 110 | Total: 600 [LEGENDARY]
#385 Jirachi         | Gen 3 | Steel/Psychic   | HP: 100 Atk: 100 Def: 100 SpA: 100 SpD: 100 Spe: 100 | Total: 600 [LEGENDARY]
#386 Deoxys          | Gen 3 | Psychic         | HP: 50  Atk: 150 Def: 50  SpA: 150 SpD: 50  Spe: 150 | Total: 600 [LEGENDARY]
Total results: 17

--- Main Menu ---
1. Display all Pokemon
2. Find a Pokemon by ID
3. Search for a Pokemon by name
4. Display Pokemon by elemental type
5. Display Pokemon by generation (1, 2, or 3)
6. Display Pokemon with minimum Base Stat Total
7. Display all Legendary Pokemon
8. Exit
Enter your choice: 7

=== Legendary & Mythical Pokemon ===
#144 Articuno        | Gen 1 | Ice/Flying      | HP: 90  Atk: 85  Def: 100 SpA: 95  SpD: 125 Spe: 85  | Total: 580 [LEGENDARY]
#145 Zapdos          | Gen 1 | Electric/Flying | HP: 90  Atk: 90  Def: 85  SpA: 125 SpD: 90  Spe: 100 | Total: 580 [LEGENDARY]
#146 Moltres         | Gen 1 | Fire/Flying     | HP: 90  Atk: 100 Def: 90  SpA: 125 SpD: 85  Spe: 90  | Total: 580 [LEGENDARY]
#150 Mewtwo          | Gen 1 | Psychic         | HP: 106 Atk: 110 Def: 90  SpA: 154 SpD: 90  Spe: 130 | Total: 680 [LEGENDARY]
#151 Mew             | Gen 1 | Psychic         | HP: 100 Atk: 100 Def: 100 SpA: 100 SpD: 100 Spe: 100 | Total: 600 [LEGENDARY]
#243 Raikou          | Gen 2 | Electric        | HP: 90  Atk: 85  Def: 75  SpA: 115 SpD: 100 Spe: 115 | Total: 580 [LEGENDARY]
#244 Entei           | Gen 2 | Fire            | HP: 115 Atk: 115 Def: 85  SpA: 90  SpD: 75  Spe: 100 | Total: 580 [LEGENDARY]
#245 Suicune         | Gen 2 | Water           | HP: 100 Atk: 75  Def: 115 SpA: 90  SpD: 115 Spe: 85  | Total: 580 [LEGENDARY]
#249 Lugia           | Gen 2 | Psychic/Flying  | HP: 106 Atk: 90  Def: 130 SpA: 90  SpD: 154 Spe: 110 | Total: 680 [LEGENDARY]
#250 Ho-Oh           | Gen 2 | Fire/Flying     | HP: 106 Atk: 130 Def: 90  SpA: 110 SpD: 154 Spe: 90  | Total: 680 [LEGENDARY]
#251 Celebi          | Gen 2 | Psychic/Grass   | HP: 100 Atk: 100 Def: 100 SpA: 100 SpD: 100 Spe: 100 | Total: 600 [LEGENDARY]
#377 Regirock        | Gen 3 | Rock            | HP: 80  Atk: 100 Def: 200 SpA: 50  SpD: 100 Spe: 50  | Total: 580 [LEGENDARY]
#378 Regice          | Gen 3 | Ice             | HP: 80  Atk: 50  Def: 100 SpA: 100 SpD: 200 Spe: 50  | Total: 580 [LEGENDARY]
#379 Registeel       | Gen 3 | Steel           | HP: 80  Atk: 75  Def: 150 SpA: 75  SpD: 150 Spe: 50  | Total: 580 [LEGENDARY]
#380 Latias          | Gen 3 | Dragon/Psychic  | HP: 80  Atk: 80  Def: 90  SpA: 110 SpD: 130 Spe: 110 | Total: 600 [LEGENDARY]
#381 Latios          | Gen 3 | Dragon/Psychic  | HP: 80  Atk: 90  Def: 80  SpA: 130 SpD: 110 Spe: 110 | Total: 600 [LEGENDARY]
#382 Kyogre          | Gen 3 | Water           | HP: 100 Atk: 100 Def: 90  SpA: 150 SpD: 140 Spe: 90  | Total: 670 [LEGENDARY]
#383 Groudon         | Gen 3 | Ground          | HP: 100 Atk: 150 Def: 140 SpA: 100 SpD: 90  Spe: 90  | Total: 670 [LEGENDARY]
#384 Rayquaza        | Gen 3 | Dragon/Flying   | HP: 105 Atk: 150 Def: 90  SpA: 150 SpD: 90  Spe: 95  | Total: 680 [LEGENDARY]
#385 Jirachi         | Gen 3 | Steel/Psychic   | HP: 100 Atk: 100 Def: 100 SpA: 100 SpD: 100 Spe: 100 | Total: 600 [LEGENDARY]
#386 Deoxys          | Gen 3 | Psychic         | HP: 50  Atk: 150 Def: 50  SpA: 150 SpD: 50  Spe: 150 | Total: 600 [LEGENDARY]
Total results: 21

--- Main Menu ---
1. Display all Pokemon
2. Find a Pokemon by ID
3. Search for a Pokemon by name
4. Display Pokemon by elemental type
5. Display Pokemon by generation (1, 2, or 3)
6. Display Pokemon with minimum Base Stat Total
7. Display all Legendary Pokemon
8. Exit
Enter your choice: 8
Exiting program. Goodbye!
```

---

## 3. AI Usage Statement

- **AI Tool(s) Used:** Google Gemini (and Claude for initial database population in `CreatePokemonDB.java`).
- **How AI Was Used:** AI tools were used to help generate the SQLite `INSERT` statements for the 386 Generation 1–3 Pokemon in `CreatePokemonDB.java` (`pokemon.db`), structure the `Pokemon` model class and static query methods in `PokemonAPI.java`, build the interactive console menu in `Driver.java`, and write comprehensive Javadoc comments across the public API classes and methods.
- **How the Material Was Reviewed, Tested, and Modified:** All SQL queries, JDBC connection handling, and return types were reviewed against the `pokemon.db` schema to ensure accurate column mappings. The Java source files were compiled into `bin/`, verified against `pokemon.db` across all menu options, and processed with the `javadoc` tool to confirm that clean HTML documentation was generated in the `doc/` directory without errors or warnings.


### Side Note

I was playing around with Antigravity and created a full working GUI for my database. However it was confusing me so I put it all in the archive folder.