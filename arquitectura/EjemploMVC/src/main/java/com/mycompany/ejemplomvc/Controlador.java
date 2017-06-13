/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplomvc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class Controlador {
    
    private final Servicio s;
    private final List<Vista> vistas;
    
    public Controlador() {
        this.vistas = new ArrayList<>();
        this.s = new Servicio();
    }
    
    void llamar(Evento e) {
        String contenido = e.info();
        Double d = s.ejecutar(contenido);
        vistas.forEach(v -> v.respuesta(d.toString()));
    }
    
    Vista nueva(Vista v) {
        vistas.add(v);
        return v;
    }
}
