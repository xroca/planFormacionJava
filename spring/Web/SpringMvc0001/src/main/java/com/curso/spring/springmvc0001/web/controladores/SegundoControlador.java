/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.spring.springmvc0001.web.controladores;

import com.curso.spring.springmvc0001.modelo.Persona;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author jose maria
 */
public class SegundoControlador implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        String nombre = request.getParameter("nombre");
        if (nombre == null) {
            throw new ServletException("El nombre es obligatorio");
        }
        Integer contador = 1;
        Persona persona = new Persona();
        persona.setNombre(nombre);
        String fecha = request.getParameter("fecha");
        if (fecha != null && fecha.equals("true")) {
            persona.setFecha(new Date());
            contador++;
        }
        mav.addObject("contador",contador);
        mav.addObject("persona", persona);
        return mav;
    }

}
