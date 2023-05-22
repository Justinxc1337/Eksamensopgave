package com.intec.project.UseCaseController;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.intec.project.DBController.DatabaseConnectionManager;
import com.intec.project.UseCaseController.interfaces.CRUDInterface;
import com.intec.project.entities.firma;
import com.intec.project.entities.lokation;
import com.intec.project.entities.person;
import com.intec.project.entities.registrering;

public class UseCaseController {
    
    public interface Registering extends CRUDInterface<registrering> {

        java.sql.Connection connection = DatabaseConnectionManager.getConnection();
       


        default void create(registrering entity) {

            int registrering_id = entity.getRegistrering_id();
            int firma_id = entity.getFirma_id();
            int person_id = entity.getPerson_id();
            int lokation_id = entity.getLokation_id();
            LocalDateTime indtjekningstidspunkt = entity.getIndtjekningstidspunkt();

            String query = "INSERT INTO `intecdatabase`.`registrering` (`registrering_id`, `firma_id`, `person_id`, `person_id`, `lokation_id`, `indtjekningstidspunkt`) " +
            " VALUES ('"+registrering_id+"', '"+firma_id+"', '"+person_id+"', '"+lokation_id+"', '"+indtjekningstidspunkt+"');";

            try {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1, registrering_id);
                stmt.setInt(2, firma_id);
                stmt.setInt(3, person_id);
                stmt.setInt(4, lokation_id);
                stmt.setObject(5, indtjekningstidspunkt);

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
    }

    public interface Person extends CRUDInterface<person> {

        java.sql.Connection connection = DatabaseConnectionManager.getConnection();

         default void create(person entity) {
    
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
    }

    public interface Lokation extends CRUDInterface<lokation> {

        java.sql.Connection connection = DatabaseConnectionManager.getConnection();
       

        default void create(lokation entity) {
    
            String lokation_navn = entity.getLokation_navn();
    
            String query = "INSERT INTO `intecdatabase`.`lokation` (`lokation_navn`) " + 
            " VALUES ('"+lokation_navn+"');";
            
            try {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setString(1, lokation_navn);
    
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
    }

    public interface Firma extends CRUDInterface<firma> {

        java.sql.Connection connection = DatabaseConnectionManager.getConnection();
    

        default void create(firma entity) {
    
            String firma_navn = entity.getFirma_navn();
    
            if (firma_navn.equals("DHL")) {
                String query = "INSERT INTO `intecdatabase`.`firma` (`DHL`) VALUES (?);";
    
                try (PreparedStatement stmt = connection.prepareStatement(query)) {
                    stmt.setString(1, firma_navn);
    
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } else if (firma_navn.equals("GLS")) {
                String query = "INSERT INTO `intecdatabase`.`firma` (`GLS`) VALUES (?);";
    
                try (PreparedStatement stmt = connection.prepareStatement(query)) {
                    stmt.setString(1, firma_navn);
    
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } else if (firma_navn.equals("DSV")) {
                String query = "INSERT INTO `intecdatabase`.`firma` (`DSV`) VALUES (?);";
    
                try (PreparedStatement stmt = connection.prepareStatement(query)) {
                    stmt.setString(1, firma_navn);
    
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
            } else {
                String columnName = "column_" + firma_navn.toLowerCase().replaceAll("[^a-z0-9_]", "");
                String query = "ALTER TABLE `intecdatabase`.`firma` ADD COLUMN `" + columnName + "` VARCHAR(45);";
    
                try (PreparedStatement stmt = connection.prepareStatement(query)) {
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public interface GDPR extends CRUDInterface<registrering> {

        java.sql.Connection connection = DatabaseConnectionManager.getConnection();

        default void delete(LocalDateTime indtjekningstidpunkt) {
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
    }

}
