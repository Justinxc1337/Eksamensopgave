package com.intec.project.UseCaseController.interfaces;

import java.time.LocalDateTime;

public interface CRUDInterface<T> {

    void create(T entity);

    void delete(LocalDateTime indtjekningstidpunkt);

}
