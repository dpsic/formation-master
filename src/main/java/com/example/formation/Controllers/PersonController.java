package com.example.formation.Controllers;

import com.example.formation.entites.Person;
import com.example.formation.services.MapVAlidationErrorService;
import com.example.formation.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("")
@RequestMapping("/api/persons")
public class PersonController {
    @Autowired
    PersonService personService;
    @Autowired
    MapVAlidationErrorService mapVAlidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> save(@Valid @RequestBody Person person, BindingResult result) {
        ResponseEntity<?> errorMap = mapVAlidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;
        Person person1 = personService.ajouter(person);
        return new ResponseEntity<Person>(person1, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPerso(@PathVariable Long id) {
        return new ResponseEntity<Person>(personService.getPersonById(id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllPersonnels() {
        return new ResponseEntity<List<Person>>(personService.getAllPerson(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.delete(id);

    }
    @GetMapping("/pou/{id}")
    public int poucentage(@PathVariable Long id){

        return personService.pourcentage(id);
    }


}



