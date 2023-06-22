package com.intec.project.UseCaseController;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;

import com.intec.project.UseCaseController.interfaces.CRUDInterface;
import com.intec.project.entities.registrering;

public class GDPR implements CRUDInterface<registrering> {
    // Implementerer CRUDInterface med typen registrering

    @Override
    public void delete(LocalDateTime indtjekningstidspunkt) {
        // Sletter registreringer, der er ældre end 5 år baseret på indtjekningstidspunktet
        LocalDateTime fiveYearsAgo = LocalDateTime.now().minusYears(5);

        String query = "DELETE FROM `intecdatabase`.`registrering` WHERE `indtjekningstidspunkt` <= ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/intecdatabase", "root", "root123");
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setObject(1, fiveYearsAgo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean create(registrering entity) {
        // ikke relevant
        return false;
    }

    @Override
    public ArrayList<registrering> getAll() {
        // ikke relevant
        return null;
    }
}



