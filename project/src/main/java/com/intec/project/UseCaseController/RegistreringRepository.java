package com.intec.project.UseCaseController;

import com.intec.project.UseCaseController.interfaces.CRUDInterface;
import com.intec.project.entities.registrering;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;


public class RegistreringRepository implements CRUDInterface<registrering> {

    @Override
    public boolean create(registrering entity) {
        int registrering_id = entity.getRegistrering_id();
        int firma_id = entity.getFirma_id();
        int person_id = entity.getPerson_id();
        int lokation_id = entity.getLokation_id();
        LocalDateTime indtjekningstidspunkt = entity.getIndtjekningstidspunkt();

        String query = "INSERT INTO `intecdatabase`.`registrering` (`registrering_id`, `firma_id`, `person_id`, `lokation_id`, `indtjekningstidspunkt`) " +
                "VALUES (?, ?, ?, ?, ?);";

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/intecdatabase", "root", "root123");
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, registrering_id);
            stmt.setInt(2, firma_id);
            stmt.setInt(3, person_id);
            stmt.setInt(4, lokation_id);
            stmt.setObject(5, indtjekningstidspunkt);

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
    public ArrayList<registrering> getAll() {
        ArrayList<registrering> registreringer = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/intecdatabase", "root", "root123");
            String query = "SELECT * FROM registrering";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int registrering_id = rs.getInt("registrering_id");
                int firma_id = rs.getInt("firma_id");
                int person_id = rs.getInt("person_id");
                int lokation_id = rs.getInt("lokation_id");
                LocalDateTime indtjekningstidspunkt = rs.getObject("indtjekningstidspunkt", LocalDateTime.class);
                registreringer.add(new registrering(registrering_id, firma_id, person_id, lokation_id, indtjekningstidspunkt));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return registreringer;
    }

    @Override
    public void delete(LocalDateTime indtjekningstidspunkt) {

    }
}