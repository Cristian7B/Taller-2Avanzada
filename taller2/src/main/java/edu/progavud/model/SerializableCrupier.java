/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author crisc
 */
public class SerializableCrupier {
    private FileOutputStream fileOut;
    private ObjectOutputStream salida;
    private FileInputStream fileIn;
    private ObjectInputStream entrada;

    
    public SerializableCrupier() {
        try {
            fileOut = new FileOutputStream("personas.bin");
            salida = new ObjectOutputStream(fileOut);
            fileIn = new FileInputStream("personas.bin");
            entrada = new ObjectInputStream(fileIn);
        } 
        catch (FileNotFoundException ex) {
        } 
        catch (IOException ex) {
        }
    }
    
    public void cerrarArchivoSerializadoOut() {
        if (salida != null) {
            try {
                salida.close();
            } catch (IOException ex) {
                System.out.println("no se puede cerrar la salida");
            }
        }
    }
    
    public void cerrarArchivoSerializadoIn() {
        if (entrada != null) {
           try {
                entrada.close();
            } catch (IOException ex) {
                System.out.println("no se puede cerrar la entrada");
            }
        }
    }
    
    public void escribirArchivoSerializado(Crupier crupier) {
        if (salida != null) {
            try {
                salida.writeObject(crupier);
            } catch (IOException ex) {
                System.out.println("no se puede serializar la persona");
            }
        }
    }
    
    public Persona leerArchivoSerializado() {
        Crupier crupier = null;
        if (entrada != null) {
            try {
                crupier = (Crupier) entrada.readObject();
            } catch (EOFException eof) {
                //fin del archivo
            } catch (IOException io) {
            //fin del archivo
            } catch (ClassNotFoundException cnfe) {
            //fin del archivo
            }
        }
        return crupier;
    }
}
