package com.intec.project.repositories;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.intec.project.DBController.DatabaseConnectionManager;
import com.intec.project.entities.firma;
import com.intec.project.repositories.interfaces.CRUDInterface;

public interface FirmaRepository extends CRUDInterface<firma> {

    java.sql.Connection connection = DatabaseConnectionManager.getConnection();
   
    @Override
    public default boolean create(firma entity) {

        String firma_navn = entity.getFirma_navn();

        String query = "INSERT INTO `intecdatabase`.`firma` (`firma_navn`) " + 
        " VALUES ('"+firma_navn+"');";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, firma_navn);

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
