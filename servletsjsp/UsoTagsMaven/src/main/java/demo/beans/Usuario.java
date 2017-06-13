/*
 * Usuario.java
 *
 * Created on 10-sep-2007, 20:14:21
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demo.beans;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class Usuario implements Serializable {

    private Long id;
    private String nombre;
    private String clave;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
    }
}
