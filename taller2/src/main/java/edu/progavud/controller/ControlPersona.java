/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.controller;

import edu.progavud.model.Crupier;
import edu.progavud.model.Jugador;
import edu.progavud.model.Persona;

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
     * Atributo que contiene la ronda de juego.
     */
    private Persona[] mesa;
    /**
     * Forma de comprobar quien esta apostando en el momento.
     */
    private static int contador;

    /**
     * Metodo constructor 
     * @param controlPrincipal
     */
    public ControlPersona(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
    }

    public void crearMesa() {
        mesa = new Persona[3]; 
        for (int i = 1; i < mesa.length; i++) {
            if (i == 1) {
                mesa[i] = new Crupier();
            } else {
                mesa[i] = new Jugador();
            }
        }
    }


    public int colocarApuestas(int apuesta ) {
        int apuestas = 0;
        contador = 0;   //En la mesa, una forma de elegir el jugador que coloca la apuesta
        if(contador%2 == 0 && mesa[1].getDinero()>apuesta){
            apuestas = apuesta;
        }
        else if(contador%2 ==1 && mesa[2].getDinero()>apuesta){
            apuestas = apuesta;
        }
        return apuestas;
    }

}
