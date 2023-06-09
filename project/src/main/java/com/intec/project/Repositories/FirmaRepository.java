package com.intec.project.Repositories;

import com.intec.project.Repositories.interfaces.CRUDInterface;
import com.intec.project.Entities.firma;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;

public class FirmaRepository implements CRUDInterface<firma> {
    // Implementerer CRUDInterface med typen firma

    @Override
    public boolean create(firma entity) {
        // Opretter en ny firma entitet i databasen
        String firma_navn = entity.getFirma_navn();
        String query = "INSERT INTO `intecdatabase`.`firma` (`firma_navn`) VALUES (?);";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/intecdatabase", "root", "root123");
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, firma_navn);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<firma> getAll() {
        // Henter alle firma entiteter fra databasen
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
    public void delete(LocalDateTime indtjekningstidspunkt) {
        // ikke relevant
    }
}