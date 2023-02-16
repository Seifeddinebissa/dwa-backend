package com.example.DWA.controllers;

import com.example.DWA.entities.Contact;
import com.example.DWA.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/contact")
public class ContactRestController {
    @Autowired
    ContactService contactService;

    @RequestMapping(value = "/ajouterContact", method = RequestMethod.POST)
    public Contact ajouterContact(@RequestBody Contact contact){
        return contactService.saveContact(contact);
    }

    @RequestMapping(value = "/modifierContact", method = RequestMethod.PUT)
    public Contact modifierContact(@RequestBody Contact contact){
        return contactService.updateContact(contact);
    }

    @RequestMapping(value = "/supprimerContact", method = RequestMethod.DELETE)
    public void supprimerContact(@PathVariable Long id){
        contactService.deleteContact(id);
    }

    @RequestMapping(value = "/listeContact", method = RequestMethod.GET)
    public List<Contact> listeContact(){
        return contactService.getAllContacts();
    }
}
