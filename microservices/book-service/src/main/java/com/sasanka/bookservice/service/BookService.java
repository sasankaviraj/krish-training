package com.sasanka.bookservice.service;

import commons.model.book.Book;

import java.util.List;

public interface BookService {

    Book save(Book book);

    List<Book> findAll();

    Book findById(Integer id);
}
