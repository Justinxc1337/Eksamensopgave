package com.intec.project.UseCaseController;


import com.intec.project.UseCaseController.interfaces.CRUDInterface;
import com.intec.project.entities.firma;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;

public class FirmaRepository implements CRUDInterface<firma> {

    @Override
    public boolean create(firma entity) {

        String firma_navn = entity.getFirma_navn();

        if (firma_navn.equals("DHL")) {
            String query = "INSERT INTO `intecdatabase`.`firma` (`DHL`) VALUES (?);";

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/intecdatabase", "root", "root123");
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setString(1, firma_navn);

                try {
                    stmt.executeUpdate();
                    return true;
                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } else if (firma_navn.equals("GLS")) {
            String query = "INSERT INTO `intecdatabase`.`firma` (`GLS`) VALUES (?);";

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/intecdatabase", "root", "root123");
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setString(1, firma_navn);

                try {
                    stmt.executeUpdate();
                    return true;
                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } else if (firma_navn.equals("DSV")) {
            String query = "INSERT INTO `intecdatabase`.`firma` (`DSV`) VALUES (?);";

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/intecdatabase", "root", "root123");
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setString(1, firma_navn);

                try {
                    stmt.executeUpdate();
                    return true;
                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } else {
            String columnName = "column_" + firma_navn.toLowerCase().replaceAll("[^a-z0-9_]", "");
            String query = "ALTER TABLE `intecdatabase`.`firma` ADD COLUMN `" + columnName + "` VARCHAR(45);";

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/intecdatabase", "root", "root123");
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.executeUpdate();
                try {
                    stmt.executeUpdate();
                    return true;
                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public ArrayList<firma> getAll() {
        ArrayList<firma> firma = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/intecdatabase", "root", "root123");
            String query = "SELECT * FROM firma";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int firma_id = rs.getInt("firma_id");
                String firma_navn = rs.getString("firma_navn");
                firma.add(new firma(firma_id, firma_navn));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return firma;
    }

    @Override
    public void delete(LocalDateTime indtjekningstidpunkt) {

    }
}