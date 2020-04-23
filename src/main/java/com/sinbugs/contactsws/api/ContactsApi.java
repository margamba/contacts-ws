package com.sinbugs.contactsws.api;

import com.sinbugs.contactsws.dto.Contact;
import com.sinbugs.contactsws.service.ContactService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Optional;

/**
 * Created by Marisol on 17/04/2020.
 */
@RestController
public class ContactsApi {
    @Autowired
    private ContactService contactService;
    @Autowired
    private Mapper mapper;

    @RequestMapping( path = "/contacts/getContact/{id}",  method = RequestMethod.GET)
    public ContactResponse getById(@PathVariable("id") Long id){
        Contact contact =  contactService.getById(id);
        return mapper.map(contact, ContactResponse.class);


    }

    @RequestMapping (path = "/contacts/newContact", method = RequestMethod.POST)
    public ContactResponse createContact (@RequestBody @Valid ContactRequest contactRequest) {
        Contact contact = mapper.map(contactRequest, Contact.class);
        Contact updateContact= contactService.save(contact);
        return mapper.map(updateContact, ContactResponse.class);
    }

    @RequestMapping (path = "/contacts/updateContact", method = RequestMethod.PUT)
    public ContactResponse updateContact (@RequestBody @Valid ContactRequest contactRequest ){
        Contact contact = mapper.map(contactRequest, Contact.class);
        Contact updateContact = contactService.getById(contact.getId());
        updateContact.setPhoneNumber(contact.getPhoneNumber());
        updateContact.setEmail(contact.getEmail());
        updateContact = contactService.save(updateContact);
        return mapper.map(updateContact, ContactResponse.class);
    }


    @RequestMapping (path = "/contacts/deleteContact", method = RequestMethod.DELETE)
    public void deleteContact (@PathParam("id") Long id ){
        contactService.delete(id);
    }


}
