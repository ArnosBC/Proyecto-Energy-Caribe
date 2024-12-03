/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Dispositivo;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jhon Bermudez
 */
public class DispositivoStorage {

    private static ObservableList<Dispositivo> dispositivos = FXCollections.observableArrayList();

    public static void agregarDispositivo(Dispositivo dispositivo) {
        dispositivos.add(dispositivo);
    }

    public static ObservableList<Dispositivo> obtenerDispositivos() {
        return dispositivos;
    }


    public static void setObservableList(ObservableList<Dispositivo> dispositivosList) {
        dispositivos = dispositivosList;
    }

}
