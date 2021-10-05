package com.example.formation.services;

import com.example.formation.entites.Validation;
import com.example.formation.repositories.ValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ValidationServiceImpl implements ValidationService{
    @Autowired
    ValidationRepository validationRepository;
    @Override
    public Validation ajouter(Validation validation) {
        return validationRepository.save(validation);
    }

    @Override
    public List<Validation> getAllvalidation() {
        return validationRepository.findAll();
    }

    @Override
    public Validation getvalidationById(Long id) {
        return validationRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
         validationRepository.deleteById(id);
    }
}
