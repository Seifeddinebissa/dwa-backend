package com.example.DWA.controllers;

import com.example.DWA.entities.Categorie;
import com.example.DWA.services.CategorieService;
import com.example.DWA.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/categorie")
public class CategorieRestController {
    @Autowired
    CategorieService categorieService;

    @RequestMapping(value = "/ajouterCategorie", method = RequestMethod.POST)
    public Categorie ajouterCategorie(@RequestBody Categorie categorie){
        return categorieService.saveCategorie(categorie);
    }
    @RequestMapping(value = "/modifierCategorie", method = RequestMethod.PUT)
    public Categorie ModifierCategorie(@RequestBody Categorie categorie){
        return categorieService.updatCategorie(categorie);
    }
    @RequestMapping(value = "/supprimerCategorie/{id}", method = RequestMethod.DELETE)
    public void supprimerCategorie(@PathVariable("id") Long id){
         categorieService.deleteCategorie(id);
    }
    @RequestMapping(value = "/listeCategorie", method = RequestMethod.GET)
    public List<Categorie> listeContact(){
        return categorieService.getAllCategories();
    }
    @RequestMapping(value = "/consulterCategorie/{id}", method = RequestMethod.GET)
    public void consulterCategorie(@PathVariable("id") Long id){
        categorieService.consulterCategorie(id);
    }
}
