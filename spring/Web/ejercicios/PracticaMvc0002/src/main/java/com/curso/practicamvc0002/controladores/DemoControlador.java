/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.practicamvc0002.controladores;

import com.curso.practicamvc0002.Ejemplo;
import com.curso.practicamvc0002.modelo.Usuario;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author usuario
 */
@Ejemplo
@Controller
@RequestMapping("/formulario")
public class DemoControlador {
   
    @ModelAttribute("usuario")
    public Usuario daIgual() {
        return new Usuario();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String daIgual1() {
        return "formulario";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String daIgual2(@ModelAttribute("usuario") @Valid Usuario u, BindingResult result, Model m) {
        if (result.hasErrors()) {
            return "formulario";
        } else {
            m.addAttribute("nombre", u.getNombre());
            return "fin";
        }
    }
}
