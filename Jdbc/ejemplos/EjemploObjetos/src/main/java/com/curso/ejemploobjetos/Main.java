/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemploobjetos;

import com.curso.ejemploarchivos.Principal;
import com.curso.ejemploobjetos.definiciones.Db;
import com.curso.ejemploobjetos.implementaciones.DbImpl;
import com.curso.ejemploobjetos.modelo.Persona;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Main m = new Main();
            m.cargarBd();
            List<Persona> personas = m.tranformarEnObjetos();
            m.mostrarPersonas(personas);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargarBd() {
        Principal.main(null);
    }
    
    private List<Persona> tranformarEnObjetos() throws SQLException {
        List<Persona> resultado = null;
        Db db = new DbImpl();
        Connection c = db.abrir();
        if (c != null) {
            resultado = new ArrayList<>();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(FIND_ALL);
            while (rs.next()) {
                resultado.add(new Persona(rs.getLong(1), rs.getString(2)));
            }
            db.cerrar(c);
        }
        return resultado;
    }
    private static final String FIND_ALL = "select * from personas";
    
    private void mostrarPersonas(List<Persona> personas) {
        if (personas != null) {
            personas.forEach(out::println);
        }
    }
    
}
