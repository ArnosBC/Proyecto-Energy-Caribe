/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Jhon Bermudez
 */
public abstract class Dispositivo {
    
    private String id;
    private String descripcion;
    private float consumo;
    private String tipo;

    public Dispositivo() {
    }

    public Dispositivo(String id, String descripcion, float consumo, String tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.consumo = consumo;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;   
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getConsumo() {
        return consumo;
    }

    public void setConsumo(float consumo) {
        this.consumo = consumo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Descripción: " + descripcion + ", Consumo: " + consumo + ", Tipo: " + tipo;
    }
   
    public String getFormatFile() {
    return this.id + ";" + this.descripcion + ";" + this.consumo + ";" + this.tipo;
}
    
    
}
