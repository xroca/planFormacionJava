/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplocapas.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author iconotc
 */
public class AritmeticaTest {

    private Aritmetica instancia;

    @Before
    public void init() {
        instancia = new Aritmetica();
    }

    @Test(timeout = 1000)
    public void forzarTimeoutTest() {
        System.out.println("Forzar un timeout");
        int resultado = instancia.forzarTimeout();
        assertEquals(0, resultado);
    }

    @Test
    public void testMediaValoresOk() {
        System.out.println("Media con valores correctos");
        List<Double> numeros = Arrays.asList(2.0, 2.0, 2.0);
        Double expResult = 2.0;
        Double result = instancia.media(numeros);
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMediaListaNula() {
        System.out.println("Media con lista nula");
        List<Double> numeros = null;
        instancia.media(numeros);
    }

    @Test(expected = RuntimeException.class)
    public void testMediaValoresNegativos() {
        System.out.println("Media con valores negativos");
        List<Double> numeros = Arrays.asList(1.0, -1.0);
        instancia.media(numeros);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMediaListaVacia() {
        System.out.println("Media con la lista sin valores");
        List<Double> numeros = new ArrayList<>();
        instancia.media(numeros);
    }
}
