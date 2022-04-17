package com.sasanka.profileservice.controller;

import com.sasanka.profileservice.service.CustomerService;
import commons.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profile")
public class ProfileController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('create_profile')")
    public Customer save(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @RequestMapping(value = "/find",method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_admin')")
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public Customer findById(@PathVariable("id") Integer id){
        return customerService.findById(id);
    }
}
