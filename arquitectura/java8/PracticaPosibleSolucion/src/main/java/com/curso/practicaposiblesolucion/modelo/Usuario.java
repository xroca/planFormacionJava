/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.practicaposiblesolucion.modelo;

import java.util.Objects;

/**
 *
 * @author formacioncoruna
 */
public class Usuario {

    private final String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }   

    public Usuario conNombre(String nuevoNombre){
        return new Usuario(nuevoNombre);
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + '}';
    }

}
