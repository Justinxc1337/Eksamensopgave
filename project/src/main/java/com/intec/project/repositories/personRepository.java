package com.intec.project.repositories;

import com.intec.project.entities.person;
import com.intec.project.interfaces.CRUDInterface;

public interface personRepository extends CRUDInterface<person> {

    java.sql.Connection connection = DatabaseConnectionManager.getConnection();
   
    @Override
    public boolean create(person entity) {

        String fnavn = entity.getFnavn();
        String enavn = entity.getEnavn();
        String firma_navn = entity.getFirma_navn();
        String kørerkort_nummer = entity.getKørerkort_nummer();
        LocalDateTime fødselsdato = entity.getFødselsdato();

        String query = "INSERT INTO `intecdatabase`.`person` (`fnavn`, `enavn`, `kørerkort_nummer`, `fødselsdato`) " + 
        " VALUES ('"+fnavn+"', '"+enavn+"', +'"kørerkort_nummer+"', '"+fødselsdato+"');";
        
        String query = "INSERT INTO `intecdatabase`.`firma` (`firma_navn`) " + " VALUES('"+firma_navn+"');";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, fnavn);
            stmt.setString(2, enavn);
            stmt.setInt(3, firma);
            stmt.setInt(4, lokation_navn);
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