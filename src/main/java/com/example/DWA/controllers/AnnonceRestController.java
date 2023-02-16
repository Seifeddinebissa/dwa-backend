package com.example.DWA.controllers;

import com.example.DWA.entities.Annonce;
import com.example.DWA.services.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/annonce")
public class AnnonceRestController {
    @Autowired
    AnnonceService annonceService;
    @RequestMapping(value = "/ajouterAnnonce", method = RequestMethod.POST)
    public Annonce ajouterAnnonce(@RequestBody Annonce annonce){
        return annonceService.saveAnnonce(annonce);
    }
    @RequestMapping(value = "/modifierAnnonce", method = RequestMethod.PUT)
    public Annonce modifierAnnonce(@RequestBody Annonce annonce){
        return annonceService.updateAnnoce(annonce);
    }
    @RequestMapping(value = "/supprimerAnnonce/{id}", method = RequestMethod.DELETE)
    public void ajouterAnnonce(@PathVariable("id") Long id){
        annonceService.deleteAnnonce(id);
    }

    @RequestMapping(value = "/listAnnonce", method = RequestMethod.GET)
    public List<Annonce> listeAnnonce(){
        return annonceService.getAllAnnonces();
    }
}
