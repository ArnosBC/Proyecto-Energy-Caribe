/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodeaulaenergy;

import Modelo.Dispositivo;
import Modelo.Electrodomestico;
import Modelo.ElectronicoDeConsumo;
import Modelo.Iluminacion;
import Persistencia.ArchivoTextoDispositivo;
import Persistencia.DispositivoStorage;
import Persistencia.IArchivoDispositivo;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 *
 * @author Jhon Bermudez
 */
public class RegistroController {

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtConsumo;

    @FXML
    private ComboBox<String> cmbTipoDispositivo;

    @FXML
    private HBox dynamicFieldsContainer;

    @FXML
    private Button btnRegistrar;

    @FXML
    public void initialize() {
        cmbTipoDispositivo.getItems().addAll("Electrónico de Consumo", "Electrodoméstico", "Dispositivo de Iluminación");

        cmbTipoDispositivo.setOnAction(event -> actualizarCamposAdicionales());
    }

    private void actualizarCamposAdicionales() {
        dynamicFieldsContainer.getChildren().clear();
        String tipoSeleccionado = cmbTipoDispositivo.getValue();

        if (tipoSeleccionado == null) {
            return;
        }

        switch (tipoSeleccionado) {
            case "Electrónico de Consumo":
            case "Electrodoméstico":
                TextField txtMarca = new TextField();
                txtMarca.setPromptText("Marca");
                TextField txtModelo = new TextField();
                txtModelo.setPromptText("Modelo");

                dynamicFieldsContainer.getChildren().addAll(txtMarca, txtModelo);
                break;

            case "Dispositivo de Iluminación":
                TextField txtPotencia = new TextField();
                txtPotencia.setPromptText("Potencia");
                TextField txtTipoDeIluminacion = new TextField();
                txtTipoDeIluminacion.setPromptText("Tipo de Iluminación");

                dynamicFieldsContainer.getChildren().addAll(txtPotencia, txtTipoDeIluminacion);
                break;

            default:
                break;
        }
    }

    @FXML
public void registrarDispositivo(ActionEvent event) throws IOException {
    String id = txtId.getText();
    String descripcion = txtDescripcion.getText();
    String consumoString = txtConsumo.getText();
    String tipo = cmbTipoDispositivo.getValue();

    Dispositivo dispositivo = null;

    if (consumoString.isEmpty()) {
        System.out.println("El consumo no puede estar vacío.");
        return; 
    }

    try {
        float consumo = Float.parseFloat(consumoString);

        switch (tipo) {
            case "Electrónico de Consumo":
            case "Electrodoméstico":
                String marca = ((TextField) dynamicFieldsContainer.getChildren().get(0)).getText();
                String modelo = ((TextField) dynamicFieldsContainer.getChildren().get(1)).getText();
                dispositivo = tipo.equals("Electrónico de Consumo")
                    ? new ElectronicoDeConsumo(id, descripcion, consumo, marca, modelo)
                    : new Electrodomestico(id, descripcion, consumo, marca, modelo);
                break;

            case "Dispositivo de Iluminación":
                float potencia = Float.parseFloat(((TextField) dynamicFieldsContainer.getChildren().get(0)).getText());
                String tipoIluminacion = ((TextField) dynamicFieldsContainer.getChildren().get(1)).getText();
                dispositivo = new Iluminacion(id, descripcion, consumo, potencia, tipoIluminacion);
                break;

            default:
                throw new IllegalArgumentException("Tipo de dispositivo no válido.");
        }

        if (dispositivo != null) {
            DispositivoStorage.agregarDispositivo(dispositivo);
             ArchivoTextoDispositivo archivoDispositivo = new ArchivoTextoDispositivo();
            archivoDispositivo.registrarDispositivo(dispositivo);
            System.out.println("Dispositivo registrado con éxito.");
            App.setRoot("ListaDispositivos");
        }

    } catch (NumberFormatException e) {
        System.out.println("Error: El consumo debe ser un número válido.");
    } catch (Exception e) {
        System.out.println("Error al registrar el dispositivo: " + e.getMessage());
    }
}

    @FXML
    private void clickBtnRegresar() throws IOException {
        App.setRoot("ListaDispositivos");
    }
}