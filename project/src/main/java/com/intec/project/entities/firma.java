//getter og setter ind til database

package com.intec.project.entities;

//standardkonstruktør der opretter ny instans af klassen firma
public class firma {

    private int firma_id;
    private String firma_navn;


//getter og setter ind til database
    public firma() {}

    public firma(int firma_id, String firma_navn) {
        this.firma_id = firma_id;
        this.firma_navn = firma_navn;
    }

    public firma(String firma_navn) {
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
//tostring(bytecode)
    @Override
    public String toString() {
        return "{" +
            " firma_id='" + getFirma_id() + "'" +
            ", firma_navn='" + getFirma_navn() + "'" +
            "}";
    }
}
