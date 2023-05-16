package com.intec.project.repositories;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.intec.project.DBController.DatabaseConnectionManager;
import com.intec.project.entities.person;
import com.intec.project.repositories.interfaces.CRUDInterface;

public interface PersonRepository extends CRUDInterface<person> {

    java.sql.Connection connection = DatabaseConnectionManager.getConnection();
   
    @Override
    public default boolean create(person entity) {

        String fnavn = entity.getFnavn();
        String enavn = entity.getEnavn();
        String kørerkort_nummer = entity.getKørerkort_nummer();
        LocalDateTime fødselsdato = entity.getFødselsdato();

        String query = "INSERT INTO `intecdatabase`.`person` (`fnavn`, `enavn`, `kørerkort_nummer`, `fødselsdato`) " + 
        " VALUES ('"+fnavn+"', '"+enavn+"', '"+kørerkort_nummer+"', '"+fødselsdato+"');";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, fnavn);
            stmt.setString(2, enavn);
            stmt.setString(3, kørerkort_nummer);
            stmt.setObject(4, fødselsdato);

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
