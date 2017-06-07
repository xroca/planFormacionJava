
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author xrocal
 */
class bdArchivo implements usuarioDao{

     conDB cdb = new conDB();
     
     
     Connection con = conDB.obrirConDB();
     
      PreparedStatement stat;
     
     
     private static final String NOMBRE_ARCHIVO = "usuarios.json";
    
    
    @Override
    public Usuario nueva(Usuario u) {
        
        Objects.requireNonNull(u);
        assert Objects.isNull(u.getId());
       
        
        int id = u.getId();
        String nombre  = u.getNombre();
        String pass = u.getPass();
       
        String texto = "INSERT INTO usuarios (id,nombre,pass) values (?,'?','?')";
        
        
         try {
             
             con.prepareStatement(texto);
             
             stat.setInt(1, id);
             stat.setString(2, nombre);
             stat.setString(3, pass);
             
             stat.executeUpdate(texto);
         } catch (SQLException ex) {
             Logger.getLogger(bdArchivo.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        
        
        return u;
        
    }
    
    private static final Logger LOG = Logger.getLogger(bdArchivo.class.getName());

    @Override
    public List<Usuario> todos() {
        
        List<Usuario> r = new ArrayList<>();
        try {
            Gson gson = new Gson();
            Files.readAllLines(Paths.get(NOMBRE_ARCHIVO))
                    .stream()
                    .map(linea -> gson.fromJson(linea, Usuario.class))
                    .forEach(r::add);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        return r;
        
    }
    
    
    
    
}
