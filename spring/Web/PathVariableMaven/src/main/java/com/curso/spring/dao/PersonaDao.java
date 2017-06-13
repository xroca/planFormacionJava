/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.dao;

import com.curso.spring.beans.Persona;
import java.util.List;

/**
 *
 * @author Chema
 */
public interface PersonaDao {
    void salvar(Persona p);
    List<Persona> todos();
}
