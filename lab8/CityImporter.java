package org.example;


import java.io.*;
import java.sql.*;

public class CityImporter {
    public void importFromCSV(String filePath) {
        try (
                Connection con = Database.getConnection();
                BufferedReader reader = new BufferedReader(new FileReader(filePath))
        ) {
            con.setAutoCommit(false);
            String line;
            reader.readLine(); // skip header

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length != 6) continue;

                String country = tokens[0].trim();
                String capital = tokens[1].trim();
                double lat = Double.parseDouble(tokens[2]);
                double lon = Double.parseDouble(tokens[3]);
                String code = tokens[4].trim();
                String continent = tokens[5].trim();

                insertCity(con, country, capital, lat, lon, code, continent);
            }

            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertCity(Connection con, String country, String capital, double lat, double lon, String code, String continent) throws SQLException {
        ContinentDAO continentDAO = new ContinentDAO();
        CountryDAO countryDAO = new CountryDAO();
        CityDAO cityDAO = new CityDAO();

        int continentId = continentDAO.findOrCreateByName(con, continent);
        int countryId = countryDAO.findOrCreate(con, country, code, continentId);
        cityDAO.create(con, capital, countryId, true, lat, lon);
    }
}
