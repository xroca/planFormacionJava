/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplopruebas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author khepherer
 */
public class DemoJUnitTest {

    private ClaseDemo demo;

    public DemoJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Antes de todos los tests");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Después de todos los tests");
    }

    @Before
    public void setUp() {
        System.out.println("Antes de cada test");
        demo = new ClaseDemo();
    }

    @After
    public void tearDown() {
        System.out.println("Después de cada test");
    }

    @Test
    public void nombreNuloTest() {
        System.out.println("En nombreNuloTest");
        assertNull(demo.getNombre());
    }

    @Test(expected = RuntimeException.class)
    public void forzarExcepcionTest() {
        System.out.println("En forzarExcepcionTest");
        demo.forzarExcepcion();
    }

    @Test(timeout = 3000L)
    public void forzarTimeoutTest() {
        System.out.println("En forzarTimeoutTest");
        demo.forzarTimeOut();
    }
}
