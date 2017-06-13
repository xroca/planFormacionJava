/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemplofuturos.autenticacion;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 *
 * @author usuario
 */
public class ProxyAuthenticator extends Authenticator {

    private final String usuario, clave;

    public ProxyAuthenticator(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(usuario, clave.toCharArray());
    }
}