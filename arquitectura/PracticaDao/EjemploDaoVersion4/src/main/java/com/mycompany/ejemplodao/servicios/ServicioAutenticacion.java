/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplodao.servicios;

import com.mycompany.ejemplodao.modelo.Persona;

/**
 *
 * @author dpalomar
 */
public interface ServicioAutenticacion {
    Boolean autenticar(final Persona persona);
}
