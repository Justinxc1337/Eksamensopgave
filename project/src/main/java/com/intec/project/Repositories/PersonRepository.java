package com.intec.project.Repositories;
import com.intec.project.Repositories.interfaces.CRUDInterface;
import com.intec.project.Entities.person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;

public class PersonRepository implements CRUDInterface<person> {
    // Implementerer CRUDInterface med typen person

    @Override
    public boolean create(person entity) {
        // Opretter en ny person i databasen
        String fnavn = entity.getFnavn();
        String enavn = entity.getEnavn();
        String kørerkort_nummer = entity.getKørerkort_nummer();
        LocalDate fødselsdato = entity.getFødselsdato();

        // Validerer felterne
        if (fnavn.isEmpty()) {
            return false;
        }
        if (enavn.isEmpty()) {
            return false;
        }
        if (kørerkort_nummer.isEmpty()) {
            return false;
        }

        String query = "INSERT INTO `intecdatabase`.`person` (`fnavn`, `enavn`, `kørerkort_nummer`, `fødselsdato`) "
                + "VALUES (?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/intecdatabase", "root", "root123");
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, fnavn);
            stmt.setString(2, enavn);
            stmt.setString(3, kørerkort_nummer);
            stmt.setObject(4, fødselsdato);

            try {
                stmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<person> getAll() {
        // Henter alle personer fra databasen og returnerer dem som en liste
        ArrayList<person> person = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/intecdatabase", "root", "root123");
            String query = "SELECT * FROM person";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int person_id = rs.getInt("person_id");
                String fnavn = rs.getString("fnavn");
                String enavn = rs.getString("enavn");
                String kørerkort_nummer = rs.getString("kørerkort_nummer");
                LocalDate fødselsdato = rs.getObject("fødselsdato", LocalDate.class);
                person.add(new person(person_id, fnavn, enavn, kørerkort_nummer, fødselsdato));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    @Override
    public void delete(LocalDateTime indtjekningstidspunkt) {
        // ikke relevant
    }
}
