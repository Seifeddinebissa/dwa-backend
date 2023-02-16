package com.example.DWA.services;

import com.example.DWA.entities.Categorie;

import java.util.List;

public interface CategorieService {
     Categorie saveCategorie(Categorie categorie);
     Categorie updatCategorie(Categorie categorie);
    void deleteCategorie(Long id);
    List<Categorie> getAllCategories();
    Categorie consulterCategorie(Long id);
}
