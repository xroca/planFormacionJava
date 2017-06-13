/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.controladores;

import com.curso.spring.beans.Persona;
import com.curso.spring.servicio.ServicioPersona;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Chema
 */
@Controller
@RequestMapping("/cuarta.html")
@SessionAttributes("persona")
public class ControladorFormulario {

    @Autowired
    private ServicioPersona servicioPersona;
    @Autowired
    private Persona persona;

    @ModelAttribute("persona")
    public Persona getPersona() {
        return persona;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String manejadorGet() {
        return "formulario";
    }

    @ExceptionHandler(BindException.class)
    public ModelAndView enCasoDeError(BindException e) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("excepcion", e);
        FieldError errorNombre = e.getFieldError("nombre");
        mav.addObject("errorNombre", errorNombre.getField() == null ? "Sin errores" : errorNombre.getDefaultMessage());
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String procesarFormulario(@Valid @ModelAttribute("persona") Persona persona,SessionStatus estado, Model modelo) {
        servicioPersona.salvar(persona);
        modelo.addAttribute("personas",servicioPersona.todos());
        estado.setComplete();
        return "todobien";
    }   
}
