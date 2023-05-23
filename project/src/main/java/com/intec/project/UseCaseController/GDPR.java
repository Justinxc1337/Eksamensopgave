package com.intec.project.UseCaseController;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.intec.project.DBController.DatabaseConnectionManager;
import com.intec.project.UseCaseController.interfaces.CRUDInterface;
import com.intec.project.entities.registrering;

public class GDPR implements CRUDInterface<registrering> {

    java.sql.Connection connection = DatabaseConnectionManager.getConnection();

    @Override
    public void delete(LocalDateTime indtjekningstidpunkt) {
        LocalDateTime fiveYearsAgo = LocalDateTime.now().minusYears(5);

        String query = "DELETE FROM `intecdatabase`.`registrering` WHERE `indtjekningstidspunkt` <= ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setObject(1, fiveYearsAgo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean create(registrering entity) {
        return false;
    }

    @Override
    public ArrayList<registrering> getAll() {
        return null;
    }

}



