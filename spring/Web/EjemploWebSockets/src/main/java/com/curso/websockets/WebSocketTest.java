package com.curso.websockets;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebSocketTest {

    @OnMessage
    public void onMessage(String mensaje, Session sesion) throws IOException, InterruptedException {

        System.out.println("Recibido: " + mensaje);
        sesion.getBasicRemote().sendText("Primer mensaje del servidor");
        // Enviar tres mensajes cada segundo
        int mensajesEnviados = 0;
        while (mensajesEnviados < 3) {
            Thread.sleep(1000);
            sesion.getBasicRemote().sendText("Mensaje intermedio. Contador: " + mensajesEnviados);
            mensajesEnviados++;
        }
        // Mensaje Final
        sesion.getBasicRemote().sendText("Mensaje final del servidor");
    }

    @OnOpen
    public void onOpen() {
        System.out.println("Cliente conectado");
    }

    @OnClose
    public void onClose() {
        System.out.println("Conexión cerrada");
    }
}
