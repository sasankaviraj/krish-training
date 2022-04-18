package com.sasanka.libraryservice.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import commons.model.book.Book;
import org.springframework.web.client.RestTemplate;

public class BookCommand extends HystrixCommand<Book> {

    private RestTemplate restTemplate;
    private int bookId;

    public BookCommand(RestTemplate restTemplate,int bookId){
        super(HystrixCommandGroupKey.Factory.asKey("default"));
        this.restTemplate = restTemplate;
        this.bookId = bookId;

    }

    @Override
    protected Book run() throws Exception {
        return restTemplate.getForObject("http://book/book/find/" +bookId,Book.class);
    }

    @Override
    protected Book getFallback() {
        return new Book();
    }
}
