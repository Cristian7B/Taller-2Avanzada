/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representa una mesa de juego de Blackjack.
 * Esta clase mantiene el estado de los jugadores sentados en la mesa
 * y las apuestas que han realizado durante el juego. Se asume un máximo
 * de tres jugadores por partida.
 * @author crisc
 */
public class Mesa {
    /** HashMap que relaciona el identificador del jugador con el 
     * valor de su apuesta 
     */
    private HashMap<String, Integer> apuestasDeLaMesa;

    /** Arreglo de jugadores (Personas) que están sentados en la mesa 
     */
    private Persona[] personas;

    /**
     * Constructor de la clase Mesa.
     * Inicializa el arreglo de personas con capacidad para 3 jugadores
     * y crea un HashMap vacío para almacenar las apuestas.
     */
    public Mesa() {
        personas = new Persona[3];
        apuestasDeLaMesa = new HashMap<>();
    }

    /**
     * Retorna el HashMap de apuestas actuales en la mesa.
     * @return apuestasDeLaMesa, HashMap con las apuestas de los jugadores.
     */
    public HashMap<String, Integer> getApuestasDeLaMesa() {
        return apuestasDeLaMesa;
    }

    /**
     * Establece el HashMap de apuestas de la mesa.
     * @param apuestasDeLaMesa HashMap con las apuestas de los jugadores.
     */
    public void setApuestasDeLaMesa(HashMap<String, Integer> apuestasDeLaMesa) {
        this.apuestasDeLaMesa = apuestasDeLaMesa;
    }

    /**
     * Retorna el array de jugadores sentados en la mesa.
     * @return array de objetos Persona.
     */
    public Persona[] getPersonas() {
        return personas;
    }

    /**
     * Establece el array de jugadores en la mesa.
     * @param personas array de objetos Persona.
     */
    public void setPersonas(Persona[] personas) {
        this.personas = personas;
    }
}