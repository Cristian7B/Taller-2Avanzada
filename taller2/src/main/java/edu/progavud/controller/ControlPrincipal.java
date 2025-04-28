/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.controller;

/**
 * Clase encargada de controlar todo el resto de controles,
 * enlaza todo el programa.
 * 
 * @author ACER NITRO
 */
public class ControlPrincipal {
    /**
     * Objeto que representa el control del crupier.
     */
    private ControlPersona controlCrupier;
    /**
     * Objeto que representa el control de los jugadores.
     */
    private ControlPersona controlJugador;
    /**
     * Objeto que representa el control de la vista.
     */
    private ControlVista controlVista;
    
    /**
     * Método constructor que enlaza la comunicación con todos los controles.
     */
    public ControlPrincipal(){
        controlCrupier = new ControlPersona(this,0);
        controlJugador = new ControlPersona(this, 1);
        controlVista = new ControlVista(this);
    }
}
