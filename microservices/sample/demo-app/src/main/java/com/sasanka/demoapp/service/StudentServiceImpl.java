package com.sasanka.demoapp.service;

import com.sasanka.demoapp.model.Student;
import com.sasanka.demoapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;
    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student fetchStudentById(int id) {
        Optional<Student> byId = studentRepository.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }
        return null;
    }

}
