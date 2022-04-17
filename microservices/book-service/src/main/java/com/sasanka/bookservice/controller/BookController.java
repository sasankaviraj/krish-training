package com.sasanka.bookservice.controller;

import com.sasanka.bookservice.service.BookService;
import commons.model.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Book save(@RequestBody Book book){
        return bookService.save(book);
    }

    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public Book findById(@PathVariable("id") Integer id){
        return bookService.findById(id);
    }

}
