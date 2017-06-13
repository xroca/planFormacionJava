/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.lambdas.interfaces;

/**
 *
 * @author Chema
 */
public class UsoSupplier {

    private String computacionCompleja() {
        return "abc";
    }
    EjemploSupplierDecorator s = new EjemploSupplierDecorator();

    public void testLog() {
        s.debug(() -> "Ejecución de " + computacionCompleja());
    }
}
