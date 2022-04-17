package com.sasanka.libraryservice.model;

import commons.model.library.Library;

public class SimpleResponse implements Response{

    private Library library;

    public SimpleResponse(Library library) {
        this.library = library;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
