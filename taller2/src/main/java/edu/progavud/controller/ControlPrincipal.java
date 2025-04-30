/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.controller;

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
     * Método constructor que enlaza la comunicación con todos los controles.
     */
    public ControlPrincipal(){
        controlPersona = new ControlPersona(this);
        controlVista = new ControlVista(this);
    }

        /**
     * Método heredado de la clase Persona, dobla el valor de la
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
    public String hallarGanador() {
        String ganador;
        ganador = "";
        return ganador;
    }

}
