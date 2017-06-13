/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.lambdas.interfaces;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chema
 */
public class UsoInterfazFuncionalTest {

    private UsoInterfazFuncional u;

    public UsoInterfazFuncionalTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        u = new UsoInterfazFuncional();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of metodo method, of class UsoInterfazFuncional.
     */
    @Test
    public void testMetodo() {
        assertEquals(u.metodo(numero -> numero.toString(), 12), "El valor es 12");
        assertEquals(u.metodo(argumento -> "Resultado: " + argumento * 2, 12), "El valor es Resultado: 24");
    }

    /**
     * Test of metodo1 method, of class UsoInterfazFuncional.
     */
    @Test
    public void testMetodo1() {
        InterfazFuncional i = u.metodo1(10);
        assertEquals(u.metodo(i, 10), "El valor es 100");
    }

}
