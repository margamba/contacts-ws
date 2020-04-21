package com.sinbugs.contactsws.api;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Marisol on 19/04/2020.
 */
public class ContactRequest {

    private Long id;
    @NotNull(message = "El nombre es requerido")
    @Size(min = 2, max = 30, message = "El nombre debe tener entre {min} y {max} caracteres")
    private String firstName;
    private String lastName;
    @Pattern(regexp = "^\\+[0-9]*$", message = "El número de teléfono debe empezar con el símbolo + y tener solo digitos")
    private String phoneNumber;
    @Pattern(regexp = "^(.+)@(.+)$", message ="Email invalido")
    private String email;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
