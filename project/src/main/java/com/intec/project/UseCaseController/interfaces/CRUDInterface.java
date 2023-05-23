package com.intec.project.UseCaseController.interfaces;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface CRUDInterface<T> {

    public boolean create(T entity);

    public ArrayList<T> getAll();

    public void delete(LocalDateTime indtjekningstidspunkt);

}
