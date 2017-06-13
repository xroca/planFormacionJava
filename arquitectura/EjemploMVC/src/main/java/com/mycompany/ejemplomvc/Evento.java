/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplomvc;

/**
 *
 * @author usuario
 */
public class Evento {
private final String texto;

    public Evento(String texto) {
        this.texto = texto;
    }
    public String info() {
        return texto + System.currentTimeMillis();
    }

}
