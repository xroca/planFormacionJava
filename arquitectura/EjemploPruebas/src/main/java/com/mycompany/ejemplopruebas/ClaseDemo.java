/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplopruebas;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khepherer
 */
public class ClaseDemo {

    private String nombre;

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

    public void forzarExcepcion() {
        throw new RuntimeException("Error provocado");
    }
    
    public void forzarTimeOut(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ClaseDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
