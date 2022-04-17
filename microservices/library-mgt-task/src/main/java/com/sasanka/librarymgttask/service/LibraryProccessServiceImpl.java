package com.sasanka.librarymgttask.service;

import org.springframework.stereotype.Service;

@Service
public class LibraryProccessServiceImpl implements LibraryProccessService{
    @Override
    public boolean validateDL(String dlNumber) {
        return dlNumber.length()>5;
    }
}
