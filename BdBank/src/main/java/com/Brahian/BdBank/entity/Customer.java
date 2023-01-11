package com.Brahian.BdBank.entity;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

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

    @Column(name= "documentNumber", unique = true)
    private String documentNumber;

    @Column(name= "name", length = 60, nullable = false)
    private String name;

    @Column(name= "lastName", length = 60, nullable = false)
    private String lastName;

    @Column(name= "email", length = 80, nullable = false, unique = true)
    private String email;

    @Column(name= "dateOfBirth")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @Column(name= "creationDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;

    @Column(name= "creationUser")
    private String creationUser;

    @Column(name= "modificationDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date modificationDate;

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

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreationUser() {
        return creationUser;
    }

    public void setcreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getModificationUser() {
        return modificationUser;
    }

    public void setModificationUser(String modificationUser) {
        this.modificationUser = modificationUser;
    }
    
}
