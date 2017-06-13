/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.spring.springmvc0001.web.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author jose maria
 */
public class PrimerControlador implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return new ModelAndView("primera");
    }
}
