/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodeaulaenergy;

import Modelo.Dispositivo;
import Persistencia.DispositivoStorage;
import java.io.IOException;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 *
 * @author Jhon Bermudez
 */
public class ListaDispositivosController {
    
   @FXML
    private TableView<Dispositivo> tablaDispositivos;

    @FXML
    private TableColumn<Dispositivo, String> idColumn;

    @FXML
    private TableColumn<Dispositivo, String> descripcionColumn;

   @FXML
    private TableColumn<Dispositivo, Float> consumoColumn;

    @FXML
    private TableColumn<Dispositivo, String> tipoColumn;

    private ObservableList<Dispositivo> dispositivos = FXCollections.observableArrayList();

    @FXML
    private void clickBtnRegistrar() throws IOException {
        App.setRoot("Registro");
    }

    @FXML
    private void clickBtnCalculadora() throws IOException {
        App.setRoot("Calculadora");
    }

    public void initialize() {
        dispositivos = DispositivoStorage.obtenerDispositivos();
        tablaDispositivos.setItems(dispositivos);

        idColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        descripcionColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcion()));
        consumoColumn.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getConsumo()).asObject());
        tipoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipo()));
    }

    @FXML
    public void cambiarEstado() {
        Dispositivo dispositivoSeleccionado = tablaDispositivos.getSelectionModel().getSelectedItem();

        if (dispositivoSeleccionado != null) {
            System.out.println("Cambiando estado de: " + dispositivoSeleccionado.getDescripcion());
        } else {
            System.out.println("No hay dispositivo seleccionado.");
        }
    }
    
}
