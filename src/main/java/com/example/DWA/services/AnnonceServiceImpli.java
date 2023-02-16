package com.example.DWA.services;

import com.example.DWA.entities.Annonce;
import com.example.DWA.repositorys.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnonceServiceImpli implements AnnonceService{
    @Autowired
    AnnonceRepository annonceRepository;

    @Override
    public Annonce saveAnnonce(Annonce annonce) {
        return annonceRepository.save(annonce);
    }

    @Override
    public Annonce updateAnnoce(Annonce annonce) {
        return annonceRepository.save(annonce);
    }

    @Override
    public void deleteAnnonce(Long id) {
        annonceRepository.deleteById(id);
    }

    @Override
    public Annonce getAnnonce(Long id) {
        return annonceRepository.findById(id).get();
    }

    @Override
    public List<Annonce> getAllAnnonces() {
        return annonceRepository.findAll();
    }
}
