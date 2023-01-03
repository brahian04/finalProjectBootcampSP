package com.Brahian.BdBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Brahian.BdBank.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> { 
}
