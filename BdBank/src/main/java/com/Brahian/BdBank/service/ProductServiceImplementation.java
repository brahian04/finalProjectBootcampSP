package com.Brahian.BdBank.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Brahian.BdBank.entity.Customer;
import com.Brahian.BdBank.entity.Product;
import com.Brahian.BdBank.repository.CustomerRepository;
import com.Brahian.BdBank.repository.ProductRepository;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public boolean createProduct(Integer idCustomer, Product accounDetail) {
        Product product= new Product();
        Customer idcustomer=customerRepository.id(idCustomer);
        String res= new String();
        int[] accountNum= new int[10];

        if(customerRepository.findById(idCustomer).isPresent()){
            if(accounDetail.getAccountType().equalsIgnoreCase("savings account")){
                accountNum[0]= 4;
                accountNum[1]= 6;
                for(int i=2; i<10; i++){
                    int num= (int)(Math.random()*9+0);
                    accountNum[i]= num;
                }
                res = Arrays.stream(accountNum)
                .mapToObj(String::valueOf)
                .reduce((x, y) -> x + "" + y)
                .get();
            }else{
                accountNum[0]= 2;
                accountNum[1]= 3;
                for(int i=2; i<10; i++){
                    int num= (int)(Math.random()*9+0);
                    accountNum[i]= num;
                }
                res = Arrays.stream(accountNum)
                .mapToObj(String::valueOf)
                .reduce((x, y) -> x + "" + y)
                .get();
            }
            product.setAccountType(accounDetail.getAccountType());
            product.setAccountNumber(res);
            product.setStatus("active");
            product.setBalance(0);
            product.setAvailableBalance(0);
            product.setGMF("exempt");
            product.setCreationDate(new Date());
            product.setCreationUser("admin");
            product.setidCustomer(idcustomer);
            productRepository.save(product);
            return true;
        }else{
            return false;
        }
        

    }

    @Override
    public boolean updateProductById(int idProduct, Product productDetail) {
        return getProductById(idProduct).map(product ->{
            Product prod = product;
            // Date date = new Date(System.currentTimeMillis());
            prod.setStatus(productDetail.getStatus());
            prod.setBalance(productDetail.getBalance());
            prod.setAvailableBalance(productDetail.getAvailableBalance());

            // customer.setModificationDate(date);
            productRepository.save(prod);
            return true;
        }).orElse(false);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProductById(int id){
        
        return productRepository.idCustomer(customerRepository.id(id));
    }

    @Override
    public Optional<Product> getProductById(int idProduct) {
        return productRepository.findById(idProduct);
    }

    @Override
    public boolean deleteProductById(int idProduct) {
        return getProductById(idProduct).map(product ->{
            productRepository.deleteById(idProduct);
            return true;
        }).orElse(false);
    }
    
}
