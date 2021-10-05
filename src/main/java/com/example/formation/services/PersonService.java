package com.example.formation.services;

import com.example.formation.entites.Person;

import java.util.List;

public interface PersonService {

   Person ajouter(Person person);

    List<Person> getAllPerson();

   Person getPersonById(Long id);
    int pourcentage(Long id);
 void delete(Long id);
}
