/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.practicamvc0001.controladores;

import com.curso.practicamvc0001.NombreValidator;
import com.curso.practicamvc0001.modelo.Usuario;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author usuario
 */
@Controller
@RequestMapping("/formulario")
public class DemoControlador {

    @Autowired
    private NombreValidator nombreValidator;

    @InitBinder
    public void x(WebDataBinder w){
        w.setValidator(nombreValidator);
    }
    
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
