/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Usuario;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jhon Bermudez
 */
public class UsersCollections {
    
    private Map<String, Usuario> usuarios;

    public UsersCollections() {
        this.usuarios = new HashMap();
        
        this.usuarios.put("admin", new Usuario("admin", "root"));
        this.usuarios.put("camilo", new Usuario("camilo", "12345"));
    }
    
    public Usuario getUsuario(String key){
        return this.usuarios.get(key);
    }
    
}