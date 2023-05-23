package com.intec.project.UseCaseController.interfaces;

import java.time.LocalDateTime;

public interface CRUDInterface<T> {

    public void create(T entity);

    public void delete(LocalDateTime indtjekningstidpunkt);

}
