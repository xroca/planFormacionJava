/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.practicamvc0002.controladores;

import com.curso.practicamvc0002.Ejemplo;
import com.curso.practicamvc0002.NombreValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 *
 * @author usuario
 */
@ControllerAdvice(annotations = Ejemplo.class)
public class CAdvice {

    @Autowired
    private NombreValidator nombreValidator;

    @InitBinder
    public void x(WebDataBinder w) {
        w.addValidators(nombreValidator);
    }
}
