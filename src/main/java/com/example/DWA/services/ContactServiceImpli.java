package com.example.DWA.services;

import com.example.DWA.entities.Contact;
import com.example.DWA.repositorys.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpli implements ContactService{
    @Autowired
    ContactRepository contactRepository;
    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}
