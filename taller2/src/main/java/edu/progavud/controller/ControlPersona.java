/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.controller;

import edu.progavud.model.Crupier;
import edu.progavud.model.Jugador;
import edu.progavud.model.Persona;
import java.util.ArrayList;

/**
 * Clase que controla los objetos de tipo Persona
 * 
 * @author Nicolas Velasco
 */
public class ControlPersona {
    /**
     * Objeto de clase ControlPrincipal, para mantener la comunicación con este
     * objeto.
     */
    private ControlPrincipal controlPrincipal;

    /**
     * Metodo constructor 
     * @param controlPrincipal comunicación con su control
     */
    public ControlPersona(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
    }
    
    /**
     * Método para instanciar y añadir los jugadores a la mesa
     * @param atributos del jugador. Objetivo: Verificar que no sea crupier
     * @return jugador, objeto Jugador a añadir
     */
    public Jugador crearJugadorMesa(
        String nombre,
        String apellido,
        String cedula,
        int dinero,
        String direccion,
        String telefono
    ) {
        return new Jugador(nombre, apellido, cedula, dinero, direccion, telefono);
    }
    
        /**
     * Método para instanciar el crupier a la mesa
     * @param atributos del crupier
     * @return crupier, objeto Crupier a añadir
     */
    public Crupier crearCrupier(
        String nombre,
        String apellido,
        String cedula,
        int dinero
    ) {
        return new Crupier(nombre, apellido, cedula, dinero);
    }



    public Persona[] moverPersonasAlFinal(){
        int cantidadPersona = 6;
        Persona[] resultado = new Persona[6];

        for (int i = 2; i < cantidadPersona; i++) {
            resultado[i - 2] = controlPrincipal.obtenerPersonas()[i];
        }

        // Copiar los dos primeros al final
        resultado[4] = controlPrincipal.obtenerPersonas()[0];
        resultado[5] = controlPrincipal.obtenerPersonas()[1];

        return resultado;
    }
    
    public ControlPrincipal getControlPrincipal() {
        return controlPrincipal;
    }
    
    public void setControlPrincipal(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
    }

    

}
