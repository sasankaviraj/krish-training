package com.sasanka.training.salesmanager.repository;

import com.sasanka.training.salesmanager.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getAllEmployees();
}
