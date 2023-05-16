package com.intec.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class firma {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int firma_id;
    private DHL DHL;
    private DSV DSV;
    private GLS GLS;
    

    public firma() {}

    public firma(int firma_id) {
        this.firma_id = firma_id;
        DHL = new DHL();
        DSV = new DSV();
        GLS = new GLS();
    }

    public int getFirma_id() {
        return this.firma_id;
    }

    public void setFirma_id(int firma_id) {
        this.firma_id = firma_id;
    }


    public DHL getDHL() {
        return this.DHL;
    }

    public void setDHL(DHL DHL) {
        this.DHL = DHL;
    }

    public DSV getDSV() {
        return this.DSV;
    }

    public void setDSV(DSV DSV) {
        this.DSV = DSV;
    }

    public GLS getGLS() {
        return this.GLS;
    }

    public void setGLS(GLS GLS) {
        this.GLS = GLS;
    }


    @Override
    public String toString() {
        return "{" +
            " firma_id='" + getFirma_id() + "'" +
            ", DHL='" + getDHL() + "'" +
            ", DSV='" + getDSV() + "'" +
            ", GLS='" + getGLS() + "'" +
            "}";
    }

}
