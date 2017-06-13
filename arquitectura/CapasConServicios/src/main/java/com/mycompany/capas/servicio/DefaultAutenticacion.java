/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capas.servicio;

import com.mycompany.capas.modelo.Usuario;

/**
 *
 * @author Administrador
 */
class DefaultAutenticacion implements ServicioAutenticacion{

    @Override
    public Boolean autenticar(Usuario usuario) {
        return usuario.equals(new Usuario("abc", "xyz"));
    }
    
}
