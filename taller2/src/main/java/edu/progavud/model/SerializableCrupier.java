/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.model;

import java.io.EOFException;
import java.io.File;
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

    
    public void escribirArchivoSerializado(Crupier crupier) {
        try (FileOutputStream fileOut = new FileOutputStream("data/crupier.bin");
            ObjectOutputStream salida = new ObjectOutputStream(fileOut)) {
            salida.writeObject(crupier);
        } catch (IOException ex) {
           
        }
    }
    
    public void cerrarArchivoSerializadoOut() {
        if (salida != null) {
            try {
                salida.close();
            } catch (IOException ex) {
                
            }
        }
    }
    
    public void cerrarArchivoSerializadoIn() {
        if (entrada != null) {
           try {
                entrada.close();
            } catch (IOException ex) {
                
            }
        }
    }
   
    
    public Persona leerArchivoSerializado() {
        Crupier crupier = null;
        try (FileInputStream fileIn = new FileInputStream("data/crupier.bin");
            ObjectInputStream entrada = new ObjectInputStream(fileIn)) {
            crupier = (Crupier) entrada.readObject();
        } catch (EOFException eof) {
            //
        } catch (IOException io) {
            //
        } catch (ClassNotFoundException cnfe) {
             //;
        }
        return crupier;
    }

    
    
    public boolean archivoExiste() {
        File archivo = new File("data/crupier.bin");
        return archivo.exists() && archivo.length() > 0;
    }
}
