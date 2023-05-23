package com.intec.project.UseCaseController;

import com.intec.project.DBController.DatabaseConnectionManager;
import com.intec.project.UseCaseController.interfaces.CRUDInterface;
import com.intec.project.entities.person;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PersonRepository implements CRUDInterface<person> {

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
        ArrayList<person> person = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM person AS e WHERE e.person_id IS NOT NULL");

            while (rs.next()) {
                int person_id = rs.getInt("person_id");
                String fnavn = rs.getString("fnavn");
                String enavn = rs.getString("enavn");
                String kørerkort_nummer = rs.getString("kørerkort_nummer");
                LocalDateTime fødselsdato = LocalDateTime.parse(rs.getString("fødselsdato"));
                person.add(new person(person_id, fnavn, enavn, kørerkort_nummer, fødselsdato));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }


    @Override
    public void delete(LocalDateTime indtjekningstidspunkt) {

    }

}
