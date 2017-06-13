/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capas.dao;

import com.mycompany.capas.modelo.Usuario;

/**
 *
 * @author Administrador
 */
public interface AutenticacionDao {
    Boolean existe(Usuario aBuscar);
    Usuario guardar(Usuario nuevo);
}
