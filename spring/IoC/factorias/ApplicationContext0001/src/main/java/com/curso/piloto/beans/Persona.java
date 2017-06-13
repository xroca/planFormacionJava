/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.piloto.beans;

import java.io.Serializable;

/**
 *
 * @author usuario
 */
public class Persona implements Serializable {

    private String nombre;

    private Aficion aficion;

    public Persona() {
    }

    public Persona(String nombre, Aficion aficion) {
        this.nombre = nombre;
        this.aficion = aficion;
    }

    /**
     * Get the value of aficion
     *
     * @return the value of aficion
     */
    public Aficion getAficion() {
        return aficion;
    }

    /**
     * Set the value of aficion
     *
     * @param aficion new value of aficion
     */
    public void setAficion(Aficion aficion) {
        this.aficion = aficion;
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

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", aficion=" + aficion + '}';
    }

}
