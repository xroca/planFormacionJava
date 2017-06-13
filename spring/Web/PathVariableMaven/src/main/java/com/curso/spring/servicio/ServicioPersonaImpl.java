/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.servicio;

import com.curso.spring.beans.Persona;
import com.curso.spring.dao.PersonaDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Chema
 */
@Service
@Transactional(readOnly = true)
public class ServicioPersonaImpl implements ServicioPersona {

    @Autowired
    private PersonaDao personaDao;

    @Override
    @Transactional(readOnly=false)
    public void salvar(Persona p) {
        personaDao.salvar(p);
    }

    @Override
    public List<Persona> todos() {
        return personaDao.todos();
    }
}
