package com.sinbugs.contactsws.api;

import com.sinbugs.contactsws.dto.Contact;
import com.sinbugs.contactsws.service.ContactService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @RequestMapping( value = "/product",  method = RequestMethod.GET)
    public ContactResponse getById(@RequestParam("id") Long id){
        Contact contact =  contactService.getById(id);
        return mapper.map(contact, ContactResponse.class);


    }

    @RequestMapping (value = "/contact", method = RequestMethod.POST)
    public ContactResponse updateOrSave (@RequestBody @Valid ContactRequest contactRequest) {
        Contact contact = mapper.map(contactRequest, Contact.class);
        Contact updateContact= contactService.save(contact);
        return mapper.map(updateContact, ContactResponse.class);
    }


}
