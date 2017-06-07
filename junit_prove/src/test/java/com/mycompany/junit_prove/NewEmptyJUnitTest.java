/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.junit_prove;

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
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
    }
    
    
    private Demo d;
    
    @BeforeClass
    public static void setUpClass() {
        
        System.out.println("En BeforeClass");
        
       Demo d = new Demo();
        
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        
        System.out.println("En AfterClass");
    }
    
    @Before
    public void setUp() {
        
        System.out.println("En Before");
    }
    
    @After
    public void tearDown() {
        
        System.out.println("En After");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void getNombreTest() {
     
         System.out.println("Aaaaaaaaaaaaa");
         
         d = new Demo();
         
         assertNull(d.getNombre());
   
     }
     
     
     @Test
     public void metodoIntegerTest() {
     
         System.out.println("En metodoIntegerTest");
         
         Demo d = new Demo();
         
         assertEquals(new Integer(3), d.metodoInteger());
   
     }
}
