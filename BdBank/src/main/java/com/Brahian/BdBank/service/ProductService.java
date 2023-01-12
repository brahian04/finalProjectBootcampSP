package com.Brahian.BdBank.service;

import java.util.List;
import java.util.Optional;

import com.Brahian.BdBank.entity.Product;

public interface ProductService {
    public boolean createProduct(Integer idCustomer, Product accounDetail);
    public boolean updateProductById(int idProduct, Product productDetail);
    public List<Product> getAllProduct();
    public Optional<Product> getProductById(int idProduct);
    public boolean deleteProductById(int idProduct);
}