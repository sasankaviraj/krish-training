package com.sasanka.libraryservice.service;

import com.sasanka.libraryservice.model.DetailResponse;
import com.sasanka.libraryservice.repository.LibraryRepository;
import commons.model.book.Book;
import commons.model.customer.Customer;
import commons.model.library.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService{

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public Library save(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public Library findById(Integer id) {
        Optional<Library> byId = libraryRepository.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }
        return null;
    }

    @Override
    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    @Override
    public DetailResponse findDetailResponse(Integer id) {
        Optional<Library> byId = libraryRepository.findById(id);
        if(byId.isPresent()){
            Customer customer = getCustomer(byId.get().getCustomerId());
            Book book = getBook(byId.get().getBookId());
            return new DetailResponse(byId.get(),customer,book);
        }
        return null;


    }

    private Customer getCustomer(int customerId){
        return restTemplate.getForObject("http://localhost:9191/profile/find/"+customerId,Customer.class);
    }

    private Book getBook(int bookId){
        return restTemplate.getForObject("http://localhost:9192/book/find/"+bookId,Book.class);
    }
}
