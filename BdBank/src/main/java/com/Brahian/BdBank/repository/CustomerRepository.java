package com.Brahian.BdBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Brahian.BdBank.entity.Customer;
public interface CustomerRepository extends JpaRepository<Customer, Integer> { 
}
