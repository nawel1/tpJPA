package com.example.tpJPA;

import javax.persistence.Entity;

@Entity
public class Van extends Vehicule{

    private long maxWeight;

    public Van(String plateNumber, long maxWeight) {
        super(plateNumber);
        this.maxWeight = maxWeight;
    }

    public Van() {
        super();
    }

    public long getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(long maxWeight) {
        this.maxWeight = maxWeight;
    }
}
