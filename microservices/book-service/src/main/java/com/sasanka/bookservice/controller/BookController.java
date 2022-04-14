package com.sasanka.bookservice.controller;

import com.sasanka.bookservice.service.BookService;
import commons.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Book save(@RequestBody Book book){
        return bookService.save(book);
    }
}
