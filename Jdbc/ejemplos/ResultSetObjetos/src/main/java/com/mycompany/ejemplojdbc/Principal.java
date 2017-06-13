/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplojdbc;

import com.mycompany.ejemplojdbc.modelo.Persona;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iconotc
 */
public class Principal {

    private static final String CLAVE = "app";
    private static final String USUARIO = "app";
    private static final String URL = "jdbc:derby://localhost:1527/curso";
    private static final String DRIVER = "org.apache.derby.jdbc.ClientDriver";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal p = new Principal();
        try {
            Class.forName(DRIVER);
            try (Connection c = DriverManager.getConnection(URL, USUARIO, CLAVE)) {
                System.out.println("Conectado");
                cargarBd(c);
                List<Persona> lista = p.consulta(c, "select * from personas");
                lista.forEach(out::println);
            }
            System.out.println("Desconectado");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void cargarBd(Connection c) throws SQLException {
        Statement s = c.createStatement();
        List<String> l
                = asList(
                        "insert into personas values (1,'abc')",
                        "insert into personas values (2,'def')"
                );
        for (String insert : l) {
            s.executeUpdate(insert);
        }
    }

    private List<Persona> consulta(Connection c, String sql) throws SQLException {
        Statement s = c.createStatement();
        ResultSet rs = s.executeQuery(sql);
        List<Persona> p = new ArrayList<>();
        while (rs.next()) {            
            p.add(new Persona(rs.getInt(1), rs.getString(2)));
        }
        return p;
    }
}
