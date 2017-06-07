/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_maven;

import java.util.List;

/**
 *
 * @author xrocal
 */
class Persona {
    
    
    private String dni;
    private String nombre;
    private String apellidos;
    private int edat;
    
    private Persona(){}

    public Persona(String dni, String nombre, String apellidos, int edat) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edat = edat;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdat() {
        return edat;
    }

    
    
    
    
    
    
    
    
}
