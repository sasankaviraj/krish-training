package com.sasanka.libraryservice.service;

import com.sasanka.libraryservice.model.DetailResponse;
import commons.model.library.Library;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface LibraryService {

    Library save(Library library);

    Library findById(Integer id);

    List<Library> findAll();

    DetailResponse findDetailResponse(Integer id) throws ExecutionException, InterruptedException;
}
