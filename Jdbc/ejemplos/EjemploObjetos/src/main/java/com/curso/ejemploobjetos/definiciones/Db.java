/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemploobjetos.definiciones;

import java.sql.Connection;

/**
 *
 * @author usuario
 */
public interface Db {
    Connection abrir();
    void cerrar(Connection con);
}
