package com.intec.project.Repositories;

import com.intec.project.Repositories.interfaces.CRUDInterface;
import com.intec.project.Entities.registrering;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class RegistreringRepository implements CRUDInterface<registrering> {
    // Implementerer CRUDInterface med typen registrering

    @Override
    public boolean create(registrering entity) {
        // Oprettelse af registrering er ikke implementeret og returnerer altid false
        return false;
    }

    @Override
    public ArrayList<registrering> getAll() {
        // Henter alle registreringer fra databasen og returnerer dem som en liste
        ArrayList<registrering> registreringer = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/intecdatabase", "root", "root123");
            String query = "SELECT r.registrering_id, r.firma_id, r.person_id, r.lokation_id " +
                    "FROM registrering r " +
                    "INNER JOIN firma f ON r.firma_id = f.firma_id " +
                    "INNER JOIN person p ON r.person_id = p.person_id " +
                    "INNER JOIN lokation l ON r.lokation_id = l.lokation_id";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int registrering_id = rs.getInt("registrering_id");
                int firma_id = rs.getInt("firma_id");
                int person_id = rs.getInt("person_id");
                int lokation_id = rs.getInt("lokation_id");
                registreringer.add(new registrering(registrering_id, firma_id, person_id, lokation_id));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return registreringer;
    }

    @Override
    public void delete(LocalDateTime indtjekningstidspunkt) {
        // ikke relevant
    }
}