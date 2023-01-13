package com.Brahian.BdBank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Brahian.BdBank.entity.Customer;
import com.Brahian.BdBank.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    List<Product> idCustomer(Customer idCustomer);
    // @Query (value= "SELECT * FROM products WHERE id=1;", nativeQuery = true)
    // List<Product>  productsById();
}