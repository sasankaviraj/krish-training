package com.sasanka.demoapp.controller;

import com.sasanka.demoapp.model.Student;
import com.sasanka.demoapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {
    @Autowired
    StudentService studentService;
    @RequestMapping("/")
    public String greetings(){
        return "Welcome to Spring Boot Microservices";
    }

    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public ResponseEntity<Student> fetchStudent(@RequestParam int id){
        Student student = studentService.fetchStudentById(id);
        if(student==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(student);
        }
    }
}
