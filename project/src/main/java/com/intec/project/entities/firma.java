package com.intec.project.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class firma extends person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int firma_id;
    private String firma_navn;


    public firma() {}


    public firma(int firma_id, String firma_navn, int person_id, String fnavn, String enavn, String kørerkort_nummer, LocalDateTime fødselsdato) {
        super(person_id, fnavn, enavn, kørerkort_nummer, fødselsdato);
        this.firma_id = firma_id;
        this.firma_navn = firma_navn;
    }


    public int getFirma_id() {
        return this.firma_id;
    }

    public void setFirma_id(int firma_id) {
        this.firma_id = firma_id;
    }


    public String getFirma_navn() {
        return this.firma_navn;
    }

    public void setFirma_navn(String firma_navn) {
        this.firma_navn = firma_navn;
    }
    

    @Override
    public String toString() {
        return super.toString() + " firma_id='" + getFirma_id() + "'" +
            ", firma_navn='" + getFirma_navn() + "'";
    }
   

}
