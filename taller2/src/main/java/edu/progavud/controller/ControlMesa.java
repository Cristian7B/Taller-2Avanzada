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
    /**
     * Instancia de la mesa de juego que contiene los jugadores y sus apuestas.
     */
    private Mesa mesaActual;

    /**
     * Referencia al controlador principal del juego.
     */
    private ControlPrincipal controlPrincipal;

    /**
     * Forma de comprobar quién está apostando en el momento.
     * Es decir, el número del jugador actual. 
     * Este contador jamás será 0.
     */
    private static int contador;

    /**
     * Constructor de la clase ControlMesa.
     * Inicializa la mesa actual y asigna el controlador principal.
     * También inicializa el mapa de apuestas con valores de 0 para cada jugador.
     * 
     * @param controlPrincipal referencia al controlador principal del juego.
     */
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
     * 
     * @param nuevaPersona jugador a agregar
     * @param i índice en el arreglo donde se colocará
     */
    public void agregarJugadorMesa(Persona nuevaPersona, int i) {
        mesaActual.getPersonas()[i] = nuevaPersona;
    }

    /**
     * Verifica si el jugador actual puede doblar su apuesta.
     * Si la apuesta actual es distinta de 0, se permite doblar y se multiplica por 2.
     * 
     * @return true si se puede doblar la apuesta, false en caso contrario.
     */
    public boolean verificarDoblar() {
        boolean verificador = false;
        Integer valor = mesaActual.getApuestasDeLaMesa().get(String.valueOf(contador));

        if (valor != 0) {
            verificador = true;
            mesaActual.getApuestasDeLaMesa().put(String.valueOf(contador), valor * 2);
        }

        return verificador;
    }

    /**
     * Verifica si el jugador actual puede dividir su mano.
     * Solo es posible si tiene dos cartas del mismo valor.
     * 
     * @return true si se puede dividir la mano, false en caso contrario.
     */
    public boolean verificarDividir() {
        boolean verificador = false;
        int valorCarta1 = mesaActual.getPersonas()[contador].getMano().get(0).getValorInterno();
        int valorCarta2 = mesaActual.getPersonas()[contador].getMano().get(1).getValorInterno();

        if ((valorCarta1 == valorCarta2) && mesaActual.getPersonas()[contador].getMano().size() == 2) {
            verificador = true;
        }

        return verificador;
    }

    /**
     * Método que registra la apuesta del jugador actual.
     * Solo se acepta si el jugador tiene suficiente dinero.
     * 
     * @param apuesta valor de la apuesta realizada.
     * @return valor de la apuesta si fue aceptada, 0 en caso contrario.
     */
    public int colocarApuestas(int apuesta) {
        int apuestas = 0;
        if (contador % 2 == 0 && mesaActual.getPersonas()[0].getDinero() > apuesta) {
            apuestas = apuesta;
        } else if (contador % 2 == 1 && mesaActual.getPersonas()[1].getDinero() > apuesta) {
            apuestas = apuesta;
        }
        contador++;
        return apuestas;
    }

    /**
     * Método que retorna el jugador que pidió una carta, para luego unir
     * la persona que retorna este método con su nueva carta en control principal.
     * Está en ControlMesa debido a que Mesa gestiona las personas presentes en el juego.
     * 
     * @param contador contador que apunta a Persona (1: persona1, 2: persona2...)
     * @return Persona que pidió la carta
     */
    public Persona getPersonaParaModificar(int contador) {
        return mesaActual.getPersonas()[contador - 1];
    }

    /**
     * Método para obtener las personas (jugadores) de la mesa.
     * 
     * @return Jugadores de la mesa
     */
    public Persona[] getPersonas() {
        return mesaActual.getPersonas();
    }

    /**
     * Método para obtener el valor actual del contador de jugadores.
     * 
     * @return valor del contador.
     */
    public static int getContador() {
        return contador;
    }

    /**
     * Método para establecer el valor del contador de jugadores.
     * 
     * @param contador nuevo valor para el contador.
     */
    public static void setContador(int contador) {
        ControlMesa.contador = contador;
    }


  
    

}
