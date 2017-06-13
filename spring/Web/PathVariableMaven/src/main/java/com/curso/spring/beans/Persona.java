/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.beans;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Chema
 */
@Scope("prototype")
@Component
public class Persona implements Serializable {

    @Value("#{propiedades.primera}")
    @NotNull(message="El nombre de la persona no puede ser nulo")
    @Size(max=5,message="La longitud máxima del nombre es de 5 caracteres")   
    private String nombre;
    @Value("#{propiedades.segunda}")
    @NotNull
    private String apellido;

    public Persona() {
    }

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
