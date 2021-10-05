package com.example.formation.services;

import com.example.formation.entites.Fonction;
import com.example.formation.entites.Formation;
import com.example.formation.repositories.FonctionRepository;
import com.example.formation.repositories.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FonctionServiceImpl implements FonctionService{
    @Autowired
    FonctionRepository fonctionRepository;

    @Override
    public Fonction ajouter(Fonction fonction) {
        return fonctionRepository.save(fonction);
    }

    @Override
    public List<Fonction> getAllfonction() {
        return fonctionRepository.findAll();
    }

    @Override
    public Fonction getfonctionById(Long id) {
        return fonctionRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        fonctionRepository.deleteById(id);
    }
}