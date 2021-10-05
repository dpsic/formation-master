package com.example.formation.services;

import com.example.formation.entites.Formation;
import com.example.formation.repositories.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationServiceImpl implements FormationService{

    @Autowired
    FormationRepository formationRepository;

    @Override
    public Formation ajouter(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public List<Formation> getAllFormation() {
        return formationRepository.findAll();
    }

    @Override
    public Formation getFormationById(Long id) {
        return formationRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        formationRepository.deleteById(id);
    }
}
