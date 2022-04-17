package com.sasanka.libraryservice.model;

import commons.model.book.Book;
import commons.model.customer.Customer;
import commons.model.library.Library;

public class DetailResponse implements Response{

    private Library library;
    private Customer customer;
    private Book book;

    public DetailResponse(Library library, Customer customer, Book book) {
        this.library = library;
        this.customer = customer;
        this.book = book;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
