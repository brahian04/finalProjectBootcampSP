package com.Brahian.BdBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Brahian.BdBank.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    
}