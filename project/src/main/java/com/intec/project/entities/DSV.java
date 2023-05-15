package com.intec.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class DSV {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int DSV_id;
    private int person_id;

    public DSV(){}

    public DSV(int DSV_id, int person_id) {
        this.DSV_id = DSV_id;
        this.person_id = person_id;
    }

    public int getDSV_id() {
        return DSV_id;
    }
    public void setDSV_id(int dSV_id) {
        DSV_id = dSV_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    @Override
    public String toString() {
        return "{" +
            " DSV_id='" + getDSV_id() + "'" +
            ", person_id='" + getPerson_id() + "'" +
            "}";
    }

}
