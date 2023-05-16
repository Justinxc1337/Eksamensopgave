package com.intec.project.repositories;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.intec.project.DBController.DatabaseConnectionManager;
import com.intec.project.entities.registering;
import com.intec.project.repositories.interfaces.CRUDInterface;

public interface RegisteringRepository extends CRUDInterface<registering> {

    java.sql.Connection connection = DatabaseConnectionManager.getConnection();
   
    @Override
    public default boolean create(registering entity) {

        int registering_id = entity.getRegistering_id();
        int firma_id = entity.getFirma_id();
        int person_id = entity.getPerson_id();
        int lokation_id = entity.getLokation_id();
        LocalDateTime indtjekningstidspunkt = entity.getIndtjekningstidspunkt();

        String query = "INSERT INTO `intecdatabase`.`registering` (`registering_id`, `firma_id`, `person_id`, `person_id`, `lokation_id`, `indtjekningstidspunkt`) " + 
        " VALUES ('"+registering_id+"', '"+firma_id+"', '"+person_id+"', '"+lokation_id+"', '"+indtjekningstidspunkt+"');";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, registering_id);
            stmt.setInt(2, firma_id);
            stmt.setInt(3, person_id);
            stmt.setInt(4, lokation_id);
            stmt.setObject(5, indtjekningstidspunkt);

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