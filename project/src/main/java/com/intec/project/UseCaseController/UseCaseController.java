package com.intec.project.UseCaseController;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.intec.project.DBController.DatabaseConnectionManager;
import com.intec.project.UseCaseController.interfaces.CRUDInterface;
import com.intec.project.entities.firma;
import com.intec.project.entities.lokation;
import com.intec.project.entities.person;
import com.intec.project.entities.registering;

public class UseCaseController {
    
    public interface Registering extends CRUDInterface<registering> {

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

    public interface Person extends CRUDInterface<person> {

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

    public interface Lokation extends CRUDInterface<lokation> {

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

    public interface Firma extends CRUDInterface<firma> {

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

    
}