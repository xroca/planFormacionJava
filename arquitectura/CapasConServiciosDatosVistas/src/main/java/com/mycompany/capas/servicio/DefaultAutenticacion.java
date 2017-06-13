/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capas.servicio;

import com.mycompany.capas.dao.AutenticacionDao;
import com.mycompany.capas.dao.FactoriaDao;
import com.mycompany.capas.modelo.Usuario;

/**
 *
 * @author Administrador
 */
class DefaultAutenticacion implements ServicioAutenticacion {

    private final AutenticacionDao dao = FactoriaDao.unicaInstancia();

    public DefaultAutenticacion() {
        dao.guardar(new Usuario("abcabc", "xyzxyz"));
    }

    @Override
    public Boolean autenticar(Usuario usuario) {
        String nombre = usuario.getNombre();
        String clave = usuario.getClave();
        if (nombre.length() < 6 || clave.length() < 6) {
            return false;
        } else {
            return dao.existe(usuario);
        }
    }
}
