/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.serveisoap.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.Persona;

/**
 *
 * @author xrocal
 */
@WebService(serviceName = "serveiSoap")
public class serveiSoap {

    /**
     * This is a sample web service operation
     * @param id
     * @param nombre
     * @return 
     */
    @WebMethod(operationName = "crearPersona")
    public Persona crearPersona(
            @WebParam(name = "id") Long id,
            @WebParam(name = "nombre") String nombre) {
        
        Persona p = new Persona();
        
        p.setId(id);
        p.setNombre(nombre);
        
        
        return p;
    }
}
