package com.sasanka.profileservice.service;

import com.sasanka.profileservice.repository.CustomerRepository;
import commons.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        Optional<Customer> byId = customerRepository.findById(id);
        if (byId.isPresent()){
            return byId.get();
        }
        return null;
    }
}
