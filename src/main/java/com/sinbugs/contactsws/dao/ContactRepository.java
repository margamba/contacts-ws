package com.sinbugs.contactsws.dao;

import com.sinbugs.contactsws.api.ContactRequest;
import com.sinbugs.contactsws.dto.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import static javafx.scene.input.KeyCode.J;

/**
 * Created by Marisol on 17/04/2020.
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {

}