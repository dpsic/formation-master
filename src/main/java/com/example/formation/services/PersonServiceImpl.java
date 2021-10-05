package com.example.formation.services;

import com.example.formation.entites.Fonction;
import com.example.formation.entites.Formation;
import com.example.formation.entites.Person;
import com.example.formation.exceptions.LibbeleException;
import com.example.formation.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonRepository personRepository;

    @Override
    public Person ajouter(Person person) {
        try{
        return personRepository.save(person);}
        catch (Exception EX){

            throw new LibbeleException("Erreur Fatale");
        }
    }

    @Override
    public List<Person> getAllPerson() {
        try{
        return personRepository.findAll();}
         catch (Exception EX){

                throw new LibbeleException("Erreur Fatale");
            }
    }

    @Override
    public Person getPersonById(Long id) {
        try{
        return personRepository.findById(id).get();} catch (Exception EX){

        throw new LibbeleException("Erreur Fatale");
    }
    }

    @Override
    public void delete(Long id) {
        try{
        personRepository.deleteById(id); }catch (Exception EX){

            throw new LibbeleException("Erreur Fatale");
        }
    }
    public int pourcentage(Long id) {
        Person person = personRepository.findById(id).get();
     Fonction fonction1 = person.getFonctions();
      List<Formation> formation1 = fonction1.getFormations();
        //ArrayList<String> list1 = new ArrayList<String>();
        List<Formation> formations = person.getFormations();

        if (formation1.equals(formations))
            System.out.println("ok");

        return 1;
    }
}
