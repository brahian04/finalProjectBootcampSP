package com.Brahian.BdBank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Brahian.BdBank.entity.Customer;
import com.Brahian.BdBank.repository.CustomerRepository;

@Service
public class CustomerServiceImplementation implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public boolean deleteCustomerById(int id) {
        return getCustomerById(id).map(customer ->{
            customerRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
