package com.intec.project.UseCaseController;

import com.intec.project.UseCaseController.interfaces.CRUDInterface;
import com.intec.project.entities.registrering;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class RegistreringRepository implements CRUDInterface<registrering> {


    @Override
    public boolean create(registrering entity) {
        return false;
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