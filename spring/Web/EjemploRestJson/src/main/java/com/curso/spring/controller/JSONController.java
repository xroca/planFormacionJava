package com.curso.spring.controller;

import com.curso.spring.model.Tienda;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso/spring")
public class JSONController {

    @RequestMapping(value = "{nombre}", method = RequestMethod.GET)
    public Tienda getShopInJSON(@PathVariable String nombre) {

        Tienda tienda = new Tienda();
        tienda.setNombre(nombre);
        tienda.setComerciales(new String[]{"Uno", "dos"});

        return tienda;

    }

}
