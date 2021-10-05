package com.example.formation.services;
import com.example.formation.entites.Categorie;


import java.util.List;

public interface CategorieService {
    public Categorie ajouter(Categorie categorie);

    public List<Categorie> getAllCategorie();

    public Categorie getCategorieById(Long id);

    public void delete(Long id);
}
