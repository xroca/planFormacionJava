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
public class Usuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controlador c = new Controlador();
        Vista vista1 = new Vista(c);
        Vista vista2 = new Vista(c);
        Evento evento = new Evento("abc");
        String info = evento.info();
        vista1.signal(evento);
        vista2.signal(new Evento("xyz"));
    }

}
