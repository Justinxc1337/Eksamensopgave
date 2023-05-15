package com.intec.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class DHL {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int DHL_id;
    private int person_id;

    public DHL() {}
    

    public DHL(int DHL_id, int person_id) {
        this.DHL_id = DHL_id;
        this.person_id = person_id;
    }

    public int getDHL_id() {
        return this.DHL_id;
    }

    public void setDHL_id(int DHL_id) {
        this.DHL_id = DHL_id;
    }

    public int getPerson_id() {
        return this.person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    @Override
    public String toString() {
        return "{" +
            " DHL_id='" + getDHL_id() + "'" +
            ", person_id='" + getPerson_id() + "'" +
            "}";
    }
    
}
