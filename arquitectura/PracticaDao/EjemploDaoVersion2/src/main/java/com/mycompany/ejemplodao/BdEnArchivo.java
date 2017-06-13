/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplodao;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
class BdEnArchivo implements PersonaDao {

    private static final String NOMBRE_ARCHIVO = "personas.json";

    @Override
    public Persona nueva(final Persona p) {
        Objects.requireNonNull(p);
        assert Objects.isNull(p.getId());
        p.setId(System.nanoTime());
        try (FileWriter fw = new FileWriter(NOMBRE_ARCHIVO, true)) {
            new Gson().toJson(p, fw);
            fw.append('\n');
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
        return p;
    }
    private static final Logger LOG = Logger.getLogger(BdEnArchivo.class.getName());

    @Override
    public List<Persona> todos() {
        List<Persona> r = new ArrayList<>();
        try {
            Gson gson = new Gson();
            Files.readAllLines(Paths.get(NOMBRE_ARCHIVO))
                    .stream()
                    .map(linea -> gson.fromJson(linea, Persona.class))
                    .forEach(r::add);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        return r;
    }

}
