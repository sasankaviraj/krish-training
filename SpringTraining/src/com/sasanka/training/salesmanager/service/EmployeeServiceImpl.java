package com.sasanka.training.salesmanager.service;

import com.sasanka.training.salesmanager.model.Employee;
import com.sasanka.training.salesmanager.repository.EmployeeRepository;
import com.sasanka.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {


    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        System.out.println("Overloaded constructor executed");
        this.employeeRepository = employeeRepository;
    }

    public EmployeeServiceImpl() {
        System.out.println("Default constructor executed");
    }

    @Override
    public List<Employee>  getEmployees(){
        return employeeRepository.getAllEmployees();
    }
    @Autowired
    public void setEmployeeRepository(HibernateEmployeeRepositoryImpl employeeRepository) {
        System.out.println("Setter executed");
        this.employeeRepository = employeeRepository;
    }
}
