/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.controller;

import edu.progavud.model.Crupier;
import edu.progavud.model.Jugador;
import edu.progavud.model.Mesa;
import edu.progavud.model.Persona;
import java.util.HashMap;

/**
 *
 * @author crisc
 */
public class ControlMesa {
    private Mesa mesaActual;
    private ControlPrincipal controlPrincipal;
    /**
     * Forma de comprobar quien esta apostando en el momento.
     * es decir, número de jugador.
     * Este contador jamás sera 0.
     */
    private static int contador;
    
    public ControlMesa(ControlPrincipal controlPrincipal) {
        mesaActual = new Mesa();
        this.controlPrincipal = controlPrincipal;
        
        for (int i = 0; i < 3; i++) {
            mesaActual.getApuestasDeLaMesa().put(String.valueOf(i), 0);
        }
        
        contador = 0;
    }
    
    /**
     * Método que crea el arreglo de personas llamado mesa
     */
    public void agregarJugadorMesa(Persona nuevaPersona, int i) {
        mesaActual.getPersonas()[i] = nuevaPersona;
    }
    
    public boolean verificarDoblar() {
        boolean verificador = false;
        Integer valor = mesaActual.getApuestasDeLaMesa().get(String.valueOf(contador));
        
        if(valor != 0) {
            verificador = true;
            mesaActual.getApuestasDeLaMesa().put(String.valueOf(contador), valor*2);
        }
        
        return verificador;
    }
    
    public boolean verificarDividir() {
        boolean verificador = false;
        int valorCarta1 = mesaActual.getPersonas()[contador].getMano().get(0).getValorInterno();
        int valorCarta2 = mesaActual.getPersonas()[contador].getMano().get(1).getValorInterno();
        
        if((valorCarta1 == valorCarta2) && mesaActual.getPersonas()[contador].getMano().size() == 2) {
            verificador = true;
        }
        
        return verificador;
    }
    
    
    public int colocarApuestas(int apuesta) {
        int apuestas = 0;
        if(contador%2 == 0 && mesaActual.getPersonas()[0].getDinero()>apuesta){
            apuestas = apuesta;
        }
        else if(contador%2 ==1 && mesaActual.getPersonas()[1].getDinero()>apuesta){
            apuestas = apuesta;
        }
        contador++;
        return apuestas;
    }

    /**
     * Método que retorna el jugador que pidió una carta, para luego unir
     * la persona que retorna este método con su nueva carta en control principal. Está
     * en controlMesa, debido a que mesa gestiona las personas presentes en el juego.
     * @param contador  contador que apunta a Persona (1: persona1, 2: persona2...)
     * @return Persona que pidió la carta
     */
    public Persona getPersonaParaModificar(int contador){
        return mesaActual.getPersonas()[contador - 1];
    }
    
    /**
     * Método para obtener las personas(jugadores) de la mesa
     * @return Jugadores de la mesa
     */
    public Persona[] getPersonas() {
        return mesaActual.getPersonas();
    }
    
    

}
