/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servicepersona.ws;

/**
 *
 * @author xrocal
 */
public class Persona {
    
    
   
    private String nombre;
    private String apellidos;
    private int edat;
    
    

    public Persona(){
        
        
        this.nombre = "aaa";
        this.apellidos = "aaaaa";
        this.edat = 15;
    
    
    }

    public Persona(String nombre, String apellidos, int edat) {
        
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edat = edat;
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

   

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    @Override
    public String toString() {
        return "Persona{" + " nombre=" + nombre + ", apellidos=" + apellidos + ", edat=" + edat + '}';
    }
    
    
    
    
    
}
