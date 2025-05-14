package org.example.lab8;

import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        try (Connection con = Database.getConnection()) {
            con.setAutoCommit(false);

            var continentDAO = new ContinentDAO();
            int europeId = continentDAO.findOrCreateByName(con, "Europe");

            var countries = new CountryDAO();
            countries.findOrCreate(con, "Romania123", "RO", europeId);
            countries.findOrCreate(con, "Ukraine", "UA", europeId);

            con.commit();

            var importer = new CityImporter();
            importer.importFromCSV("src/main/resources/concap.csv");

            con.commit();

            System.out.println("countries in Europe:");
            countries.findAllByContinent(con, europeId).forEach(System.out::println);

            System.out.println("\ndistance between Bucharest and Kyiv:");
            var cityDAO = new CityDAO();
            var bucharest = cityDAO.findByName("Bucharest");
            var kyiv = cityDAO.findByName("Kyiv");

            if (bucharest != null && kyiv != null) {
                double distance = DistUtils.haversine(
                        bucharest.getLatitude(), bucharest.getLongitude(),
                        kyiv.getLatitude(), kyiv.getLongitude()
                );
                System.out.printf("distance: %f km", distance);
            }

        } catch (SQLException e) {
            System.err.println("database error: " + e.getMessage());
        }
        Database.closeConnection();
    }
}
