package com.intec.project.UseCaseController;

import com.intec.project.DBController.DatabaseConnectionManager;
import com.intec.project.UseCaseController.interfaces.CRUDInterface;
import com.intec.project.entities.lokation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class LokationRepository implements CRUDInterface<lokation> {

    java.sql.Connection connection = DatabaseConnectionManager.getConnection();

    @Override
    public boolean create(lokation entity) {

        String lokation_navn = entity.getLokation_navn();

        String query = "INSERT INTO `intecdatabase`.`lokation` (`lokation_navn`) " +
                " VALUES ('" + lokation_navn + "');";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, lokation_navn);

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<lokation> getAll() {
        ArrayList<lokation> lokation = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM lokation AS e WHERE e.lokation_id IS NOT NULL");

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
    public void delete(LocalDateTime indtjekningstidpunkt) {

    }
}
