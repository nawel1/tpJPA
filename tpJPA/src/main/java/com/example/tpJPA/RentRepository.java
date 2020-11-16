package com.example.tpJPA;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RentRepository extends CrudRepository <Rent, Long>{
    List<Rent> findAll();
}
