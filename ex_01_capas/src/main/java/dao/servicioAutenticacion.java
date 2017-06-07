/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 *
 * @author xrocal
 */
public class servicioAutenticacion implements Servicio {

    @Override
    public Boolean autenticar(Usuario usuario) {
        
        Objects.requireNonNull(usuario);
        Objects.requireNonNull(usuario.getId());
        Objects.requireNonNull(usuario.getNombre());
        Objects.requireNonNull(usuario.getPass());
        
        List<Usuario> usuarios = FactoriaUsuarioDao.get().todos();
        Stream<Usuario> filtrado = usuarios.stream().filter(p -> p.getId().equals(usuario.getId()) 
                && (p.getNombre().equals(usuario.getNombre()))
                && (p.getPass().equals(usuario.getPass())));
        
        
    
        return filtrado.count() > 0;
        
        
    }
    
}
