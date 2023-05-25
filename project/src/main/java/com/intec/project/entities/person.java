package com.intec.project.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class person {

    private int person_id;
    private String fnavn;
    private String enavn;
    private String kørerkort_nummer;
    private LocalDate fødselsdato;

    public person(){}

    public person(int person_id, String fnavn, String enavn, String kørerkort_nummer, LocalDate fødselsdato) {
    this.person_id = person_id;
    this.fnavn = fnavn;
    this.enavn = enavn;
    this.kørerkort_nummer = kørerkort_nummer;
    this.fødselsdato = fødselsdato;
    }

    public person(String fnavn, String enavn, String kørerkort_nummer, LocalDate fødselsdato) {
        this.fnavn = fnavn;
        this.enavn = enavn;
        this.kørerkort_nummer = kørerkort_nummer;
        this.fødselsdato = fødselsdato;
    }

    public int getPerson_id() {
        return this.person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getFnavn() {
        return this.fnavn;
    }

    public void setFnavn(String fnavn) {
        this.fnavn = fnavn;
    }

    public String getEnavn() {
        return this.enavn;
    }

    public void setEnavn(String enavn) {
        this.enavn = enavn;
    }

    public String getKørerkort_nummer() {
        return this.kørerkort_nummer;
    }

    public void setKørerkort_nummer(String kørerkort_nummer) {
        this.kørerkort_nummer = kørerkort_nummer;
    }

    public LocalDate getFødselsdato() {
        return this.fødselsdato;
    }

    public void setFødselsdato(LocalDate fødselsdato) {
        this.fødselsdato = fødselsdato;
    }

    @Override
    public String toString() {
        return "{" +
            " person_id='" + getPerson_id() + "'" +
            ", fnavn='" + getFnavn() + "'" +
            ", enavn='" + getEnavn() + "'" +
            ", kørerkort_nummer='" + getKørerkort_nummer() + "'" +
            ", fødselsdato='" + getFødselsdato() + "'" +
            "}";
    }
}
