/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplojdbc.modelo;

/**
 *
 * @author iconotc
 */
public class Persona {
    
    private String nombre;

    private Integer id;

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", id=" + id + '}';
    }

    public Persona(Integer id, String nombre ) {
        this.nombre = nombre;
        this.id = id;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(Integer id) {
        this.id = id;
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
