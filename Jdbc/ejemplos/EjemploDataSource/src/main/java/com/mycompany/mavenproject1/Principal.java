/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.derby.jdbc.ClientConnectionPoolDataSource;

/**
 *
 * @author iconotc
 */
public class Principal {

    public DataSource getDS(String database, String usuario, String clave) throws SQLException {
        ClientConnectionPoolDataSource ds = new ClientConnectionPoolDataSource();
        ds.setDatabaseName(database);
        ds.setUser(usuario);
        ds.setPassword(clave);
        ds.setServerName("localhost");
        ds.setPortNumber(1527);
        ds.setMaxStatements(20);
        return ds;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Principal p = new Principal();
            DataSource ds = p.getDS("curso", "app", "app");
            try (Connection con1 = ds.getConnection()) {
                System.out.println("Primera conexión establecida");
                System.out.println(con1);
            }
            try (Connection con2 = ds.getConnection()) {
                System.out.println("Segunda conexión establecida");
                System.out.println(con2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
