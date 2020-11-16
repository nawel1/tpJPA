package com.example.tpJPA;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehiculeRepository extends CrudRepository <Vehicule, Long>{
    List<Vehicule> findByPlateNumber(String plateNumber);
    List<Vehicule> findAll();
}
