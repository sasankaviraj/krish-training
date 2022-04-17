package com.sasanka.libraryservice.controller;

import com.sasanka.libraryservice.model.Response;
import com.sasanka.libraryservice.model.SimpleResponse;
import com.sasanka.libraryservice.service.LibraryService;
import commons.model.library.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Library save(@RequestBody Library library){
        return libraryService.save(library);
    }

    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public List<Library> findAll(){
        return libraryService.findAll();
    }

    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public Response findById(@PathVariable("id") Integer id, @RequestParam(required = false) String type){
        //if type is not there we will only return library model, else type is full we'll return with customer and book model

        if(type==null){
            return new SimpleResponse(libraryService.findById(id));
        }else{
            return libraryService.findDetailResponse(id);
        }
    }
}
