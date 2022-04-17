package com.sasanka.librarymgttask.runner;

import com.sasanka.librarymgttask.service.LibraryProccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LibraryProccessTaskRunner implements CommandLineRunner {

    @Autowired
    private LibraryProccessService libraryProccessService;
    @Override
    public void run(String... args) throws Exception {
        if (args.length>0) {
            System.out.println("Task running with arguments");
            if (libraryProccessService.validateDL(args[0])) {
                System.out.println("Valid license");
            } else {
                System.out.println("Invalid license");
            }
        }
        else{
            System.out.println("Task running without arguments");
        }
    }
}
