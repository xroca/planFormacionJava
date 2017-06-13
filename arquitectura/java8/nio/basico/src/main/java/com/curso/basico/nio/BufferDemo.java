/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.basico.nio;

import static java.lang.System.out;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.stream.Stream;

/**
 *
 * @author usuario
 */
public class BufferDemo {

    public static Stream<ByteBuffer> crear() {
        return Stream.of(new Random().nextInt(32) + 1).map(ByteBuffer::allocateDirect);
    }

    public static void mostrarBufferInfo() {
        final String formato = "Directo: %b. Capacidad: %d. Tiene array: %b. Posición: %d\n";
        crear().forEach(bb -> out.format(formato, bb.isDirect(), bb.capacity(), bb.hasArray(), bb.position()));
    }

    public static void escribir() {
        crear().map(bb -> bb.put((byte) 10)).forEach(bb -> out.println("Posición: " + bb.position()));
    }

    public static void leerBuffer() {
        crear().map(bb -> bb.put((byte) 10)).map(bb -> bb.get(0)).forEach(out::println);
        crear().map(bb -> bb.put((byte) 10)).map(ByteBuffer::get).forEach(out::println);
    }
}
