/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplocapas.util;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iconotc
 */
public class Aritmetica {

    public Double media(List<Double> numeros) {
        if (numeros == null) {
            throw new IllegalArgumentException("La lista es nula");
        }
        if (numeros.isEmpty()) {
            throw new IllegalArgumentException("La lista está vacía");
        }        
        if (numeros.stream().filter(n -> n < 0).count() != 0) {
            throw new RuntimeException("La lista tiene valores negativos");
        }
        return numeros
                .stream()
                .reduce(0.0, (a, b) -> a + b) / numeros.size();

    }
    public Integer forzarTimeout(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aritmetica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
