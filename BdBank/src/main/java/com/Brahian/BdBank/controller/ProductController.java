package com.Brahian.BdBank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Brahian.BdBank.entity.Product;
import com.Brahian.BdBank.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins="http://localhost:4200")

public class ProductController {

    @Autowired
    ProductService productService;

    
    @PostMapping("/{id}")
    public ResponseEntity<Product>
    createProduct(
        @RequestBody Product productDetail,
        @PathVariable("id") Integer idCustomer){


        if(productService.createProduct(idCustomer, productDetail)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int idProduct){
        return productService.getProductById(idProduct)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable("id") int idProduct,@RequestBody Product productDetail){
        if(productService.updateProductById(idProduct, productDetail)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
}
