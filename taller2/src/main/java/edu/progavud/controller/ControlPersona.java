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
        
        if (i == 2) {
            personaAAgregar = new Crupier();
        } else {
            personaAAgregar = new Jugador();
        }
        
        return personaAAgregar;
    }
    
    public ControlPrincipal getControlPrincipal() {
        return controlPrincipal;
    }
    
    public void setControlPrincipal(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
    }


}
