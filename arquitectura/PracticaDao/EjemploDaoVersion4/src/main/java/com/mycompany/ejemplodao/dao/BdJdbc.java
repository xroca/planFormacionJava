/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplodao.dao;

import com.mycompany.ejemplodao.modelo.Persona;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khepherer
 */
public class BdJdbc implements PersonaDao {

    private static final String URL = "jdbc:derby://localhost:1527/curso";
    private static final String USUARIO = "app";
    private static final String CLAVE = "app";
    private Connection con;
    private static final Logger LOG = Logger.getLogger(BdJdbc.class.getName());

    public BdJdbc() {        
        System.out.println("Intentando conectar con la bd...");
        conectar();
        desconectar();
    }

    private void desconectar() {
        Runtime.getRuntime().addShutdownHook(
                new Thread() {
            @Override
            public void run() {
                if (con != null) {
                    try {
                        con.close();
                        System.out.println("Conexión cerrada");
                    } catch (SQLException ex) {
                        LOG.log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        );
    }

    private void conectar() {
        try {
            con = DriverManager.getConnection(URL, USUARIO, USUARIO);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Persona nueva(final Persona p) {
        try {
            final String orden = String.format("insert into personas values (%d,'%s')", p.getId(), p.getNombre());
            final Statement st = con.createStatement();
            st.executeUpdate(orden);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public List<Persona> todos() {
        final List<Persona> personas = new ArrayList<>();
        try {
            final ResultSet rs = con.createStatement().executeQuery("select * from personas");
            while (rs.next()) {
                personas.add(new Persona(rs.getLong(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        return personas;
    }

}
