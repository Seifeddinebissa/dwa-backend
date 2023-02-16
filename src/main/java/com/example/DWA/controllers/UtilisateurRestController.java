package com.example.DWA.controllers;

import com.example.DWA.entities.Utilisateur;
import com.example.DWA.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/utilisateur")
public class UtilisateurRestController {
    @Autowired
    UtilisateurService utilisateurService;

    @RequestMapping(value = "/ajouterUtilisateur", method = RequestMethod.POST)
    public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurService.saveUtilisateur(utilisateur);
    }

    @RequestMapping(value = "/modifierUtilisateur", method = RequestMethod.PUT)
    public Utilisateur modifierUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurService.updateUtilisateur(utilisateur);
    }

    @RequestMapping(value = "/deleteUtilisateur", method = RequestMethod.DELETE)
    public void deleteUtilisateur(@PathVariable Long id){
         utilisateurService.deleteUtilisateur(id);
    }
    @RequestMapping(value = "/listeUtilisateur", method = RequestMethod.GET)
    public List<Utilisateur> listeUtilisateur(){
        return utilisateurService.getAllUtilisateurs();
    }
}
