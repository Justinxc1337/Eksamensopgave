package com.intec.project.UseCaseController;

import com.intec.project.DBController.DatabaseConnectionManager;
import com.intec.project.UseCaseController.interfaces.CRUDInterface;
import com.intec.project.entities.firma;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class FirmaRepository implements CRUDInterface<firma> {

    java.sql.Connection connection = DatabaseConnectionManager.getConnection();

    @Override
    public boolean create(firma entity) {

        String firma_navn = entity.getFirma_navn();

        if (firma_navn.equals("DHL")) {
            String query = "INSERT INTO `intecdatabase`.`firma` (`DHL`) VALUES (?);";

            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, firma_navn);

                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (firma_navn.equals("GLS")) {
            String query = "INSERT INTO `intecdatabase`.`firma` (`GLS`) VALUES (?);";

            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, firma_navn);

                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (firma_navn.equals("DSV")) {
            String query = "INSERT INTO `intecdatabase`.`firma` (`DSV`) VALUES (?);";

            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, firma_navn);

                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            String columnName = "column_" + firma_navn.toLowerCase().replaceAll("[^a-z0-9_]", "");
            String query = "ALTER TABLE `intecdatabase`.`firma` ADD COLUMN `" + columnName + "` VARCHAR(45);";

            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public ArrayList<firma> getAll() {
        ArrayList<firma> firma = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM firma AS e WHERE e.firma_id IS NOT NULL");

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
