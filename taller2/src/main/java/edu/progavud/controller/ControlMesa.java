/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.controller;

import edu.progavud.model.Crupier;
import edu.progavud.model.Jugador;
import edu.progavud.model.Mesa;
import edu.progavud.model.Persona;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Cristian Bonilla
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

        for (int i = 0; i < 2; i++) {
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
     * Método que retorna un booleano para verificar si el jugador
     * puede ejecutar la acción de asegurar o no.
     * @return true puede asegurar, false no puede
     */
    public boolean verificarAsegurar(){
        boolean verificador = false;
        if (mesaActual.getPersonas()[2].getMano().get(0).getValorInterno()==11  && mesaActual.getPersonas()[2].getMano().size()==2 && mesaActual.getPersonas()[2].getMano().get(1).getValorInterno()==10  ){
            verificador = true;
        }

        return verificador;
    }

    /**
     * verifica que tenga dos cartas y que sumen 21
     * @return true si tiene blackjack, false sino.
     */
    public boolean verificarBlackJack(){
        boolean verificador = false;
        if (mesaActual.getPersonas()[contador].getMano().size() == 2){
            int sumaCartas = 0;
            for (int i=0; i < mesaActual.getPersonas()[contador].getMano().size(); i++){
                sumaCartas = sumaCartas + mesaActual.getPersonas()[contador].getMano().get(i).getValorInterno();
            }
            if (sumaCartas == 21){
                verificador = true;
            }
        }
        return verificador;
    }
    
    /**
     * Verifica si una persona puede ser ganadora debido a la suma de sus cartas
     * y hace el proceso de hallar el ganador comparando cada mano del jugador
     * con la del crupier.
     * @return 0 sino es ganador, 1 si empataron, 2 si gano
     */
    public int verificarGanador(){
        int sumaCartasJugador = 0;
        int sumaCartasCrupier = 0;
        int ganador = 0;
        for (int i=0; i < mesaActual.getPersonas()[contador].getMano().size(); i++){
            sumaCartasJugador = sumaCartasJugador + mesaActual.getPersonas()[contador].getMano().get(i).getValorInterno();
        }
        for (int i=0; i < mesaActual.getPersonas()[3].getMano().size(); i++){  //suponiendo que el contador 3 es el del crupier
            sumaCartasCrupier = sumaCartasCrupier + mesaActual.getPersonas()[3].getMano().get(i).getValorInterno();
        }
        if (sumaCartasJugador <= 21 && sumaCartasCrupier <= 21){
            if (sumaCartasJugador < sumaCartasCrupier){
                ganador = 0;
            }else if(sumaCartasJugador == sumaCartasCrupier){
                ganador = 1;
            }else{
                ganador = 2;
            }
        }
        
        return ganador;
    }
    
    /**
     * Método que registra la apuesta del jugador actual.
     * Solo se acepta si el jugador tiene suficiente dinero.
     * Se verifica que jugador esta haciendo la apuesta y se guarda dentro 
     * del hashMap creado en Mesa
     * 
     * @param apuesta valor de la apuesta realizada.
     */
    public void colocarApuestas(int apuesta) {
        if (contador % 2 == 0 && mesaActual.getPersonas()[0].getDinero() > apuesta) {
            mesaActual.getApuestasDeLaMesa().put(String.valueOf(0), apuesta);   //Jugador dos
        } else if (contador % 2 == 1 && mesaActual.getPersonas()[1].getDinero() > apuesta) {
            mesaActual.getApuestasDeLaMesa().put(String.valueOf(1), apuesta);   //Jugador uno porque contador nunca sera 0
        }
        contador++;
    }
    
    /**
     * método que retorna la proporción de ganancia del jugador
     * que decidió asegurar y ganó
     * @return proporción que se usara en el método pagarApuesta
     */
    public double asegurarGanador(){
        double proporcion = 0;
        if (!verificarAsegurar()){
            proporcion = -1/2;
        }
        return proporcion;
    }
    /**
     * método que retorna la proporción en la que se le pagará al jugador
     * @return proporcion que será parametro dentro de método pagarApuesta
     */
    public double blackJackGanador(){
        double proporcion = 0;
        if (verificarBlackJack()){
            proporcion = 3/2;
        }
        return proporcion;
    }
    
    /**
     * Metodo para implementar si gano con dos manos o solo con una mano
     * en caso de que haya decidido dividir su mano.
     * Este método hace que el jugador que divida sus cartas siempre sea ganador 
     * y luego se le aplica el pagar apuesta con el parametro que retorna este método.
     * @return parámetro proporción que se usará dentro de la funcion pagarApuesta
     */
    public int divisionGanador(){
        int proporcion = 0;
        int sumaMano1 = 0;
        int sumaMano2 = 0;
        int sumaCartasCrupier = 0;
        for (int i=0; i < mesaActual.getPersonas()[3].getMano().size(); i++){  //suponiendo que el contador 3 es el del crupier
            sumaCartasCrupier = sumaCartasCrupier + mesaActual.getPersonas()[3].getMano().get(i).getValorInterno();
        }
        for (int i = 0; i< mesaActual.getPersonas()[contador].getManoDividida().get(0).size(); i++){
            sumaMano1 = sumaMano1 + mesaActual.getPersonas()[contador].getManoDividida().get(0).get(i).getValorInterno();
        }
        for (int i = 0; i< mesaActual.getPersonas()[contador].getManoDividida().get(1).size(); i++){
            sumaMano2 = sumaMano2 + mesaActual.getPersonas()[contador].getManoDividida().get(1).get(i).getValorInterno();
        }
        if (sumaCartasCrupier <= 21){
            if (sumaMano1 <= 21 && sumaMano2 <= 21){ //cumple ambas
                if (sumaMano1 < sumaCartasCrupier){
                    proporcion = proporcion - 1;
                }else if(sumaMano1 == sumaCartasCrupier){
                }else{
                    proporcion = proporcion + 1;
                }
                if (sumaMano2 < sumaCartasCrupier){
                    proporcion = proporcion - 1;
                }else if(sumaMano2 == sumaCartasCrupier){
                }else{
                    proporcion = proporcion + 1;
                }
            }else if (sumaMano1 <= 21 ^ sumaMano2 <= 21){ //cumple alguna
                if (sumaMano1 < sumaCartasCrupier){
                    proporcion = proporcion - 1;
                }else if(sumaMano1 == sumaCartasCrupier){
                }else{
                    proporcion = proporcion + 1;
                }
                if (sumaMano2 < sumaCartasCrupier){
                    proporcion = proporcion - 1;
                }else if(sumaMano2 == sumaCartasCrupier){
                }else{
                    proporcion = proporcion + 1;
                }
            }else{ //no cumple ninguna
                proporcion = -2;
            }
        }else{
            proporcion = 2;
        }
        return proporcion;
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

    public Mesa getMesaActual() {
        return mesaActual;
    }

    public void setMesaActual(Mesa mesaActual) {
        this.mesaActual = mesaActual;
    }

    public ControlPrincipal getControlPrincipal() {
        return controlPrincipal;
    }

    public void setControlPrincipal(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
    }

    
  
    

}
