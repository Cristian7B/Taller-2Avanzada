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
     * Atributo que contiene la ronda de juego.
     */
    private Persona[] mesa;
    
    /**
     * Forma de comprobar quien esta apostando en el momento.
     * es decir, número de jugador.
     * Este contador jamás sera 0.
     */
    private static int contador;
    

    /**
     * Metodo constructor 
     * @param controlPrincipal comunicación con su control
     */
    public ControlPersona(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
        crearMesa();
        contador = 0;
    }

    /**
     * Método que crea el arreglo de personas llamado mesa
     */
    public void crearMesa() {
        mesa = new Persona[3]; 
        for (int i = 0; i < mesa.length; i++) {
            if (i == 2) {
                mesa[i] = new Crupier();
            } else {
                mesa[i] = new Jugador();
            }
        }
    }


    public int colocarApuestas(int apuesta) {
        int apuestas = 0;
        if(contador%2 == 0 && mesa[0].getDinero()>apuesta){
            apuestas = apuesta;
        }
        else if(contador%2 ==1 && mesa[1].getDinero()>apuesta){
            apuestas = apuesta;
        }
        contador++;
        return apuestas;
    }

    /**
     * Método que retorna el jugador que pidió una carta, para luego unir
     * la persona que retorna este método con su nueva carta en control principal 
     * @param contador  contador que apunta a Persona (1: persona1, 2: persona2...)
     * @return Persona que pidió la carta
     */
    public Persona getHitPersona(int contador){
        Persona persona;
        persona = mesa[(contador-1)];
        return persona;
    }
    
    public ControlPrincipal getControlPrincipal() {
        return controlPrincipal;
    }
    
    public void setControlPrincipal(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
    }

    public Persona[] getMesa() {
        return mesa;
    }

    public void setMesa(Persona[] mesa) {
        this.mesa = mesa;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        ControlPersona.contador = contador;
    }

}
