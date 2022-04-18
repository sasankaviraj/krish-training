package com.sasanka.libraryservice.service;

import com.netflix.hystrix.HystrixCommand;
import com.sasanka.libraryservice.hystrix.BookCommand;
import com.sasanka.libraryservice.hystrix.CommonHystrixCommand;
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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HystrixCommand.Setter setter;

    @Override
    public Library save(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public Library findById(Integer id) {
        Optional<Library> byId = libraryRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        return null;
    }

    @Override
    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    @Override
    public DetailResponse findDetailResponse(Integer id) throws ExecutionException, InterruptedException {
        Optional<Library> byId = libraryRepository.findById(id);
        if (byId.isPresent()) {
            Customer customer = getCustomer(byId.get().getCustomerId());
            Book book = getBook(byId.get().getBookId());
            return new DetailResponse(byId.get(), customer, book);
        }
        return null;


    }

    private Customer getCustomer(int customerId) throws ExecutionException, InterruptedException {
        //        return restTemplate.getForObject("http://profile/profile/find/"+customerId,Customer.class);

        // to use circuit breaker with a common hystrixcommand without creating command classes for every object
        CommonHystrixCommand<Customer> customerCommonHystrixCommand = new CommonHystrixCommand<Customer>(
                setter,
                () -> {
                    return restTemplate.getForObject("http://profile/profile/find/" + customerId, Customer.class);
                },
                () -> {
                    return new Customer();
                }
        );
        Future<Customer> customerFuture = customerCommonHystrixCommand.queue();
        return customerFuture.get();
    }

    private Book getBook(int bookId) throws ExecutionException, InterruptedException {
        //creating conmmand class for evey object
//        BookCommand bookCommand = new BookCommand(restTemplate, bookId);
//        return bookCommand.execute();
//        return restTemplate.getForObject("http://book/book/find/" +bookId,Book.class);

        CommonHystrixCommand<Book> bookCommonHystrixCommand = new CommonHystrixCommand<Book>(
                setter,
                () -> {
                    return restTemplate.getForObject("http://book/book/find/" +bookId,Book.class);
                },
                () -> {
                    return new Book();
                }
        );
        Future<Book> bookFuture = bookCommonHystrixCommand.queue();
        return bookFuture.get();
    }
}
