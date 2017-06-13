/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.springmvc0001.web.controladores;

import com.curso.spring.springmvc0001.modelo.Persona;
import java.util.Map;
import javax.servlet.ServletException;
import org.springframework.mock.web.MockHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jose maria
 */
public class SegundoControladorTest {

    private static final String CONTADOR = "contador";
    private static final String FECHA = "fecha";
    private static final String NOMBRE = "nombre";
    private static final String PERSONA = "persona";
    private static final String VALOR_NOMBRE = "abc";
    private SegundoControlador controlador;
    private MockHttpServletRequest request;
    private HttpServletResponse response = new MockHttpServletResponse();

    @Before
    public void inicializar() {
        controlador = new SegundoControlador();
        request = new MockHttpServletRequest();
    }

    /**
     * Test of handleRequest method, of class SegundoControlador.
     */
    @Test
    public void todoOk() throws Exception {
        System.out.println("todoOk en clase SegundoControladorTest");
        request.setParameter(NOMBRE, VALOR_NOMBRE);
        request.setParameter(FECHA, "true");
        ModelAndView resultado = controlador.handleRequest(request, response);
        Map<String, Object> modelo = resultado.getModel();
        assertEquals(modelo.get(CONTADOR), (Integer) 2);
        Persona persona = (Persona) modelo.get(PERSONA);
        assertEquals(persona.getNombre(), VALOR_NOMBRE);
        assertNotNull(persona.getFecha());
    }

    @Test(expected = ServletException.class)
    public void noHayNombre() throws Exception {
        System.out.println("noHayNombre en clase SegundoControladorTest");
        controlador.handleRequest(request, response);
    }

    @Test
    public void fechaNoValeTrue() throws Exception {
        System.out.println("fechaNoValeTrue en clase SegundoControladorTest");
        request.setParameter(NOMBRE, VALOR_NOMBRE);
        request.setParameter(FECHA, "da igual");
        ModelAndView resultado = controlador.handleRequest(request, response);
        Map<String, Object> modelo = resultado.getModel();
        assertEquals(modelo.get(CONTADOR), (Integer) 1);
        Persona persona = (Persona) modelo.get(PERSONA);
        assertEquals(persona.getNombre(), VALOR_NOMBRE);
        assertNull(persona.getFecha());
    }

    @Test
    public void noHayFecha() throws Exception {
        System.out.println("noHayFecha en clase SegundoControladorTest");
        request.setParameter(NOMBRE, VALOR_NOMBRE);
        ModelAndView resultado = controlador.handleRequest(request, response);
        Map<String, Object> modelo = resultado.getModel();
        assertEquals(modelo.get(CONTADOR), (Integer) 1);
        Persona persona = (Persona) modelo.get(PERSONA);
        assertEquals(persona.getNombre(), VALOR_NOMBRE);
        assertNull(persona.getFecha());
    }
}
