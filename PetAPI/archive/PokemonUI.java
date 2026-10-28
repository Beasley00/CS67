/*
 * PokemonUI.java
 * A graphical user interface (GUI) to search, filter, and explore
 * Generation 1 through 3 Pokemon stored in pokemon.db.
 */

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PokemonUI extends JFrame {

    private static final String DB_URL = "jdbc:sqlite:pokemon.db";

    // Filter controls
    private JTextField searchField;
    private JComboBox<String> genCombo;
    private JComboBox<String> typeCombo;
    private JCheckBox legendaryCheckBox;
    private JButton resetButton;

    // Table
    private JTable pokemonTable;
    private DefaultTableModel tableModel;
    private JLabel statusLabel;

    // Detail Panel Components
    private JLabel detailIdLabel;
    private JLabel detailNameLabel;
    private JLabel detailSpeciesLabel;
    private JPanel typeBadgePanel;
    private JLabel detailHeightLabel;
    private JLabel detailWeightLabel;
    private JLabel detailTotalLabel;
    private JLabel legendaryBadge;

    private JProgressBar hpBar;
    private JProgressBar atkBar;
    private JProgressBar defBar;
    private JProgressBar spaBar;
    private JProgressBar spdBar;
    private JProgressBar speBar;

    // Cache of currently loaded Pokemon
    private final List<PokemonRecord> currentPokemonList = new ArrayList<>();

    // Pokemon type colors
    private static final Map<String, Color> TYPE_COLORS = new HashMap<>();
    static {
        TYPE_COLORS.put("Normal", new Color(0x9F, 0xA1, 0x9F));
        TYPE_COLORS.put("Fire", new Color(0xE6, 0x28, 0x29));
        TYPE_COLORS.put("Water", new Color(0x29, 0x80, 0xEF));
        TYPE_COLORS.put("Grass", new Color(0x3F, 0xA1, 0x29));
        TYPE_COLORS.put("Electric", new Color(0xDA, 0xA5, 0x20));
        TYPE_COLORS.put("Ice", new Color(0x3D, 0xCE, 0xF3));
        TYPE_COLORS.put("Fighting", new Color(0xD0, 0x60, 0x00));
        TYPE_COLORS.put("Poison", new Color(0x91, 0x41, 0xCB));
        TYPE_COLORS.put("Ground", new Color(0x91, 0x51, 0x21));
        TYPE_COLORS.put("Flying", new Color(0x60, 0x90, 0xDF));
        TYPE_COLORS.put("Psychic", new Color(0xEF, 0x41, 0x79));
        TYPE_COLORS.put("Bug", new Color(0x7C, 0x99, 0x1A));
        TYPE_COLORS.put("Rock", new Color(0xAF, 0xA9, 0x81));
        TYPE_COLORS.put("Ghost", new Color(0x70, 0x41, 0x70));
        TYPE_COLORS.put("Dragon", new Color(0x50, 0x60, 0xE1));
        TYPE_COLORS.put("Steel", new Color(0x60, 0xA1, 0xB8));
        TYPE_COLORS.put("Fairy", new Color(0xEF, 0x70, 0xEF));
    }

    public PokemonUI() {
        super("Pokemon Pokedex Browser (Generations 1 - 3)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 720);
        setMinimumSize(new Dimension(850, 550));
        setLocationRelativeTo(null);

        // Main layout
        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBorder(new EmptyBorder(12, 12, 12, 12));
        setContentPane(contentPane);

        // 1. Top Filter Panel
        contentPane.add(createFilterPanel(), BorderLayout.NORTH);

        // 2. Center: Table (left) + Detail Card (right)
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, createTablePanel(), createDetailPanel());
        splitPane.setResizeWeight(0.68);
        splitPane.setContinuousLayout(true);
        splitPane.setBorder(null);
        contentPane.add(splitPane, BorderLayout.CENTER);

        // 3. Bottom: Status Bar
        statusLabel = new JLabel("Loading Pokemon...");
        statusLabel.setBorder(new EmptyBorder(4, 4, 2, 4));
        statusLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        contentPane.add(statusLabel, BorderLayout.SOUTH);

        // Initial data load
        applyFilters();
    }

    private JPanel createFilterPanel() {
        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 8));
        filterPanel.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(210, 215, 220), 1, true),
                new EmptyBorder(6, 10, 6, 10)
        ));

        // Search input
        filterPanel.add(new JLabel("Search:"));
        searchField = new JTextField(12);
        searchField.setToolTipText("Search by Pokemon name or Pokedex number");
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { applyFilters(); }
            public void removeUpdate(DocumentEvent e) { applyFilters(); }
            public void changedUpdate(DocumentEvent e) { applyFilters(); }
        });
        filterPanel.add(searchField);

        // Generation dropdown
        filterPanel.add(new JLabel("Gen:"));
        genCombo = new JComboBox<>(new String[]{"All Generations", "Gen 1 (Kanto)", "Gen 2 (Johto)", "Gen 3 (Hoenn)"});
        genCombo.addActionListener(e -> applyFilters());
        filterPanel.add(genCombo);

        // Type dropdown
        filterPanel.add(new JLabel("Type:"));
        typeCombo = new JComboBox<>(new String[]{
                "All Types", "Bug", "Dragon", "Electric", "Fairy", "Fighting",
                "Fire", "Flying", "Ghost", "Grass", "Ground", "Ice",
                "Normal", "Poison", "Psychic", "Rock", "Steel", "Water"
        });
        typeCombo.addActionListener(e -> applyFilters());
        filterPanel.add(typeCombo);

        // Legendary checkbox
        legendaryCheckBox = new JCheckBox("Legendary Only");
        legendaryCheckBox.addActionListener(e -> applyFilters());
        filterPanel.add(legendaryCheckBox);

        // Reset button
        resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            searchField.setText("");
            genCombo.setSelectedIndex(0);
            typeCombo.setSelectedIndex(0);
            legendaryCheckBox.setSelected(false);
            applyFilters();
        });
        filterPanel.add(resetButton);

        return filterPanel;
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));

        String[] columns = {"#", "Name", "Gen", "Type 1", "Type 2", "Total", "HP", "Atk", "Def", "Sp.Atk", "Sp.Def", "Speed"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // read-only
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0 || columnIndex == 2 || columnIndex >= 5) {
                    return Integer.class;
                }
                return String.class;
            }
        };

        pokemonTable = new JTable(tableModel);
        pokemonTable.setRowHeight(24);
        pokemonTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        pokemonTable.setAutoCreateRowSorter(true);
        pokemonTable.getTableHeader().setReorderingAllowed(false);

        // Column widths
        pokemonTable.getColumnModel().getColumn(0).setPreferredWidth(45);  // #
        pokemonTable.getColumnModel().getColumn(1).setPreferredWidth(110); // Name
        pokemonTable.getColumnModel().getColumn(2).setPreferredWidth(45);  // Gen
        pokemonTable.getColumnModel().getColumn(3).setPreferredWidth(75);  // Type 1
        pokemonTable.getColumnModel().getColumn(4).setPreferredWidth(75);  // Type 2
        pokemonTable.getColumnModel().getColumn(5).setPreferredWidth(55);  // Total
        for (int i = 6; i <= 11; i++) {
            pokemonTable.getColumnModel().getColumn(i).setPreferredWidth(48); // Stats
        }

        // Center-align numeric columns
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        pokemonTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        pokemonTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        for (int i = 5; i <= 11; i++) {
            pokemonTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Row selection listener to update detail panel
        pokemonTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int viewRow = pokemonTable.getSelectedRow();
                if (viewRow >= 0) {
                    int modelRow = pokemonTable.convertRowIndexToModel(viewRow);
                    if (modelRow >= 0 && modelRow < currentPokemonList.size()) {
                        displayPokemonDetails(currentPokemonList.get(modelRow));
                    }
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(pokemonTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createDetailPanel() {
        JPanel container = new JPanel(new BorderLayout(5, 5));
        container.setBorder(BorderFactory.createCompoundBorder(
                new TitledBorder("Pokemon Details"),
                new EmptyBorder(8, 10, 8, 10)
        ));
        container.setPreferredSize(new Dimension(340, 500));

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        // Header: #001 Bulbasaur
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 2));
        detailIdLabel = new JLabel("#000");
        detailIdLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        detailIdLabel.setForeground(Color.GRAY);

        detailNameLabel = new JLabel("Select a Pokemon");
        detailNameLabel.setFont(new Font("SansSerif", Font.BOLD, 20));

        legendaryBadge = new JLabel("LEGENDARY");
        legendaryBadge.setFont(new Font("SansSerif", Font.BOLD, 11));
        legendaryBadge.setOpaque(true);
        legendaryBadge.setBackground(new Color(255, 215, 0));
        legendaryBadge.setForeground(new Color(90, 60, 0));
        legendaryBadge.setBorder(new EmptyBorder(2, 6, 2, 6));
        legendaryBadge.setVisible(false);

        headerPanel.add(detailIdLabel);
        headerPanel.add(detailNameLabel);
        headerPanel.add(legendaryBadge);
        content.add(headerPanel);

        // Species subtitle
        detailSpeciesLabel = new JLabel(" ");
        detailSpeciesLabel.setFont(new Font("SansSerif", Font.ITALIC, 13));
        detailSpeciesLabel.setForeground(new Color(100, 100, 100));
        detailSpeciesLabel.setBorder(new EmptyBorder(0, 8, 6, 0));
        content.add(detailSpeciesLabel);

        // Type Badges Panel
        typeBadgePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 2));
        typeBadgePanel.setBorder(new EmptyBorder(2, 4, 8, 0));
        content.add(typeBadgePanel);

        // Height & Weight Panel
        JPanel physicalPanel = new JPanel(new GridLayout(1, 2, 8, 2));
        physicalPanel.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(230, 230, 230), 1, true),
                new EmptyBorder(6, 10, 6, 10)
        ));
        detailHeightLabel = new JLabel("Height: --");
        detailWeightLabel = new JLabel("Weight: --");
        physicalPanel.add(detailHeightLabel);
        physicalPanel.add(detailWeightLabel);
        content.add(physicalPanel);

        content.add(Box.createVerticalStrut(12));

        // Base Stats Header & Bars
        JLabel statsHeader = new JLabel("Base Stats");
        statsHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
        statsHeader.setBorder(new EmptyBorder(4, 4, 6, 0));
        content.add(statsHeader);

        JPanel statsGrid = new JPanel(new GridLayout(6, 2, 8, 6));
        hpBar = createStatBar(statsGrid, "HP:");
        atkBar = createStatBar(statsGrid, "Attack:");
        defBar = createStatBar(statsGrid, "Defense:");
        spaBar = createStatBar(statsGrid, "Sp. Atk:");
        spdBar = createStatBar(statsGrid, "Sp. Def:");
        speBar = createStatBar(statsGrid, "Speed:");
        content.add(statsGrid);

        content.add(Box.createVerticalStrut(12));

        // Total stat label
        detailTotalLabel = new JLabel("Total Base Stats: --");
        detailTotalLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        detailTotalLabel.setForeground(new Color(40, 80, 150));
        detailTotalLabel.setBorder(new EmptyBorder(4, 4, 4, 0));
        content.add(detailTotalLabel);

        content.add(Box.createVerticalGlue());

        JScrollPane scrollPane = new JScrollPane(content);
        scrollPane.setBorder(null);
        container.add(scrollPane, BorderLayout.CENTER);

        return container;
    }

    private JProgressBar createStatBar(JPanel parent, String labelText) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("SansSerif", Font.PLAIN, 12));
        parent.add(label);

        JProgressBar bar = new JProgressBar(0, 255);
        bar.setStringPainted(true);
        bar.setString("0");
        bar.setForeground(new Color(80, 160, 230));
        parent.add(bar);
        return bar;
    }

    private void applyFilters() {
        String search = searchField.getText().trim();
        int genIndex = genCombo.getSelectedIndex(); // 0: All, 1: Gen 1, 2: Gen 2, 3: Gen 3
        String selectedType = (String) typeCombo.getSelectedItem();
        boolean legendaryOnly = legendaryCheckBox.isSelected();

        // Build SQL
        StringBuilder sql = new StringBuilder("SELECT * FROM Pokemon WHERE 1=1 ");
        List<Object> params = new ArrayList<>();

        if (genIndex > 0) {
            sql.append("AND generation = ? ");
            params.add(genIndex);
        }

        if (selectedType != null && !selectedType.equals("All Types")) {
            sql.append("AND (type1 = ? OR type2 = ?) ");
            params.add(selectedType);
            params.add(selectedType);
        }

        if (legendaryOnly) {
            sql.append("AND is_legendary = 1 ");
        }

        if (!search.isEmpty()) {
            try {
                int idVal = Integer.parseInt(search);
                sql.append("AND (id = ? OR name LIKE ?) ");
                params.add(idVal);
                params.add("%" + search + "%");
            } catch (NumberFormatException e) {
                sql.append("AND name LIKE ? ");
                params.add("%" + search + "%");
            }
        }

        sql.append("ORDER BY id ASC");

        // Execute query
        currentPokemonList.clear();
        tableModel.setRowCount(0);

        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = connection.prepareStatement(sql.toString())) {

            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    PokemonRecord p = new PokemonRecord();
                    p.id = rs.getInt("id");
                    p.name = rs.getString("name");
                    p.generation = rs.getInt("generation");
                    p.type1 = rs.getString("type1");
                    p.type2 = rs.getString("type2");
                    p.species = rs.getString("species");
                    p.hp = rs.getInt("hp");
                    p.attack = rs.getInt("attack");
                    p.defense = rs.getInt("defense");
                    p.spAttack = rs.getInt("sp_attack");
                    p.spDefense = rs.getInt("sp_defense");
                    p.speed = rs.getInt("speed");
                    p.total = rs.getInt("total");
                    p.heightM = rs.getDouble("height_m");
                    p.weightKg = rs.getDouble("weight_kg");
                    p.isLegendary = rs.getBoolean("is_legendary");

                    currentPokemonList.add(p);

                    tableModel.addRow(new Object[]{
                            p.id,
                            p.name,
                            p.generation,
                            p.type1,
                            p.type2 != null ? p.type2 : "-",
                            p.total,
                            p.hp,
                            p.attack,
                            p.defense,
                            p.spAttack,
                            p.spDefense,
                            p.speed
                    });
                }
            }

            statusLabel.setText(String.format("Showing %d of 386 Pokemon", currentPokemonList.size()));

            // Select first row if available
            if (!currentPokemonList.isEmpty()) {
                pokemonTable.setRowSelectionInterval(0, 0);
            } else {
                clearDetails();
            }

        } catch (SQLException e) {
            statusLabel.setText("Database error: " + e.getMessage());
        }
    }

    private void displayPokemonDetails(PokemonRecord p) {
        detailIdLabel.setText(String.format("#%03d", p.id));
        detailNameLabel.setText(p.name);
        detailSpeciesLabel.setText(p.species != null ? p.species : "");
        legendaryBadge.setVisible(p.isLegendary);

        // Type badges
        typeBadgePanel.removeAll();
        typeBadgePanel.add(createTypeBadge(p.type1));
        if (p.type2 != null && !p.type2.isBlank()) {
            typeBadgePanel.add(createTypeBadge(p.type2));
        }
        typeBadgePanel.revalidate();
        typeBadgePanel.repaint();

        // Dimensions
        detailHeightLabel.setText(String.format("Height: %.1f m", p.heightM));
        detailWeightLabel.setText(String.format("Weight: %.1f kg", p.weightKg));

        // Stats bars
        updateStatBar(hpBar, p.hp);
        updateStatBar(atkBar, p.attack);
        updateStatBar(defBar, p.defense);
        updateStatBar(spaBar, p.spAttack);
        updateStatBar(spdBar, p.spDefense);
        updateStatBar(speBar, p.speed);

        detailTotalLabel.setText("Total Base Stats: " + p.total);
    }

    private JLabel createTypeBadge(String typeName) {
        JLabel badge = new JLabel(typeName);
        badge.setFont(new Font("SansSerif", Font.BOLD, 12));
        badge.setForeground(Color.WHITE);
        badge.setOpaque(true);
        Color bg = TYPE_COLORS.getOrDefault(typeName, new Color(120, 120, 120));
        badge.setBackground(bg);
        badge.setBorder(new EmptyBorder(3, 8, 3, 8));
        return badge;
    }

    private void updateStatBar(JProgressBar bar, int value) {
        bar.setValue(value);
        bar.setString(String.valueOf(value));

        // Color code based on stat strength
        if (value >= 130) {
            bar.setForeground(new Color(0, 180, 120));    // Great (Green)
        } else if (value >= 90) {
            bar.setForeground(new Color(70, 160, 230));   // Good (Blue)
        } else if (value >= 60) {
            bar.setForeground(new Color(230, 160, 40));   // Average (Orange)
        } else {
            bar.setForeground(new Color(220, 70, 70));    // Low (Red)
        }
    }

    private void clearDetails() {
        detailIdLabel.setText("#---");
        detailNameLabel.setText("No Pokemon match");
        detailSpeciesLabel.setText(" ");
        legendaryBadge.setVisible(false);
        typeBadgePanel.removeAll();
        typeBadgePanel.revalidate();
        typeBadgePanel.repaint();
        detailHeightLabel.setText("Height: --");
        detailWeightLabel.setText("Weight: --");
        updateStatBar(hpBar, 0);
        updateStatBar(atkBar, 0);
        updateStatBar(defBar, 0);
        updateStatBar(spaBar, 0);
        updateStatBar(spdBar, 0);
        updateStatBar(speBar, 0);
        detailTotalLabel.setText("Total Base Stats: --");
    }

    static class PokemonRecord {
        int id;
        String name;
        int generation;
        String type1;
        String type2;
        String species;
        int hp;
        int attack;
        int defense;
        int spAttack;
        int spDefense;
        int speed;
        int total;
        double heightM;
        double weightKg;
        boolean isLegendary;
    }

    public static void main(String[] args) {
        // Set system look and feel for native UI controls
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        SwingUtilities.invokeLater(() -> {
            PokemonUI ui = new PokemonUI();
            ui.setVisible(true);
        });
    }
}
