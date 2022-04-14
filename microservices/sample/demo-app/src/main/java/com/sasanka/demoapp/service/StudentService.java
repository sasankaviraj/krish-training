package com.sasanka.demoapp.service;

import com.sasanka.demoapp.model.Student;

public interface StudentService {

    Student save(Student student);

    public Student fetchStudentById(int id);
}
