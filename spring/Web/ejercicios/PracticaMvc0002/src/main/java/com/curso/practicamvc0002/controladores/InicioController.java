/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.practicamvc0002.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author usuario
 */
@Controller
public class InicioController {

    @RequestMapping("/")
    public String daIgual() {
        return "index";
    }
}
