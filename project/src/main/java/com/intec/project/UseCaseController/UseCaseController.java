package com.intec.project.UseCaseController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.intec.project.DBController.DatabaseConnectionManager;
import com.intec.project.UseCaseController.interfaces.CRUDInterface;
import com.intec.project.entities.firma;
import com.intec.project.entities.lokation;
import com.intec.project.entities.person;
import com.intec.project.entities.registrering;

public class UseCaseController {
    
    public class opretRegistering implements CRUDInterface<registrering> {

        java.sql.Connection connection = DatabaseConnectionManager.getConnection();
       

        @Override
        public boolean create(registrering entity) {

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

                try {
                    PreparedStatement stmt1 = connection.prepareStatement(query);
        
                    stmt1.executeUpdate();
                    return true;
                }
                catch (SQLException e){
                    e.printStackTrace();
                    return false;
                }
        }


        @Override
        public void delete(LocalDateTime indtjekningstidpunkt) {
            
            throw new UnsupportedOperationException("Unimplemented method 'delete'");
        }
    }

    public class opretPerson implements CRUDInterface<person> {
        
        private Connection connection = DatabaseConnectionManager.getConnection();
    
        @Override
        public boolean create(person entity) {
            String fnavn = entity.getFnavn();
            String enavn = entity.getEnavn();
            String kørerkort_nummer = entity.getKørerkort_nummer();
            LocalDateTime fødselsdato = entity.getFødselsdato();
    
            String query = "INSERT INTO `intecdatabase`.`person` (`fnavn`, `enavn`, `kørerkort_nummer`, `fødselsdato`) "
                    + "VALUES (?, ?, ?, ?)";
    
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, fnavn);
                stmt.setString(2, enavn);
                stmt.setString(3, kørerkort_nummer);
                stmt.setObject(4, fødselsdato);
    
                stmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
    
        @Override
        public ArrayList<person> getAll() {
            ArrayList<person> persons = new ArrayList<>();
            try {
                Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("SELECT * FROM person AS e WHERE e.person_id IS NOT NULL");
    
                while (rs.next()) {
                    int person_id = rs.getInt("person_id");
                    String fnavn = rs.getString("fnavn");
                    String enavn = rs.getString("enavn");
                    String kørerkort_nummer = rs.getString("kørerkort_nummer");
                    LocalDateTime fødselsdato = LocalDateTime.parse(rs.getString("fødselsdato"));
                    persons.add(new person(person_id, fnavn, enavn, kørerkort_nummer, fødselsdato));
                }
            }

        @Override
        public void delete(LocalDateTime indtjekningstidspunkt) {
            
            throw new UnsupportedOperationException("Unimplemented method 'delete'");
        }

    }


    public class opretLokation implements CRUDInterface<lokation> {

        java.sql.Connection connection = DatabaseConnectionManager.getConnection();
       
        @Override
        public void create(lokation entity) {
    
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

        @Override
        public void delete(LocalDateTime indtjekningstidpunkt) {
            
            throw new UnsupportedOperationException("Unimplemented method 'delete'");
        }
    }

    public class opretFirma implements CRUDInterface<firma> {

        java.sql.Connection connection = DatabaseConnectionManager.getConnection();
    
        @Override
        public void create(firma entity) {
    
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

        @Override
        public void delete(LocalDateTime indtjekningstidpunkt) {
            
            throw new UnsupportedOperationException("Unimplemented method 'delete'");
        }
    }
    
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
        public void create(registrering entity) {
            
            throw new UnsupportedOperationException("Unimplemented method 'create'");
        }

        @Override
        public ArrayList<registrering> getAll() {
        
            throw new UnsupportedOperationException("Unimplemented method 'getAll'");
        }

        
    }


}
