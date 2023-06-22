package com.intec.project.UseCaseController.interfaces;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface CRUDInterface<T> {

    public boolean create(T entity);
    // En metode til at oprette en ny entitet af typen T. Returnerer true, hvis oprettelsen er vellykket.

    public ArrayList<T> getAll();
    // En metode til at hente alle entiteter af typen T og returnere dem som en ArrayList.

    public void delete(LocalDateTime indtjekningstidspunkt);
    // En metode til at slette en entitet af typen T baseret på indtjekningstidspunktet.
}