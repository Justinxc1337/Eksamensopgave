package com.intec.project.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class DHL extends person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int DHL_id;
    

    public DHL() {}
    

    public DHL(int DHL_id, int person_id, String fnavn, String enavn, String kørerkort_nummer, LocalDateTime fødselsdato) {
        super(person_id, fnavn, enavn, kørerkort_nummer, fødselsdato);
        this.DHL_id = DHL_id;
    }

    public int getDHL_id() {
        return this.DHL_id;
    }

    public void setDHL_id(int DHL_id) {
        this.DHL_id = DHL_id;
    }

    @Override
    public String toString() {
        return "{" + "DHL_id= " + getDHL_id() + "\n" +
                super.toString() + "}";
    }
    
}
