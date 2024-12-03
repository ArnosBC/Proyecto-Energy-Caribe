/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Dispositivo;
import java.util.List;

/**
 *
 * @author Jhon Bermudez
 */
public interface IArchivoDispositivo {
    
    void registrarDispositivo(Dispositivo d);
    Dispositivo consultarDispositivo(String id);
    List<Dispositivo> listarDispositivos();
}