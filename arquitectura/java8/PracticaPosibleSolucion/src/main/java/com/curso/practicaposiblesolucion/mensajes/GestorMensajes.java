/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.practicaposiblesolucion.mensajes;

import com.curso.practicaposiblesolucion.modelo.Usuario;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author formacioncoruna
 * @param <T>
 */
public class GestorMensajes<T> {

    private final Map<Usuario, Set<T>> recibidos = new HashMap<>();
    private final Map<Usuario, Set<T>> enviados = new HashMap<>();

    public void enviar(Usuario origen, Usuario destino, T contenido) {
        enviados
                .computeIfAbsent(origen, u -> new HashSet<>())
                .add(contenido);
        recibidos
                .computeIfAbsent(destino, u -> new HashSet<>())
                .add(contenido);
    }

    public Set<T> enviadosPor(Usuario usuario) {
        return enviados
                .computeIfAbsent(usuario, u -> new HashSet<>());
    }

    public Set<T> recibidosPor(Usuario usuario) {
        return recibidos
                .computeIfAbsent(usuario, u -> new HashSet<>());
    }

    public List<T> recibidosConEstado(Usuario usuario, Predicate<T> filtro) {
        return recibidosPor(usuario)
                .stream()
                .filter(filtro)
                .collect(toList());
    }
}
