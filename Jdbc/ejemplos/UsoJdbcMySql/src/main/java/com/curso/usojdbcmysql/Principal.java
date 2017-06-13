/*
 * Principal.java
 *
 * Created on 22 de noviembre de 2006, 10:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.curso.usojdbcmysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Principal {

    private static final String tablaPersonasDef = "CREATE TABLE  personas ("
            + "id int(10) unsigned NOT NULL auto_increment,"
            + "nombre varchar(255) NOT NULL,"
            + "PRIMARY KEY  (id)" + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
    private static final String DB = "jdbc:mysql://localhost/test?user=root";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private Connection con = null;

    /**
     * Creates a new instance of Principal
     */
    public Principal() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Principal principal = new Principal();
            principal.abrirConexion();
            principal.crearTablaPersonas();
            for (int i = 0; i < 5; i++) {
                principal.ejecutarProcedimientoInsercion();
            }
            principal.mostrarPersonas();
            principal.ejecutarProcedimientoEntrada();
            principal.ejecutarProcedimientoSalida();
            principal.ejecutarProcedimientoMixto();
            principal.mostrarPersonas();
            principal.cerrarConexion();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void abrirConexion() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName(DRIVER).newInstance();
        con = DriverManager.getConnection(DB);
        System.out.println("Conexión establecida con la base de datos");
    }

    private void cerrarConexion() throws SQLException {
        con.close();
        System.out.println("Conexión con la base de datos cerrada");
    }

    private void crearTablaPersonas() throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("DROP TABLE IF EXISTS personas");
        st.executeUpdate(tablaPersonasDef);
    }

    private void ejecutarProcedimientoEntrada() throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("DROP PROCEDURE IF EXISTS parametrosEntrada");
        st.executeUpdate("create procedure parametrosEntrada(IN p1 VARCHAR(255))\n" + "begin\n" + " select p.nombre from personas p where p.nombre like p1;\n" + "end\n");

        CallableStatement cs = con.prepareCall("{call parametrosEntrada(?)}");

        System.out.println("Buscando personas cuyo nombre contenga la palabra \"cualquiera\"");
        cs.setString(1, "%cualquiera%");
        ResultSet rs = cs.executeQuery();
        while (rs.next()) {
            System.out.println("Nombre:" + rs.getString(1));
        }
    }

    private void ejecutarProcedimientoSalida() throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("DROP PROCEDURE IF EXISTS parametrosSalida");
        st.executeUpdate("create procedure parametrosSalida(out p1 int)\n" + "begin\n" + " select count(*) from personas into p1;\n" + "end\n");

        CallableStatement cs = con.prepareCall("{call parametrosSalida(?)}");

        cs.registerOutParameter(1, Types.INTEGER);
        cs.executeUpdate();
        int resultado = cs.getInt(1);
        System.out.printf("Hay %d personas en la base de datos\n", resultado);
    }

    private void ejecutarProcedimientoInsercion() throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("DROP PROCEDURE IF EXISTS insertarPersona");
        st.executeUpdate("create procedure insertarPersona(in p1 varchar(255))\n" + "begin\n" + " insert into personas (nombre) values(p1);\n" + "end\n");

        CallableStatement cs = con.prepareCall("{call insertarPersona(?)}");

        cs.setString(1, "persona cualquiera" + System.currentTimeMillis());
        cs.executeUpdate();
    }

    private void mostrarPersonas() throws SQLException {
        Statement st = con.createStatement();
        System.out.println("Personas existentes en la base de datos");
        ResultSet rs = st.executeQuery("select nombre from personas");
        while (rs.next()) {
            System.out.println("Nombre: " + rs.getString(1));
        }
    }

    private void ejecutarProcedimientoMixto() throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("DROP PROCEDURE IF EXISTS procedimientoMixto");
        st.executeUpdate("create procedure procedimientoMixto(in p1 varchar(255))\n" + "begin\n" + " insert into personas (nombre) values(p1);\n" + " select nombre from personas;\n" + "end\n");

        CallableStatement cs = con.prepareCall("{call procedimientoMixto(?)}");

        cs.setString(1, "persona desde proc mixto" + System.currentTimeMillis());
        boolean r = cs.execute();
        if (r) {
            System.out.println("El primer resultado es un ResultSet");
            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString(1));
            }
            boolean hayMasResultSet = cs.getMoreResults();
            if (hayMasResultSet) {
                System.out.println("Hay más ResultSets");
            } else {
                System.out.println("El siguiente resultado no es un ResultSet o no hay más resultados");
                int nFilas = cs.getUpdateCount();
                System.out.println("Filas afectadas:" + nFilas);
            }
            if ((!cs.getMoreResults()) && (cs.getUpdateCount() == -1)) {
                System.out.println("No hay más resultados que mostrar");
            } else {
                System.out.println("Hay más resultados que mostrar");
            }
        } else {
            System.out.println("El primer resultado no es un ResultSet o no hay resultados");
        }
    }
}
