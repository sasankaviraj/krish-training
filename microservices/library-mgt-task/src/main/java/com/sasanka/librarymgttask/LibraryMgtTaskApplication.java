package com.sasanka.librarymgttask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;

@SpringBootApplication
@EnableTask
public class LibraryMgtTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryMgtTaskApplication.class, args);
    }

}
