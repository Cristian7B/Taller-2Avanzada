/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.controller;

import edu.progavud.model.Crupier;
import edu.progavud.model.Jugador;
import edu.progavud.model.Persona;

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
    private Persona[] mesa;
    private static int contador;

    public ControlPersona(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
    }

    public void crearMesa() {
        mesa = new Persona[3]; 
        for (int i = 1; i < mesa.length; i++) {
            if (i == 1) {
                mesa[i] = new Crupier();
            } else {
                mesa[i] = new Jugador();
            }
        }
    }


    public void colocarApuestas(int apuesta ) {
        contador = 0;
        if(contador%2 == 0 && ){
        }
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
