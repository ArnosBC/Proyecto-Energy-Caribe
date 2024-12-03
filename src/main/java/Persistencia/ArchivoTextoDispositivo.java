/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Dispositivo;
import Modelo.Electrodomestico;
import Modelo.ElectronicoDeConsumo;
import Modelo.Iluminacion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jhon Bermudez
 */
public class ArchivoTextoDispositivo implements IArchivoDispositivo {

    private File archivo;
    private FileWriter aEscritura;
    private Scanner aLectura;

    public ArchivoTextoDispositivo() {
        this("Dispositivos.dat");
    }

    public ArchivoTextoDispositivo(String name) {
        this.archivo = new File(name);
    }

    @Override
    public void registrarDispositivo(Dispositivo d) throws RuntimeException {
        PrintWriter pw = null;
        try {
            this.aEscritura = new FileWriter(this.archivo, true);
            pw = new PrintWriter(this.aEscritura);
            pw.println(d.getFormatFile());
        } catch (IOException ex) {
            throw new RuntimeException("Error al abrir archivo para escritura");
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    @Override
    public Dispositivo consultarDispositivo(String id) {
        return null;
    }

    private Dispositivo crearDispositivo(String linea) {
    Dispositivo dispositivo;
    String[] datos = linea.split(";");
    
    if (datos.length < 4) {
        throw new IllegalArgumentException("Datos insuficientes para crear el dispositivo");
    }
    
    Float consumo = Float.valueOf(datos[2]);
    
    if ("Electrodoméstico".equalsIgnoreCase(datos[3])) {
        String marca = datos[4];
        String modelo = datos[5];
        dispositivo = new Electrodomestico(datos[0], datos[1], consumo, marca, modelo);
    } else if ("Electrónico de Consumo".equalsIgnoreCase(datos[3])) {
        String marca = datos[4];
        String modelo = datos[5];
        dispositivo = new ElectronicoDeConsumo(datos[0], datos[1], consumo, marca, modelo);
    } else if ("Iluminación".equalsIgnoreCase(datos[3])) {
        float potencia = Float.valueOf(datos[4]);
        String tipoIluminacion = datos[5];
        dispositivo = new Iluminacion(datos[0], datos[1], consumo, potencia, tipoIluminacion);
    } else {
        throw new IllegalArgumentException("Tipo de dispositivo no reconocido");
    }
    
    return dispositivo;
}

    @Override
    public List<Dispositivo> listarDispositivos() {
    List<Dispositivo> dispositivosLeidos = new ArrayList<>();
    try {
        this.aLectura = new Scanner(this.archivo);
        while (this.aLectura.hasNext()) {
            String linea = this.aLectura.nextLine();
            Dispositivo dispositivo = this.crearDispositivo(linea);
            dispositivosLeidos.add(dispositivo);
        }
    } catch (FileNotFoundException ex) {
        throw new RuntimeException("Error al abrir archivo para lectura");
    } finally {
        if (this.aLectura != null) {
            this.aLectura.close();
        }
    }
    return dispositivosLeidos;
}
}
