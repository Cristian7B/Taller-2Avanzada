/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.model;

/**
 * Clase hija de Persona que representa todos los jugadores dentro del juego.
 * 
 * @author ACER NITRO
 */
public class Jugador extends Persona {

    /**
     * Método heredado de la clase Persona, calcula el dinero de los jugadores,
     * se conectará posteriormente con la vista por medio del control
     * para que se muestre en todo momento el dinero del jugador.
     * 
     * @param transaccion monto para sumarse a dinero y calcular el nuevo dinero del jugador
     */
    @Override
    public void calcularDinero(int transaccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Método heredado de la clase Persona, sirve para que el 
     * jugador pida cartas y retorna el valor de la carta que obtuvo.
     * 
     * @return valor de la carta que obtuvo
     */
    @Override
    public int pedirCarta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    /**
     * Método heredado de la clase Persona, sirve para que los
     * jugadores hagan la apuesta inicial.
     * 
     * @return cantidad que va a apostar cada jugador
     */ 
    
    
}
