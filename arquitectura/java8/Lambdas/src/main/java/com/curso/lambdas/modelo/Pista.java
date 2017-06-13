/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.lambdas.modelo;

/**
 *
 * @author Chema
 */
public class Pista {
   
    private String nombre;

    private Integer longitud;

    public Pista(String nombre, Integer longitud) {
        this.nombre = nombre;
        this.longitud = longitud;
    }

    /**
     * Get the value of longitud
     *
     * @return the value of longitud
     */
    public Integer getLongitud() {
        return longitud;
    }

    /**
     * Set the value of longitud
     *
     * @param longitud new value of longitud
     */
    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
}
