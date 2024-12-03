/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Jhon Bermudez
 */
public class Iluminacion extends Dispositivo {
    
    private float potencia;
    private String tipoDeIluminacion;

   public Iluminacion(String id, String descripcion, float consumo, float potencia, String tipoIluminacion) {
        super(id, descripcion, consumo, "Iluminación");
        this.potencia = potencia;
        this.tipoDeIluminacion = tipoDeIluminacion;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public String getTipoDeIluminacion() {
        return tipoDeIluminacion;
    }

    public void setTipoDeIluminacion(String tipoDeIluminacion) {
        this.tipoDeIluminacion = tipoDeIluminacion;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Potencia: " + potencia + ", Tipo de Iluminación: " + tipoDeIluminacion;
    }
    
    
}