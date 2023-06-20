package com.intec.project.entities;


//standardkonstruktør der opretter ny instans af klassen lokation
public class lokation {

    private int lokation_id;
    private String lokation_navn;

//getter og setter ind til database
    public lokation(){}

    public lokation(int lokation_id, String lokation_navn) {
        this.lokation_id = lokation_id;
        this.lokation_navn = lokation_navn;
    }

    public lokation(String lokation_navn) {
        this.lokation_navn = lokation_navn;
    }

    public int getLokation_id() {
        return this.lokation_id;
    }

    public void setLokation_id(int lokation_id) {
        this.lokation_id = lokation_id;
    }

    public String getLokation_navn() {
        return this.lokation_navn;
    }

    public void setLokation_navn(String lokation_navn) {
        this.lokation_navn = lokation_navn;
    }
//toString(bytecode)
    @Override
    public String toString() {
        return "{" +
            " lokation_id='" + getLokation_id() + "'" +
            ", lokation_navn='" + getLokation_navn() + "'" +
            "}";
    }
}
