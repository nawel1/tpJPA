package com.example.tpJPA;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vehicule {

    private long id;
    private String plateNumber;
    private List<Rent> rents = new ArrayList<Rent>();

    public Vehicule() {
        super();
    }

    public Vehicule(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @OneToMany(mappedBy="vehicule", cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rentV) {
        this.rents = rentV;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "id=" + id +
                ", plateNumber='" + plateNumber + '\'' +
                '}';
    }
}
