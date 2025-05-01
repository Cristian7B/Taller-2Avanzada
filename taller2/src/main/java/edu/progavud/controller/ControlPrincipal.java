/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.controller;

import java.util.ArrayList;

/**
 * Clase encargada de controlar todo el resto de controles,
 * enlaza todo el programa.
 * 
 * @author ACER NITRO
 */
public class ControlPrincipal {
    /**
     * Objeto que representa el control del crupier y los jugadores.
     */
    private ControlPersona controlPersona;
    /**
     * Objeto que representa el control de la vista.
     */
    private ControlVista controlVista;
    /**
     * Objeto que representa el control del mazo para generar las manos
     */
    private ControlMazo controlMazo;
    /**
     * Método constructor que enlaza la comunicación con todos los controles.
     */
    public ControlPrincipal(){
        controlPersona = new ControlPersona(this);
        controlVista = new ControlVista(this);
        controlMazo = new ControlMazo(this);
    }

    /**
     * Método que une la persona que pidió con la carta con la nueva carta.
     * Primero se obtiene la persona escogida, luego su mano y a su mano se le añade
     * una carta random dentro del mazo.
     * @param contador contador que apunta a una persona
     */
    public void pedir(int contador){
        controlPersona.getHitPersona(contador).getMano().add(controlMazo.getRandomCarta());
    }
    
    /**
     * Método que hace el reparto inicial, únicamente entrega una carta a cada jugador
     * @param ronda ronda en la que van, siempre va a aumentar y solo servirá para el reparto
     *              inicial de las cartas. La ronda 1 es la primera carta q le dan a cada persona,
     *              la ronda 2 la segunda carta que se les da. En la segunda partida inician en la
     *              tercera ronda y así sucesivamente.
     */
    public void repartoInicial(int ronda){
        for (int i = 0; i<3 ; i++){
            controlPersona.getMesa()[i].getMano().add(controlMazo.generarMano(ronda).get(i));       
        }
    }
    
    /**
     * Método que dobla el valor de la
     * apuesta pero solo recibe una carta
     */
    public void doblar() {
        
    }

    /**
     * Método heredado de la clase Persona,si tiene el mismo
     * valor en las dos cartas primeras, puede dividir sus cartas
     * en dos manos y generar otra apuesta con la nueva mano
     */
    public void dividir() {

    }

    /**
     * Método heredado de la clase Persona, puede asegurar
     * apostando a que le salga blackjack al crupier,
     * si su primera carta es un as. se paga 2 a 1.
     * Se puede apostar como maximo, la mitad de lo que aposto
     * en la apuesta inicial.
     */
    public void asegurar() {

    }

    /**
     * Método heredado de la clase Persona, se paga
     * 3 a 2, si en las primeras dos cartas le sale blackjack,
     * es decir que suman 21.
     */
    public void blackjack() {

    }

    /**
     * Método heredado de la clase Persona, el jugador se
     * planta cuando crea que no necesita mas cartas.
     */
    public void plantarse() {

    }


    /**
     * Método que retorna el ganador de cada ronda
     * 
     * @return cadena con el nombre del ganador de la ronda
     */
    public boolean hallarGanador() {
        boolean ganador;
        ganador = false;
        return ganador;
    }

}
