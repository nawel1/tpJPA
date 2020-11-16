package com.example.tpJPA;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicule{

    private int numberOfSeats;

    public Car(String plateNumber, int numberOfSeats) {
        super(plateNumber);
        this.numberOfSeats = numberOfSeats;
    }

    public Car() {
        super();
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
