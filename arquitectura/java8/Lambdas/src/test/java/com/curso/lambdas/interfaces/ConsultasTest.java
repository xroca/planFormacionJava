/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.lambdas.interfaces;

import com.curso.lambdas.modelo.Pista;
import com.curso.lambdas.streams.Consultas;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author formacioncoruna
 */
public class ConsultasTest {

    private Consultas c;

    @Before
    public void init() {
        c = new Consultas();
    }

    @Test
    public void laPistaMasCortaTest() {
        Pista p = c.laPistaMasCorta();
        assertEquals((Integer) 378, p.getLongitud());
    }

    @Test
    public void ejemploReduce1Ttest() {
        assertEquals((Integer) 6, c.ejemploReduce1());
    }

    @Test
    public void ejemploReduce2Ttest() {
        assertEquals((Integer) 6, c.ejemploReduceMr());
    }
}
