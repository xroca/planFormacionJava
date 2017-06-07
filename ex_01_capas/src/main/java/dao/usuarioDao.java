/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author xrocal
 */
public interface usuarioDao {
    
    
    Usuario nueva(final Usuario u);
    List<Usuario> todos();
    
    
}
