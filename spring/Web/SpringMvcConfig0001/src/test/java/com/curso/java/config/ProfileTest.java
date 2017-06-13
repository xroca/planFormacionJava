/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.config;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author jose maria
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProfileConfig.class)
@ActiveProfiles(profiles = "pruebas")
public class ProfileTest {

    @Autowired
    private SimpleBean simpleBean;
    
    @Test
    public void testBeanExiste() {
        assertNotNull(simpleBean);
    }
}
