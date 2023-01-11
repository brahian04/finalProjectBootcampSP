package com.Brahian.BdBank.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="products")

public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idProduct;
    
    @Column(name= "accountType", unique = true, nullable = false)
    private String accountType;

    @Column(name= "accountNumber", unique = true, nullable = false)
    private int accountNumber;

    @Column(name= "status", length = 50, nullable = false)
    private String status;

    @Column(name= "balance", nullable = false)
    private int balance;

    @Column(name= "availableBalance", nullable = false)
    private int availableBalance;

    @Column(name= "GMF", nullable = false)
    private boolean GMF;

    @Column(name= "creationDate")
    private Date creationDate;

    @Column(name= "creationUser")
    private String creationUser;

    @Column(name= "modificationDate")
    private Date modificationDate;

    @Column(name= "modificationUser")
    private String modificationUser;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "id")
    private Customer customer;

    public int getId() {
        return idProduct;
    }

    public void setId(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(int availableBalance) {
        this.availableBalance = availableBalance;
    }

    public boolean isGMF() {
        return GMF;
    }

    public void setGMF(boolean GMF) {
        this.GMF = GMF;
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

    public void setCreationUser(String creationUser) {
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