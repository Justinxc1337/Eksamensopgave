package com.intec.project.entities;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class person {

    private int person_id;
    private String fnavn;
    private String enavn;
    private String kørerkort_nummer;
    private LocalDateTime fødselsdato;


public person(int person_id, String fnavn, String enavn, String kørerkort_nummer) {
    this.person_id = person_id;
    this.fnavn = fnavn;
    this.enavn = enavn;
    this.kørerkort_nummer = kørerkort_nummer;
}

public person(LocalDateTime fødselsdato) {
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

    public LocalDateTime getFødselsdato() {
        return this.fødselsdato;
    }

    public void setFødselsdato(LocalDateTime fødselsdato) {
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
