/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servicepersona.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author xrocal
 */
@WebService(serviceName = "webServicePersona")
public class webServicePersona {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "crearPersona")
    public Persona crearPersona(
            @WebParam(name = "nombre") String nombre ,
            @WebParam(name = "apellidos") String apellidos,
            @WebParam(name = "edad") int edad) {
        
        Persona p = new Persona();
        
        p.setNombre(nombre);
        p.setApellidos(apellidos);
        p.setEdat(edad);
        
        
        
        return p;
    }
}
