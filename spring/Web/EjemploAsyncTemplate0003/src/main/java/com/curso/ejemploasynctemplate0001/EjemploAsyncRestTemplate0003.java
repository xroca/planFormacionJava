/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemploasynctemplate0001;

import com.curso.ejemploasynctemplate0001.modelo.Persona;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;

/**
 *
 * @author usuario
 */
public class EjemploAsyncRestTemplate0003 {

    private static final Logger LOG = Logger.getLogger(EjemploAsyncRestTemplate0003.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String... args) {
        final String url = "http://localhost:8080/ver";
        AsyncRestTemplate async = new AsyncRestTemplate();
        ListenableFuture<ResponseEntity<Persona>> resultadoFuturo = async.getForEntity(url, Persona.class);
        resultadoFuturo.addCallback(new ListenableFutureCallback<ResponseEntity<Persona>>() {

            @Override
            public void onSuccess(ResponseEntity<Persona> result) {
                Persona p = result.getBody();
                LOG.log(Level.INFO, String.format("Nombre:%s, Teléfono:%d", p.getNombre(), p.getTelefono()));
            }

            @Override
            public void onFailure(Throwable ex) {
                LOG.log(Level.SEVERE, () -> "¿Está arrancado el proyecto de ejemplo 'EjemploMicroServicio'");
                LOG.log(Level.SEVERE, () -> ex.toString());
            }
        });
        LOG.log(Level.INFO, "Fin");
    }

}
