/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.List;

/**
 *
 * @author xrocal
 */
public interface PersonaDao {

    Persona nueva(Persona p);

    List<Persona> todos();
}
