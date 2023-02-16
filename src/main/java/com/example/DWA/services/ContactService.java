package com.example.DWA.services;

import com.example.DWA.entities.Contact;

import java.util.List;

public interface ContactService {
    Contact saveContact(Contact contact);
    Contact updateContact(Contact contact);
    void deleteContact(Long id);
    List<Contact> getAllContacts();
}
