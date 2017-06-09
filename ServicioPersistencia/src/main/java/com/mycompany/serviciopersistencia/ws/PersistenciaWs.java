/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.serviciopersistencia.ws;

import com.mycompany.serviciopersistencia.modelo.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author xrocal
 */
@WebService(serviceName = "PersistenciaWs")
@Stateless
public class PersistenciaWs {

    @PersistenceContext
    private EntityManager em;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    public Persona crear(String nombre) {

        Persona p = new Persona(nombre);

        em.persist(p);

        return p;
    }

    public List<Persona> todos() {

        return em.createQuery("select p from Persona p").getResultList();

    }

}
