/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aritmetica_ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author xrocal
 */
public class aritmetica_junit {
    
    
    private Aritmetica instancia;
    
    public aritmetica_junit() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    
   @Test(expected = IllegalArgumentException.class)
    public void testMediaListaVacia() {
        System.out.println("Media con la lista sin valores");
        List<Double> numeros = new ArrayList<>();
        instancia.media(numeros);
    }
    
    
    @Test
    public void mediaAritmetica() {
        instancia = new Aritmetica();
        System.out.println("mediaAritmetica - resultado");
        List<Double> numeros = Arrays.asList(1.0, 2.0, 3.0);
        Double expResult = 2.0;
        Double result = instancia.media(numeros);
        assertEquals(expResult, result);

    }
}
