package com.sasanka.training.salesmanager.config;

import com.sasanka.training.salesmanager.repository.EmployeeRepository;
import com.sasanka.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import com.sasanka.training.salesmanager.service.EmployeeService;
import com.sasanka.training.salesmanager.service.EmployeeServiceImpl;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("com.sasanka")
@PropertySource("application.properties")
public class ApplicationConfiguration {

    @Bean(name = "employeeService")
    @Scope("singleton")
    public EmployeeService getEmployeeService(){
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.setEmployeeRepository((HibernateEmployeeRepositoryImpl) getEmployeeRepository());
        return new EmployeeServiceImpl();
    }

    @Bean(name = "employeeRepository")
    public EmployeeRepository getEmployeeRepository(){
        return new HibernateEmployeeRepositoryImpl();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
