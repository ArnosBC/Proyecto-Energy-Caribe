/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodeaulaenergy;

import Modelo.Dispositivo;
import Logica.CalculadoraConsumo;
import Persistencia.DispositivoStorage;
import java.io.IOException;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author Jhon Bermudez
 */
public class CalculadoraController {

    @FXML
    private Label lblConsumoTotal;

    @FXML
    private Label lblMontoTotal;

    @FXML
    private Button btnConsumoHora;
    @FXML
    private Button btnConsumoDiario;
    @FXML
    private Button btnConsumoMensual;
    @FXML
    private Button btnConsumoAnual;
    @FXML
    private TextField txtCantidadTiempo;

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

    private String tipoDeConsumo;

    private CalculadoraConsumo calculadoraConsumo = new CalculadoraConsumo();

    @FXML
    public void initialize() {
    btnConsumoHora.setOnAction(e -> tipoDeConsumo = "Hora");
    btnConsumoDiario.setOnAction(e -> tipoDeConsumo = "Diario");
    btnConsumoMensual.setOnAction(e -> tipoDeConsumo = "Mensual");
    btnConsumoAnual.setOnAction(e -> tipoDeConsumo = "Anual");

    dispositivos = DispositivoStorage.obtenerDispositivos();
    tablaDispositivos.setItems(dispositivos);

    idColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
    descripcionColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcion()));
    consumoColumn.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getConsumo()).asObject());
    tipoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipo()));
    
    lblConsumoTotal.setVisible(false);
    lblMontoTotal.setVisible(false);
}

@FXML
public void clickBtnTotal(MouseEvent event) {
   System.out.println("Botón presionado. Entrando en el cálculo...");

    int cantidadTiempo;

    try {
        cantidadTiempo = Integer.parseInt(txtCantidadTiempo.getText());
        if (cantidadTiempo <= 0) {
            throw new NumberFormatException(); 
        }
    } catch (NumberFormatException e) {
        lblConsumoTotal.setText("Por favor, ingresa un número válido.");
        lblMontoTotal.setText("-");
        lblConsumoTotal.setVisible(true); // Mostrar error
        lblMontoTotal.setVisible(true);
        return;
    }

    float consumoTotalDispositivos = 0;
    for (Dispositivo dispositivo : tablaDispositivos.getItems()) {
        consumoTotalDispositivos += dispositivo.getConsumo();
    }

    float consumoTotal = 0;
    switch (tipoDeConsumo) {
        case "Hora":
            consumoTotal = calculadoraConsumo.calcularConsumoHora(consumoTotalDispositivos, cantidadTiempo);
            break;
        case "Diario":
            consumoTotal = calculadoraConsumo.calcularConsumoDiario(consumoTotalDispositivos, cantidadTiempo);
            break;
        case "Mensual":
            consumoTotal = calculadoraConsumo.calcularConsumoMensual(consumoTotalDispositivos, cantidadTiempo);
            break;
        case "Anual":
            consumoTotal = calculadoraConsumo.calcularConsumoAnual(consumoTotalDispositivos, cantidadTiempo);
            break;
        default:
            lblConsumoTotal.setText("Tipo de consumo no válido.");
            lblMontoTotal.setText("-");
            lblConsumoTotal.setVisible(true);
            lblMontoTotal.setVisible(true);
            return;
    }

    System.out.println("Consumo Total (kWh): " + consumoTotal);
    float costoPorKwh = 881.9f;
    float montoTotal = consumoTotal * costoPorKwh;
    
    System.out.println("Monto Total (en dólares): " + montoTotal);
    
    lblConsumoTotal.setText(String.format("Consumo Total: %.2f kWh", consumoTotal));
    lblMontoTotal.setText(String.format("Monto Total: $%.2f", montoTotal));

    lblConsumoTotal.setVisible(true);
    lblMontoTotal.setVisible(true);
}

    @FXML
    private void clickBtnRegresar() throws IOException {
        App.setRoot("ListaDispositivos");
    }
}