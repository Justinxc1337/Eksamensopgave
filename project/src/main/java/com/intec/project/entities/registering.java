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
    private int firma_id;
    private int lokation_id;
    private LocalDateTime indtjekningstidspunkt;

    public registering() {}

    public registering(int registering_id, int firma_id, int lokation_id, LocalDateTime indtjekningstidspunkt) {
        this.registering_id = registering_id;
        this.firma_id = firma_id;
        this.lokation_id = lokation_id;
        this.indtjekningstidspunkt = indtjekningstidspunkt;
    }

    public int getRegistering_id() {
        return this.registering_id;
    }

    public void setRegistering_id(int registering_id) {
        this.registering_id = registering_id;
    }

    public int getFirma_id() {
        return this.firma_id;
    }

    public void setFirma_id(int firma_id) {
        this.firma_id = firma_id;
    }

    public int getLokation_id() {
        return this.lokation_id;
    }

    public void setLokation_id(int lokation_id) {
        this.lokation_id = lokation_id;
    }

    public LocalDateTime getIndtjekningstidspunkt() {
        return this.indtjekningstidspunkt;
    }

    public void setIndtjekningstidspunkt(LocalDateTime indtjekningstidspunkt) {
        this.indtjekningstidspunkt = indtjekningstidspunkt;
    }

    @Override
    public String toString() {
        return "{" +
            " registering_id='" + getRegistering_id() + "'" +
            ", firma_id='" + getFirma_id() + "'" +
            ", lokation_id='" + getLokation_id() + "'" +
            ", indtjekningstidspunkt='" + getIndtjekningstidspunkt() + "'" +
            "}";
    }
}
