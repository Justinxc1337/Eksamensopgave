package com.intec.project.entities;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class GLS extends person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int GLS_id;
    

    public GLS(){}

    public GLS(int GLS_id, int person_id, String fnavn, String enavn, String kørerkort_nummer, LocalDateTime fødselsdato) {
        super(person_id, fnavn, enavn, kørerkort_nummer, fødselsdato);
        this.GLS_id = GLS_id;
    }

    public int getGLS_id() {
        return this.GLS_id;
    }

    public void setGLS_id(int GLS_id) {
        this.GLS_id = GLS_id;
    }


    @Override
    public String toString() {
        return "{" + "GLS_id= " + getGLS_id() + "\n" +
                super.toString() + "}";
    }

}
