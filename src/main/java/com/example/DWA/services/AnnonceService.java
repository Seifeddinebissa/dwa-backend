package com.example.DWA.services;

import com.example.DWA.entities.Annonce;

import java.util.List;

public interface AnnonceService {
     Annonce saveAnnonce(Annonce annonce);
     Annonce updateAnnoce(Annonce annonce);
     void deleteAnnonce(Long id);
     Annonce getAnnonce(Long id);
     List<Annonce> getAllAnnonces();
}
