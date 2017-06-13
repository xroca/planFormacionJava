/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemplostreams.utilidades;

import com.curso.ejemplostreams.modelo.Persona;
import static com.curso.ejemplostreams.utilidades.Util.*;
import java.util.Arrays;
import static java.util.Collections.emptyList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class UtilidadesTest {

    @Test
    public void testPersonasSingleton() {
        assertEquals(toLista(personas(1, 1)), Arrays.asList(Persona.of("Nombre1", 1,emptyList())));
    }

    @Test
    public void testPersonasConParametros() {
        assertEquals(toLista(personas(1, 10)), toLista(personas(10, 1)));
    }

    @Test(expected = NullPointerException.class)
    public void testPersonasParametro1Null() {
        personas(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void testPersonasParametro2Null() {
        personas(10, null);
    }
}
