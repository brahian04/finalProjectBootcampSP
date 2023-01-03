package com.Brahian.BdBank.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")

public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name= "documentType")
    private String documentType;

    @Column(name= "documentNumber")
    private int documentNumber;

    @Column(name= "name", length = 60, nullable = false)
    private String name;

    @Column(name= "lastName", length = 60, nullable = false)
    private String lastName;

    @Column(name= "email", length = 80, nullable = false, unique = true)
    private String email;

    @Column(name= "dateOfBirth")
    private String dateOfBirth;

    @Column(name= "creationDate")
    private String creationDate;

    @Column(name= "creationUser")
    private String creationUser;

    @Column(name= "modificationDate")
    private String modificationDate;

    @Column(name= "modificationUser")
    private String modificationUser;



    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(int documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreationUser() {
        return creationUser;
    }

    // public void setCreationUser(String creationUser) {
    //     this.creationUser = creationUser;
    // }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getModificationUser() {
        return modificationUser;
    }

    // public void setModificationUser(String modificationUser) {
    //     this.modificationUser = modificationUser;
    // }

    
}
