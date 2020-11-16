package com.example.tpJPA;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Rent {

    public long id;
    public Date beginRent;
    public Date endRent;
    public Vehicule vehicule;
    public Person person;

    public Rent() { super(); }
    public Rent(Date beginRent, Date endRent, Vehicule vehicule, Person person) {
        this.beginRent = beginRent;
        this.endRent = endRent;
        this.vehicule = vehicule;
        this.person = person;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBeginRent() {
        return beginRent;
    }

    public void setBeginRent(Date beginRent) {
        this.beginRent = beginRent;
    }

    public Date getEndRent() {
        return endRent;
    }

    public void setEndRent(Date endRent) {
        this.endRent = endRent;
    }

    @ManyToOne(cascade=CascadeType.MERGE)
    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    @ManyToOne(cascade=CascadeType.MERGE)
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
