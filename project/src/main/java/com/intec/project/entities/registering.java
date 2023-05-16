package com.intec.project.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class registering {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int registering_id;
    private LocalDateTime indtjekningstidspunkt;
    private firma firma;
    private lokation lokation;

    public registering() {}

    public registering(int registering_id, LocalDateTime indtjekningstidspunkt) {
        this.registering_id = registering_id;
        this.indtjekningstidspunkt = indtjekningstidspunkt;
        firma = new firma();
        lokation = new lokation();
    }

    public int getRegistering_id() {
        return this.registering_id;
    }

    public void setRegistering_id(int registering_id) {
        this.registering_id = registering_id;
    }

    public LocalDateTime getIndtjekningstidspunkt() {
        return this.indtjekningstidspunkt;
    }

    public void setIndtjekningstidspunkt(LocalDateTime indtjekningstidspunkt) {
        this.indtjekningstidspunkt = indtjekningstidspunkt;
    }


    public firma getFirma() {
        return this.firma;
    }

    public void setFirma(firma firma) {
        this.firma = firma;
    }

    public lokation getLokation() {
        return this.lokation;
    }

    public void setLokation(lokation lokation) {
        this.lokation = lokation;
    }


    @Override
    public String toString() {
        return "{" +
            " registering_id='" + getRegistering_id() + "'" +
            ", indtjekningstidspunkt='" + getIndtjekningstidspunkt() + "'" +
            ", firma='" + getFirma() + "'" +
            ", lokation='" + getLokation() + "'" +
            "}";
    }

}
