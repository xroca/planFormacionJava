/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemploobjetos.implementaciones;

import com.curso.ejemploobjetos.definiciones.Db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class DbImpl implements Db {

    private static final Logger LOG = Logger.getLogger(DbImpl.class.getName());
    private static final String CLAVE = "app";
    private static final String USUARIO = "app";
    private static final String URL = "jdbc:derby://localhost:1527/curso";

    @Override
    public Connection abrir() {
        try {
            Connection con = DriverManager.getConnection(URL, USUARIO, CLAVE);
            LOG.log(Level.INFO, "Conexión abierta");
            return con;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void cerrar(Connection con) {
        if (con != null) {
            try {
                con.close();
                LOG.log(Level.INFO, "Conexión cerrada");
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, null, ex);
            }
        }
    }
}
