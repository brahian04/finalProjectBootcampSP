package com.Brahian.BdBank.service;

import java.util.List;
import java.util.Optional;

import com.Brahian.BdBank.entity.Customer;

public interface CustomerService {
    public Customer createCustomer(Customer customer);
    public boolean updateCustomerById(int id, Customer customerDetail);
    public List<Customer> getAllCustomers();
    public Optional<Customer> getCustomerById(int id);
    public boolean deleteCustomerById(int id);
}
