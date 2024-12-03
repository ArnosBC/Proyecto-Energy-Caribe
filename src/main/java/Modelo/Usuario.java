/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhon Bermudez
 */
public class Usuario {
    private String username;
    private String password;
    private List<Dispositivo> dispositivos;

    public Usuario() {
        this.dispositivos = new ArrayList<>();
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
        this.dispositivos = new ArrayList<>();
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
     public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void agregarDispositivo(Dispositivo dispositivo) {
        this.dispositivos.add(dispositivo);
    }
}