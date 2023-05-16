package com.intec.project.repositories;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.intec.project.DBController.DatabaseConnectionManager;
import com.intec.project.entities.lokation;
import com.intec.project.repositories.interfaces.CRUDInterface;

public interface LokationRepository extends CRUDInterface<lokation> {

    java.sql.Connection connection = DatabaseConnectionManager.getConnection();
   
    @Override
    public default boolean create(lokation entity) {

        String lokation_navn = entity.getLokation_navn();

        String query = "INSERT INTO `intecdatabase`.`lokation` (`lokation_navn`) " + 
        " VALUES ('"+lokation_navn+"');";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, lokation_navn);

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
