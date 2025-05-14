package org.example.lab8;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {
    public int findOrCreate(Connection con, String name, String code, int continentId) throws SQLException {
        Integer id = findByName(con, name);
        if (id != null) return id;

        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO countries (name, code, continent_id) VALUES (?, ?, ?) RETURNING id")) {
            pstmt.setString(1, name);
            pstmt.setString(2, code);
            pstmt.setInt(3, continentId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getInt(1);
        }
        throw new SQLException("Failed to insert/find country: " + name);
    }

    public Integer findByName(Connection con, String name) throws SQLException {
        try (PreparedStatement stmt = con.prepareStatement(
                "SELECT id FROM countries WHERE name = ?")) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public List<String> findAllByContinent(Connection con, int continentId) throws SQLException {
        List<String> countries = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(
                "SELECT name FROM countries WHERE continent_id = ?")) {
            stmt.setInt(1, continentId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                countries.add(rs.getString("name"));
            }
        }
        return countries;
    }
}
