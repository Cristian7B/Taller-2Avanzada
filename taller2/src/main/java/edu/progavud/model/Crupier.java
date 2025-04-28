/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.model;

/**
 * Esta clase representa el crupier del blackjack, hereda de la clase Persona.
 * 
 * @author ACER NITRO
 */
public class Crupier extends Persona {

    /**
     * Método heredado de la clase Persona para calcular dinero 
     * que le debe dar al jugador.
     * Como el crupier juega con el dinero del casino, suponemos
     * que el crupier cuenta con dinero infinito.
     * @param transaccion monto que debe dar o recibir del jugador
     */
    @Override
    public void calcularDinero(int transaccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Método heredado de la clase Persona, el crupier pide cartas
     * automáticamente si tiene 16 o menos en el valor de las cartas.
     * @return valor de la carta que obtuvo
     */
    @Override
    public int pedirCarta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     * Método que retorna el anuncio que hace el crupier en un momento del juego.
     * 
     * @return Cadena del anuncio que da el crupier
     */
    public String anuncio(){
        String anuncio;
        anuncio = "";   
        return anuncio;
    }
            
}
