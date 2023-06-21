package com.intec.project.entities;
import java.time.LocalDateTime;

public class registrering {

    private int registrering_id;
    private int firma_id;
    private int person_id;
    private int lokation_id;
    private LocalDateTime indtjekningstidspunkt;

    public registrering() {}

    public registrering(int registrering_id, int firma_id, int person_id, int lokation_id) {
        this.registrering_id = registrering_id;
        this.firma_id = firma_id;
        this.person_id = person_id;
        this.lokation_id = lokation_id;
    }

    public registrering(int registrering_id, int firma_id, int person_id, int lokation_id, LocalDateTime indtjekningstidspunkt) {
        this.registrering_id = registrering_id;
        this.firma_id = firma_id;
        this.person_id = person_id;
        this.lokation_id = lokation_id;
        this.indtjekningstidspunkt = indtjekningstidspunkt;
    }

    public int getRegistrering_id() {
        return this.registrering_id;
    }

    public void setRegistrering_id(int registrering_id) {
        this.registrering_id = registrering_id;
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
        return "registrering{" +
                "registrering_id=" + registrering_id +
                ", firma_id=" + firma_id +
                ", person_id=" + person_id +
                ", lokation_id=" + lokation_id +
                ", indtjekningstidspunkt=" + indtjekningstidspunkt +
                '}';
    }

}
