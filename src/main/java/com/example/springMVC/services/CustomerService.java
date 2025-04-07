package com.example.springMVC.services;

import java.util.List;
import java.util.UUID;

import com.example.springMVC.model.Customer;

public interface CustomerService {
    
    public Customer getCustomerById(UUID id);

    public List<Customer> listACustomers();
}
