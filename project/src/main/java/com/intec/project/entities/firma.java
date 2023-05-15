package com.intec.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class firma {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int firma_id;
    private int DHL_id;
    private int DVS_id;
    private int GLS_id;


    public firma() {}

    public firma(int firma_id, int DHL_id, int DVS_id, int GLS_id) {
        this.firma_id = firma_id;
        this.DHL_id = DHL_id;
        this.DVS_id = DVS_id;
        this.GLS_id = GLS_id;
    }

    public int getFirma_id() {
        return this.firma_id;
    }

    public void setFirma_id(int firma_id) {
        this.firma_id = firma_id;
    }

    public int getDHL_id() {
        return this.DHL_id;
    }

    public void setDHL_id(int DHL_id) {
        this.DHL_id = DHL_id;
    }

    public int getDVS_id() {
        return this.DVS_id;
    }

    public void setDVS_id(int DVS_id) {
        this.DVS_id = DVS_id;
    }

    public int getGLS_id() {
        return this.GLS_id;
    }

    public void setGLS_id(int GLS_id) {
        this.GLS_id = GLS_id;
    }

    @Override
    public String toString() {
        return "{" +
            " firma_id='" + getFirma_id() + "'" +
            ", DHL_id='" + getDHL_id() + "'" +
            ", DVS_id='" + getDVS_id() + "'" +
            ", GLS_id='" + getGLS_id() + "'" +
            "}";
    }    
}
