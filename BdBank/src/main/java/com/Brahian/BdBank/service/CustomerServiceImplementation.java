package com.Brahian.BdBank.service;

import java.util.Date;
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
        customer.setcreationUser("admin");
        customer.setCreationDate( new Date());
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

    @Override
    public boolean updateCustomerById(int id, Customer customerDetail) {
        return getCustomerById(id).map(customer ->{
            Customer client = customer;
            client.setName(customerDetail.getName());
            client.setLastName(customerDetail.getLastName());
            client.setDateOfBirth(customerDetail.getDateOfBirth());
            client.setDocumentType(customerDetail.getDocumentType());
            client.setDocumentNumber(customerDetail.getDocumentNumber());
            client.setEmail(customerDetail.getEmail());
            client.setModificationUser("admin");
            client.setModificationDate( new Date());
            customerRepository.save(client);
            return true;
        }).orElse(false);
    }
}
