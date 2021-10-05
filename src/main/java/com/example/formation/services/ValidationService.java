package com.example.formation.services;

import com.example.formation.entites.Validation;

import java.util.List;

public interface ValidationService {
    public Validation ajouter(Validation validation);

    public List<Validation> getAllvalidation();

    public Validation getvalidationById(Long id);

    public void delete(Long id);
}
