/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.springmvc0001.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jose maria
 */
public class Persona implements Serializable {

    private String nombre;
    private Date fecha;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
