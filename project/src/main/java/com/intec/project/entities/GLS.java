package com.intec.project.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class GLS {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int GLS_id;
    private int person_id;

    public GLS(){}

    public GLS(int GLS_id, int person_id) {
        this.GLS_id = GLS_id;
        this.person_id = person_id;
    }

    public int getGLS_id() {
        return this.GLS_id;
    }

    public void setGLS_id(int GLS_id) {
        this.GLS_id = GLS_id;
    }

    public int getPerson_id() {
        return this.person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    @Override
    public String toString() {
        return "{" +
            " GLS_id='" + getGLS_id() + "'" +
            ", person_id='" + getPerson_id() + "'" +
            "}";
    }
}
