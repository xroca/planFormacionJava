/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.minimoanotaciones.controladores;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author usuario
 */
@Controller
public class Controlador {

    @RequestMapping("/")
    public String daIgual() {
        return "index";
    }

    @RequestMapping("/demo")
    public void demo(Model modelo) {
        modelo.addAttribute("fecha", new Date());
    }
}
