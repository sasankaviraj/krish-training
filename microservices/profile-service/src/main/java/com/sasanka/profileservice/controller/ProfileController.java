package com.sasanka.profileservice.controller;

import com.sasanka.profileservice.service.CustomerService;
import commons.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/profile")
public class ProfileController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Customer save(@RequestBody Customer customer){
        return customerService.save(customer);
    }
}
