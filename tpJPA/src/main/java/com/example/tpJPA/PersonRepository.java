package com.example.tpJPA;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository <Person, Long>{
    List<Person> findByName(String Name);
    List<Person> findAll();
}
