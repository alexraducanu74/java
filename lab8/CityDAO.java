package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDAO {
    public void create(Connection con, String name, int countryId, boolean isCapital, double lat, double lon) throws SQLException {
        String sql = "INSERT INTO cities (name, country_id, is_capital, latitude, longitude) VALUES (?, ?, ?, ?, ?) ON CONFLICT DO NOTHING";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, countryId);
            stmt.setBoolean(3, isCapital);
            stmt.setDouble(4, lat);
            stmt.setDouble(5, lon);
            stmt.executeUpdate();
        }
    }
    public City findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM cities WHERE name = ?")) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new City(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("country_id"),
                        rs.getBoolean("is_capital"),
                        rs.getDouble("latitude"),
                        rs.getDouble("longitude")
                );
            }
        }
        return null;
    }
}
