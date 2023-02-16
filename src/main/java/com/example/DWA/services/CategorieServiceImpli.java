package com.example.DWA.services;

import com.example.DWA.entities.Categorie;
import com.example.DWA.repositorys.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpli implements CategorieService{

    @Autowired
    CategorieRepository categorieRepository;
    @Override
    public Categorie saveCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie updatCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie consulterCategorie(Long id) {
        return categorieRepository.findById(id).get();
    }
}
