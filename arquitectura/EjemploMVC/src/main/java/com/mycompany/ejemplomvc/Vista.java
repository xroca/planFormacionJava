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
public class Vista {

    private final Controlador controlador;

    public Vista(Controlador controlador) {
        this.controlador = controlador;
        this.controlador.nueva(this);
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void signal(Evento e) {
        controlador.llamar(e);
    }

    public void respuesta(String info) {
        System.out.println("Vista " + this);
        System.out.println("El controlador ha respondido con " + info);
    }
}
