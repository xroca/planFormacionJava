/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.lambdas.interfaces;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chema
 */
public class UsoInterfazGenericaTest {

    private UsoInterfazGenerica u;

    public UsoInterfazGenericaTest() {
    }

    @Before
    public void setUp() {
        u = new UsoInterfazGenerica();
    }

    /**
     * Test of metodo method, of class UsoInterfazFuncional.
     */
    @Test
    public void testMetodo() {
        assertEquals(u.metodo(numero -> numero.toString(), 12), "El valor es 12");
        assertEquals(u.metodo(argumento -> "Resultado: " + argumento * 2, 12), "El valor es Resultado: 24");
    }

    @Test
    public void splitterTest() {
        Funcion<String, List<String>> splitter = u.getSplitter();
        String texto = "uno\ndos";
        List<String> asList = Arrays.asList("uno", "dos");
        assertEquals(splitter.aplicar(texto), asList);
    }

}
