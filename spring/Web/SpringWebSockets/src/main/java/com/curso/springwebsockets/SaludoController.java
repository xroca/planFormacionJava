package com.curso.springwebsockets;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SaludoController {


    @MessageMapping("/mensaje")
    @SendTo("/topic/saludos")
    public Saludo respuesta(Mensaje mensaje) throws Exception {
        return new Saludo("¡Hola, " + mensaje.getNombre() + "!");
    }

}
