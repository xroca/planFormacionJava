/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.filtros;

import org.springframework.stereotype.Component;

/**
 *
 * @author usuario
 */
@Component
public class Cualquiera {

    public Cualquiera() {
        System.out.println("En el constructor de " + getClass().getName());
    }
    
}
