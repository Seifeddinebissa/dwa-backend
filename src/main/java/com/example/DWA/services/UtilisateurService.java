package com.example.DWA.services;

import com.example.DWA.entities.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    Utilisateur saveUtilisateur(Utilisateur utilisateur);
    Utilisateur updateUtilisateur(Utilisateur utilisateur);
    void deleteUtilisateur(Long id);
    List<Utilisateur> getAllUtilisateurs();
}
