/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Jhon Bermudez
 */
public class ElectronicoDeConsumo extends Dispositivo {
    private String marca;
    private String modelo;

    public ElectronicoDeConsumo(String id, String descripcion, float consumo, String marca, String modelo) {
        super(id, descripcion, consumo, "Electrónico de Consumo");
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
