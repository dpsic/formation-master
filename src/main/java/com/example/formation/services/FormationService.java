package com.example.formation.services;

import com.example.formation.entites.Formation;

import java.util.List;

public interface FormationService {

    public Formation ajouter(Formation formation);

    public List<Formation> getAllFormation();

    public Formation getFormationById(Long id);

    public void delete(Long id);
}
