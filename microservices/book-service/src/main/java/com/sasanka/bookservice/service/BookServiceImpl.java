package com.sasanka.bookservice.service;

import com.sasanka.bookservice.repository.BookRepository;
import commons.model.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        Optional<Book> byId = bookRepository.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }
        return null;
    }
}
