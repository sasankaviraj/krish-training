package com.sasanka.demoapp.repository;

import com.sasanka.demoapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
