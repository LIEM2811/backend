package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.Customer;

public interface CustomerService {
    Customer createCustomer(Customer customer);

    Customer getCustomerById(UUID id);

    List<Customer> getAllCustomers();

    Customer updateCustomer(UUID id, Customer customer);

    void deleteCustomer(UUID id);
}
