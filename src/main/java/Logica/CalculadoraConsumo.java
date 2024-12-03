/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Modelo.Dispositivo;
import java.util.List;

/**
 *
 * @author Jhon Bermudez
 */
public class CalculadoraConsumo {
    
    public float calcularConsumoHora(float consumoTotalDispositivos, int cantidadTiempo) {
        return (consumoTotalDispositivos / 30) / 24 * cantidadTiempo; 
    }

    public float calcularConsumoDiario(float consumoTotalDispositivos, int cantidadTiempo) {
        return (consumoTotalDispositivos / 30) * cantidadTiempo; 
    }

    public float calcularConsumoMensual(float consumoTotalDispositivos, int cantidadTiempo) {
        return consumoTotalDispositivos * cantidadTiempo;
    }

    public float calcularConsumoAnual(float consumoTotalDispositivos, int cantidadTiempo) {
        return (consumoTotalDispositivos * 12) * cantidadTiempo;
    }
}
