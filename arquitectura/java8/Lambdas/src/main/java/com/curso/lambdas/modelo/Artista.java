/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.lambdas.modelo;

import java.util.Set;

/**
 *
 * @author Chema
 */
public class Artista {

    private String nombre;

    private String origen;

    private Set<Artista> miembros;

    public Boolean esDe(String ciudad) {
        return origen.equals(ciudad);
    }

    public Boolean estaSolo() {
        return miembros.isEmpty();
    }

    /**
     * Get the value of miembros
     *
     * @return the value of miembros
     */
    public Set<Artista> getMiembros() {
        return miembros;
    }

    /**
     * Set the value of miembros
     *
     * @param miembros new value of miembros
     */
    public void setMiembros(Set<Artista> miembros) {
        this.miembros = miembros;
    }

    /**
     * Get the value of origen
     *
     * @return the value of origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * Set the value of origen
     *
     * @param origen new value of origen
     */
    public void setOrigen(String origen) {
        this.origen = origen;
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
