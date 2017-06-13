/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemplomicroservicio;

import com.curso.ejemplomicroservicio.modelo.Persona;
import java.util.Random;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author usuario
 */
@EnableAutoConfiguration
@Controller
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String... args) {
        SpringApplication.run(Principal.class, args);
    }

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Mensaje desde un microservicio";
    }

    @RequestMapping("/ver")
    @ResponseBody
    public Persona ver() {
        return new Persona("Nombre" + System.currentTimeMillis(), new Random().nextInt());
    }
}
