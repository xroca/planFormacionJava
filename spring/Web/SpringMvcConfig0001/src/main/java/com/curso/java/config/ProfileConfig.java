/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author jose maria
 */
@Configuration
@Profile("pruebas")
public class ProfileConfig {

    @Bean
    public SimpleBean simpleBean() {
        SimpleBean simpleBean = new SimpleBean();
        simpleBean.setNombre("Test");
        return simpleBean;
    }
}

class SimpleBean {

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}