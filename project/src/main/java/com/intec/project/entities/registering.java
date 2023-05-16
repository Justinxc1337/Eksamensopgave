package com.intec.project.entities;

import java.time.LocalDateTime;

public class registering {

    private int registering_id;
    private int firma_id;
    private int person_id;
    private int lokation_id;
    private LocalDateTime indtjekningstidspunkt;

    public registering() {}

    public registering(int registering_id, int firma_id, int person_id, int lokation_id, LocalDateTime indtjekningstidspunkt) {
        this.registering_id = registering_id;
        this.firma_id = firma_id;
        this.person_id = person_id;
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

    public int getPerson_id() {
        return this.person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
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
            ", person_id='" + getPerson_id() + "'" +
            ", lokation_id='" + getLokation_id() + "'" +
            ", indtjekningstidspunkt='" + getIndtjekningstidspunkt() + "'" +
            "}";
    }
}
