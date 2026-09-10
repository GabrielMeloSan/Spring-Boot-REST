package com.gabriel.Spring_Boot_REST.controllers;

import com.gabriel.Spring_Boot_REST.PersonServices;
import com.gabriel.Spring_Boot_REST.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    @RequestMapping(value = "/{id}",
            method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person findById(@PathVariable("id") String id){
        return service.findById(id);
    }
}
