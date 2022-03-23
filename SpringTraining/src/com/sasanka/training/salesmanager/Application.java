package com.sasanka.training.salesmanager;

import com.sasanka.training.salesmanager.model.Employee;
import com.sasanka.training.salesmanager.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = applicationContext.getBean("employeeService", EmployeeService.class);
        List<Employee> employees = employeeService.getEmployees();
        for (Employee employee:employees) {
            System.out.println(employee.getEmployeeName()+" at "+employee.getEmployeeLocation());
        }
    }
}
