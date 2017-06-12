/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplorestuno;

import com.mycompany.ejemplorestuno.modelo.Persona;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author xrocal
 */
@Path("ruta")
public class RutaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RutaResource
     */
    public RutaResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.ejemplorestuno.RutaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Persona getXml() {
        //TODO return proper representation object
        return new Persona(1000L,"Xavier");
    }

    /**
     * PUT method for updating or creating an instance of RutaResource
     * @param content representation for the resource
     * @return 
     */
   
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Persona putXml(Persona content) {
        
        System.out.println("Persona: "+content.toString());
        
        return content;
    }
}
