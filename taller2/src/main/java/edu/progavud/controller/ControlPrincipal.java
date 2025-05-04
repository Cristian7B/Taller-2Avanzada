/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.controller;

import edu.progavud.model.Carta;
import edu.progavud.model.Persona;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase encargada de controlar todo el resto de controles,
 * enlaza todo el programa.
 * 
 * @author Nicolas Velasco 
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
     * Control para la gestión de la mesa, son 3 mesas en total
     */
    private ControlMesa controlMesa;
    /**
     * Variable para manejar la ronda de juego actual. Es 0 si a los jugadores
     * aún no se les han repartido las cartas y por lo tanto están en la apuesta
     * inicial.
     */
    public static int rondaActual;
    /**
     * Método constructor que enlaza la comunicación con todos los controles.
     */
    public ControlPrincipal(){
        controlPersona = new ControlPersona(this);
        controlMesa = new ControlMesa(this);
        controlVista = new ControlVista(this);
        controlMazo = new ControlMazo(this);
        rondaActual = 0;
        anadirPersonas();
    }
    
    /**
     * Método para añadir personas a la mesa por medio del array personas.
     * Se crea la persona desde controlPersona y de pasa a controlMesa.
     */    
    public void anadirPersonas() {
        for(int i = 0; i < 3; i++) {
            controlMesa.agregarJugadorMesa(controlPersona.crearJugadorMesa(i), i);
        }
    }
    
    /**
     * Método que une la persona que pidió con la carta con la nueva carta.
     * Primero se obtiene la persona escogida, luego su mano y a su mano se le añade
     * una carta random dentro del mazo.
     * @param contador contador que apunta a una persona
     */
    public void pedir(int contador){
        contador = contador;
        int sumaCrupier = 0;
        for (int i=0; i< controlMesa.getPersonaParaModificar(3).getMano().size(); i++){
            sumaCrupier = sumaCrupier + controlMesa.getPersonaParaModificar(3).getMano().get(i).getValorInterno();
        }
        if (contador == 3 ){
            while (true){
                if (sumaCrupier < 17){
                    
                    controlMesa.getPersonaParaModificar(contador).getMano().add(controlMazo.getRandomCarta());
                    int i = controlMesa.getPersonaParaModificar(contador).getMano().size()-1;
                    sumaCrupier = sumaCrupier + controlMesa.getPersonaParaModificar(contador).getMano().get(i).getValorInterno();
                }
                if (sumaCrupier >= 17){
                    break;
                }
            }
        }else {
            controlMesa.getPersonaParaModificar(contador).getMano().add(controlMazo.getRandomCarta());
        }
    }
    
    /**
     * Método que hace el reparto inicial, únicamente entrega una carta a cada jugador
     * @param ronda ronda en la que van, siempre va a aumentar y solo servirá para el reparto
     *              inicial de las cartas. La ronda 1 es la primera carta q le dan a cada persona,
     *              la ronda 2 la segunda carta que se les da. En la segunda partida inician en la
     *              tercera ronda y así sucesivamente.
     */
    public void repartoInicial(int ronda) {
        ArrayList<Carta> manoGenerada = controlMazo.generarMano(ronda);

        // Jugador 1
        controlMesa.getPersonas()[0].getMano().add(manoGenerada.get(0));
        controlMesa.getPersonas()[0].getMano().add(manoGenerada.get(1));

        // Jugador 2
        controlMesa.getPersonas()[1].getMano().add(manoGenerada.get(2));
        controlMesa.getPersonas()[1].getMano().add(manoGenerada.get(3));

        // Crupier
        controlMesa.getPersonas()[2].getMano().add(manoGenerada.get(4));
        controlMesa.getPersonas()[2].getMano().add(manoGenerada.get(5));
    }

    /**
     * Método que dobla el valor de la
     * apuesta pero solo recibe una carta
     */
    public void doblar(int contador) {
        if(controlMesa.verificarDoblar()) {
            controlMesa.getPersonaParaModificar(contador).getMano().add(controlMazo.getRandomCarta());    
        }
    }
    
    /**
     * Método heredado de la clase Persona,si tiene el mismo
     * valor en las dos cartas primeras, puede dividir sus cartas
     * en dos manos y generar otra apuesta con la nueva mano
     */
    public void dividir() {
        if(controlMesa.verificarDividir()) {
            controlMesa.getPersonaParaModificar(ControlMesa.getContador()).getManoDividida().get(0).add(controlMesa.getPersonaParaModificar(ControlMesa.getContador()).getMano().get(0));
            controlMesa.getPersonaParaModificar(ControlMesa.getContador()).getManoDividida().get(1).add(controlMesa.getPersonaParaModificar(ControlMesa.getContador()).getMano().get(0));

            controlMesa.getPersonaParaModificar(ControlMesa.getContador()).getManoDividida().get(0).add(controlMazo.getRandomCarta());
            controlMesa.getPersonaParaModificar(ControlMesa.getContador()).getManoDividida().get(1).add(controlMazo.getRandomCarta());
        }
    }
    
    public Persona[] obtenerPersonas() {
        return controlMesa.getPersonas();
    }

    /**
     * Método que puede asegurar
     * apostando a que le salga blackjack al crupier,
     * si su primera carta es un as. se paga 2 a 1.
     * Se puede apostar como maximo, la mitad de lo que aposto
     * en la apuesta inicial.
     * return proporcion de la apuesta
     */
    public int asegurar() {
        int proporcion = 0;
        if(controlMesa.verificarAsegurar()){
            proporcion = 1/2;
        }else{
            proporcion = -1/2;
        }
        return proporcion;
    }
    
    public void apostarEnJugador(int valorNuevoApuesta) {
        controlMesa.colocarApuestas(valorNuevoApuesta);
    }

    /**
     * Método que sirve para pagarle a una persona, el valor
     * que retorne esta función siempre se le sumará al dinero que 
     * tiene la persona
     * @param proporcion
     * @param apuesta 
     * @return dinero que se le debe pagar a la persona
     */
    public double pagarApuesta(double proporcion, int apuesta) {
        double paga = 0;
        paga = (double) apuesta* proporcion;
        return paga;
    }

    /**
     * Método heredado de la clase Persona, el jugador se
     * planta cuando crea que no necesita mas cartas.
     */
    public void plantarse() {
        ControlMesa.setContador(ControlMesa.getContador()+1);
    }

    /**
     * Método que retorna la proporción para posteriormente pagar el blackjack
     * @return proporcion
     */
    public int blackJack(){
        int proporcion = 0;
        if (controlMesa.verificarBlackJack()){
            proporcion = 1/2;
        }
        return proporcion;
    }

    /**
     * Método que modifica el atributo ganador de la persona
     * @return proporcion que será llamada en el metodo pagar apuesta
     */
    public int hallarGanador() {
        int proporcion = 0;
        controlMesa.getPersonaParaModificar(ControlMesa.getContador()).setGanador(controlMesa.verificarGanador());
        if (controlMesa.getPersonaParaModificar(ControlMesa.getContador()).getGanador()==0){
            proporcion = -1;
        }else if (controlMesa.getPersonaParaModificar(ControlMesa.getContador()).getGanador()==2){
            proporcion = 1;
        }
        return proporcion;
    }
    
    public int[] obtenerApuestas() {
        int[] apuestasMesa = new int[2];
        apuestasMesa[0] = controlMesa.getMesaActual().getApuestasDeLaMesa().get("0");
        apuestasMesa[1] = controlMesa.getMesaActual().getApuestasDeLaMesa().get("1");
        return apuestasMesa;
    }
    
    public void moverPersonasAlFinal(){
        controlMesa.setPersonas(controlPersona.moverPersonasAlFinal()) ;
    }

}
