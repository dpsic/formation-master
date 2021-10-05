package com.example.formation.services;

import com.example.formation.entites.Categorie;
import com.example.formation.exceptions.LibbeleException;
import com.example.formation.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService{

    @Autowired
    CategorieRepository categorieRepository;

    @Override
    public Categorie ajouter(Categorie categorie) {
        try{

        return categorieRepository.save(categorie);

        }catch (Exception EX){

            throw new LibbeleException("Erreur Fatale");
        }
    }

    @Override
    public List<Categorie> getAllCategorie() {try{
        return categorieRepository.findAll();}catch (Exception EX){

        throw new LibbeleException("Erreur Fatale");
    }
    }

    @Override
    public Categorie getCategorieById(Long id) {try{
        return categorieRepository.findById(id).get();}catch (Exception EX){

        throw new LibbeleException("Erreur Fatale");
        }
    }

    @Override
    public void delete(Long id) {
        try{
        categorieRepository.deleteById(id);}catch (Exception EX){

        throw new LibbeleException("Erreur Fatale");
        }
    }
}
