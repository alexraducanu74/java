package org.example.lab8;

import java.sql.*;

public class ContinentDAO {
    public int findOrCreateByName(Connection con, String name) throws SQLException {
        Integer id = findByName(con, name);
        if (id != null) return id;

        try (PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO continents (name) VALUES (?) RETURNING id")) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getInt(1);
        }
        throw new SQLException("Failed to insert/find continent: " + name);
    }

    public Integer findByName(Connection con, String name) throws SQLException {
        try (PreparedStatement stmt = con.prepareStatement(
                "SELECT id FROM continents WHERE name = ?")) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getInt("id");
        }
        return null;
    }
}
