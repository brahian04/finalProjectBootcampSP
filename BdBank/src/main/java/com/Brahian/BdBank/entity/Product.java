package com.Brahian.BdBank.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
    
    @Column(name= "accountType", nullable = false)
    private String accountType;

    @Column(name= "accountNumber", unique = true, nullable = false)
    private String accountNumber;

    @Column(name= "status", length = 50)
    private String status;

    @Column(name= "balance")
    private int balance;

    @Column(name= "availableBalance")
    private int availableBalance;

    @Column(name= "GMF")
    private String GMF;

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

    @ManyToOne(optional = false)
    @JoinColumn(name= "id", nullable = false)
    private Customer idCustomer;

    

    public Product() {
    }

    public Product(int idProduct, String accountType, String accountNumber, String status, int balance,
            int availableBalance, String gMF, Date creationDate, String creationUser, Date modificationDate,
            String modificationUser, Customer idCustomer) {
        this.idProduct = idProduct;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.status = status;
        this.balance = balance;
        this.availableBalance = availableBalance;
        GMF = gMF;
        this.creationDate = creationDate;
        this.creationUser = creationUser;
        this.modificationDate = modificationDate;
        this.modificationUser = modificationUser;
        this.idCustomer = idCustomer;
    }

    public Customer getidCustomer() {
        return idCustomer;
    }

    public void setidCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
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

    public String getGMF() {
        return GMF;
    }

    public void setGMF(String GMF) {
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