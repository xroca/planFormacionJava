/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.dao;

import com.curso.spring.beans.Persona;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Chema
 */
@Repository
public class PersonaDaoJdbc implements PersonaDao {

    private final AtomicInteger contador = new AtomicInteger(0);
    @Autowired
    private DataSource dataSource;

    @Override
    public void salvar(Persona p) {
        try {
            Connection con = dataSource.getConnection();
            final String orden = "insert into persona values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(orden);
            ps.setInt(1, contador.incrementAndGet());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getApellido());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Persona> todos() {
        List<Persona> lista = new ArrayList<>();
        try {
            Connection con = dataSource.getConnection();
            final String orden = "select * from persona";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(orden);
            while (rs.next()) {
                lista.add(new Persona(rs.getString("nombre"), rs.getString("apellido")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return lista;
        }
    }
}
