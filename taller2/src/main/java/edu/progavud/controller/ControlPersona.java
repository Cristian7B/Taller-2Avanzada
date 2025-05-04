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
     * @param i, número del jugador. Objetivo: Verificar que no sea crupier
     * @return personaAAgregar, objeto Persona a añadir
     */
    public Persona crearJugadorMesa(int i) {
        Persona personaAAgregar;

        if (i == 0) {
            personaAAgregar = new Jugador("Juan", "Pérez", "12345678", 100, "Calle Falsa 123", "555-1234", 10230120);
        } else if (i == 1) {
            personaAAgregar = new Jugador("Ana", "Gómez", "87654321", 100, "Avenida Siempre Viva 742", "555-5678", 1231230);
        } else {
            personaAAgregar = new Crupier("Carlos", "Ramírez", "99999999", 100);
        }

        return personaAAgregar;
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
