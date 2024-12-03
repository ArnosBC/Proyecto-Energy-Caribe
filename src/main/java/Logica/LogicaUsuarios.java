/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Modelo.Usuario;
import Persistencia.UsersCollections;

/**
 *
 * @author Jhon Bermudez
 */
public class LogicaUsuarios {
    
    private UsersCollections usuarios;

    public LogicaUsuarios() {
        this.usuarios = new UsersCollections();
    }
    
    public Usuario buscarUsuario(String username){
        return this.usuarios.getUsuario(username);
    }
}