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


public void setfnavn(String fnavn) {
    this.fnavn = fnavn;
}

public void setenavn(String enavn) {
    this.enavn = enavn;
}

}