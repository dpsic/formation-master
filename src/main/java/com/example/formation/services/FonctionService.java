package com.example.formation.services;

import com.example.formation.entites.Fonction;

import java.util.List;

public interface FonctionService {

    public Fonction ajouter(Fonction fonction);

    public List<Fonction> getAllfonction();

    public Fonction getfonctionById(Long id);

    public void delete(Long id);
}
