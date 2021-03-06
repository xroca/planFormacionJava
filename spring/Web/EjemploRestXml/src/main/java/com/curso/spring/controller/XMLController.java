package com.curso.spring.controller;

import com.curso.spring.model.Cafe;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cafe")
public class XMLController {

    @RequestMapping(value = "{nombre}", method = RequestMethod.GET)
    public Cafe getCafeEnXML(@PathVariable String nombre) {
        return new Cafe(nombre, 100);
    }
}