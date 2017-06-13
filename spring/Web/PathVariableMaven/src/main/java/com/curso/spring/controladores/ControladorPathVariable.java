/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Chema
 */
@Controller
public class ControladorPathVariable {

    @RequestMapping(value = "/clientes/{idCliente}/factura/{idFactura}", method = RequestMethod.GET)
    public String ejemploPathVariable(@PathVariable Long idCliente, @PathVariable Long idFactura, Model modelo) {
        modelo.addAttribute("idCliente", idCliente).addAttribute("idFactura", idFactura);
        return "pathvariable";
    }
}
