package com.sasanka.profileservice.service;

import commons.model.customer.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer save(Customer customer);

    List<Customer> findAll();

    Customer findById(Integer id);
}
