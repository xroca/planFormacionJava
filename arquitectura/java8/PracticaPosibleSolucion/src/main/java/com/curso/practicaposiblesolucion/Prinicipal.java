/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.practicaposiblesolucion;

import com.curso.practicaposiblesolucion.modelo.Usuario;
import com.curso.practicaposiblesolucion.mensajes.GestorMensajes;
import com.curso.practicaposiblesolucion.mensajes.Mensaje;
import static com.curso.practicaposiblesolucion.mensajes.Mensaje.*;
import static java.lang.System.out;
import static java.util.Arrays.asList;
import java.util.Collection;
import java.util.List;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author formacioncoruna
 */
public class Prinicipal {

    private static final GestorMensajes<Mensaje<String>> GM = new GestorMensajes();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Usuario> l = usuarios();
        Usuario origen = l.get(0);
        Usuario destino = l.get(1);
        enviar(origen, destino, crearMensaje("test").conEstado(EstadosMensaje.SINLEER));
        enviar(origen, destino, crearMensaje("test1").conEstado(EstadosMensaje.LEIDO));
        verEnviados(origen);
        verRecibidos(destino);
        verRecibidosLeidos(destino);
        verRecibidosSinLeer(destino);
    }

    private static <T> void mostrar(Collection<T> col, String... textos) {
        String str = asList(textos).stream().collect(joining(","));
        System.out.println(str);
        col.forEach(out::println);
    }

    private static void enviar(Usuario origen, Usuario destino, Mensaje<String> mensaje) {
        GM.enviar(origen, destino, mensaje);
    }

    private static void verRecibidos(Usuario u) {
        mostrar(GM.recibidosPor(u), "Mensajes recibidos por " + u);
    }

    private static void verEnviados(Usuario u) {
        mostrar(GM.enviadosPor(u), "Mensajes enviados por " + u);
    }

    private static List<Usuario> usuarios() {
        return asList("origen", "destino")
                .stream()
                .map(Usuario::new)
                .collect(toList());
    }

    private static void verRecibidosLeidos(Usuario u) {
        mostrar(GM.recibidosConEstado(u, Mensaje::leido), "Mensajes recibidos leídos por " + u);
    }

    private static void verRecibidosSinLeer(Usuario u) {
        mostrar(GM.recibidosConEstado(u, Mensaje::sinLeer), "Mensajes recibidos sin leer por " + u);
    }
}
