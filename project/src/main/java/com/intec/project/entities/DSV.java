package com.intec.project.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class DSV extends person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int DSV_id;

    public DSV(){}

    public DSV(int DSV_id, int person_id, String fnavn, String enavn, String kørerkort_nummer, LocalDateTime fødselsdato) {
        super(person_id, fnavn, enavn, kørerkort_nummer, fødselsdato);
        this.DSV_id = DSV_id;
    }

    public int getDSV_id() {
        return DSV_id;
    }
    public void setDSV_id(int dSV_id) {
        DSV_id = dSV_id;
    }

    @Override
    public String toString() {
        return "{" + "DVS_id= " + getDSV_id() + "\n" +
                super.toString() + "}";
    }
}
