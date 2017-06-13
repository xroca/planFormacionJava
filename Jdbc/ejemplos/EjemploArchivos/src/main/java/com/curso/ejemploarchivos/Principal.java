/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemploarchivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Principal {
    
    private Connection con;
    private static final Logger LOG = Logger.getLogger(Principal.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal p = new Principal();
        if (p.abrirConexion()) {
            p.procesarArchivo("c:\\datos.txt");
            p.cerrarConexion();
        }
    }
    
    private void procesarArchivo(String archivo) {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(archivo));
            LOG.log(Level.INFO, "Archivo abierto");
            br.lines().map(linea -> realizarInsercion(linea)).forEach(out::println);
            br.close();
            LOG.log(Level.INFO, "Archivo oerrado");
        } catch (FileNotFoundException ex) {
            LOG.log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean realizarInsercion(String texto) {
        try {
            String formato = String.format("insert into personas values(%d,'%s')", System.nanoTime(), texto);
            Statement s = con.createStatement();
            s.executeUpdate(formato);
            LOG.log(Level.INFO, "Insertado: {0}", formato);
            return true;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private boolean abrirConexion() {
        try {
            con = DriverManager.getConnection(URL, USUARIO, CLAVE);
            LOG.log(Level.INFO, "Conexión abierta");
            return true;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return false;
        }
    }
    private static final String CLAVE = "app";
    private static final String USUARIO = "app";
    private static final String URL = "jdbc:derby://localhost:1527/curso";
    
    private void cerrarConexion() {
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
