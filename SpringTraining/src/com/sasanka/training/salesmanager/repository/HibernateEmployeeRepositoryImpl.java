package com.sasanka.training.salesmanager.repository;

import com.sasanka.training.salesmanager.model.Employee;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

public class HibernateEmployeeRepositoryImpl implements EmployeeRepository {

    @Value("${name}")
    private String name;
    @Value("${city}")
    private String city;
    @Override
    public List<Employee> getAllEmployees(){
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = new Employee();
        employee.setEmployeeName(name);
        employee.setEmployeeLocation(city);
        employeeList.add(employee);
        return employeeList;
    }
}
