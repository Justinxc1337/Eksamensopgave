package com.intec.project.UseCaseController.interfaces;

import java.time.LocalDateTime;

public interface CRUDInterface<T> {
    
    public boolean create(T entity);

    public void delete(LocalDateTime indtjekningstidpunkt);

}
