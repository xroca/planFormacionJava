/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_maven;

import java.util.List;

/**
 *
 * @author xrocal
 */
public interface PersonaDao {
    
    
    public void nueva(Persona p);
    
    public List<Persona> todos();
    
    public Persona getInstance();
    
    
}
