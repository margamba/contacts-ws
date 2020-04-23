package com.sinbugs.contactsws.service;

import com.sinbugs.contactsws.dao.ContactRepository;
import com.sinbugs.contactsws.dto.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Marisol on 17/04/2020.
 */
@Service
public class ContactService {

    @Autowired
    private ContactRepository dao;

    public Contact save(Contact contact){

        return dao.saveAndFlush(contact);
    }

    public Contact getById(Long id) {
        Optional<Contact> optionalContact = dao.findById(id);
        if (optionalContact.isPresent()) {
            return optionalContact.get();
        }
        return null;
    }

    public void delete(Long id){
        Optional<Contact> optionalContact = dao.findById(id);
        if (optionalContact.isPresent()){
            dao.deleteById(id);
        }

    }
}
