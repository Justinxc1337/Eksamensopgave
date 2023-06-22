package com.intec.project.UseCaseController;

import com.intec.project.UseCaseController.interfaces.CRUDInterface;
import com.intec.project.entities.lokation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;

public class LokationRepository implements CRUDInterface<lokation> {
    // Implementerer CRUDInterface med typen lokation

    @Override
    public boolean create(lokation entity) {
        // Opretter en ny lokation i databasen
        if (entity == null || entity.getLokation_navn() == null) {
            return false;
        }

        String lokation_navn = entity.getLokation_navn();

        String query = "INSERT INTO `intecdatabase`.`lokation` (`lokation_navn`) " +
                "VALUES (?);";

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/intecdatabase", "root", "root123");
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, lokation_navn);

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

    @Override
    public ArrayList<lokation> getAll() {
        // Henter alle lokationer fra databasen og returnerer dem som en liste
        ArrayList<lokation> lokation = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/intecdatabase", "root", "root123");
            String query = "SELECT * FROM lokation";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int lokation_id = rs.getInt("lokation_id");
                String lokation_navn = rs.getString("lokation_navn");
                lokation.add(new lokation(lokation_id, lokation_navn));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lokation;
    }
    
    @Override
    public void delete(LocalDateTime indtjekningstidspunkt) {
        // ikke relevant
    }
}