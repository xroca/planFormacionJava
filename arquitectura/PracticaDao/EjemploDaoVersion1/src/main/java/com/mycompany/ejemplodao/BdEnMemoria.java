/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplodao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author usuario
 */
class BdEnMemoria implements PersonaDao {

    private final List<Persona> personas;

    BdEnMemoria() {
        this.personas = new ArrayList<>();
    }

    @Override
    public Persona nueva(Persona p) {
        Objects.requireNonNull(p);
        assert Objects.isNull(p.getId());
        p.setId(System.nanoTime());
        personas.add(p);
        return p;
    }

    @Override
    public List<Persona> todos() {
        return Collections.unmodifiableList(personas);
    }

}
