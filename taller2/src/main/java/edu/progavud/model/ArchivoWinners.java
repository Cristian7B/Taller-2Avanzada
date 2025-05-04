/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.model;

import edu.progavud.controller.ControlPrincipal;
import java.io.*;

public class ArchivoWinners {
    private final long tamreg = 66; 
    private RandomAccessFile archivo;
    private ControlPrincipal controlPrincipal;

    public ArchivoWinners(String rutaArchivo, ControlPrincipal controlPrincipal) {
        try {
            archivo = new RandomAccessFile(new File(rutaArchivo), "rw");
        } catch (FileNotFoundException e) {
        }
    }

    public void escribir(String nombre, double apuesta, double dineroFinal) {
        try {
            archivo.seek(archivo.length());       
            archivo.writeChars(nombre);             
            archivo.writeDouble(apuesta);           
            archivo.writeDouble(dineroFinal);       
        } catch (IOException e) {
        }
    }

    public void cerrar() {
        try {
            if (archivo != null) archivo.close();
        } catch (IOException e) {
        }
    }
}
