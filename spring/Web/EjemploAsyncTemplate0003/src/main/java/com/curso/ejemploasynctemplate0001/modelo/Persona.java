/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemploasynctemplate0001.modelo;

/**
 *
 * @author usuario
 */
public class Persona {
    
    private String nombre;

    private Integer telefono;

    public Persona() {
        this("Nombre por defecto",123);
    }

    public Persona(String nombre, Integer telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    /**
     * Get the value of telefono
     *
     * @return the value of telefono
     */
    public Integer getTelefono() {
        return telefono;
    }

    /**
     * Set the value of telefono
     *
     * @param telefono new value of telefono
     */
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
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
