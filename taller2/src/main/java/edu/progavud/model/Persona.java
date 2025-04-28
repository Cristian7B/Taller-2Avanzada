/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.model;

import edu.progavud.controller.ControlPersona;

/**
 * Clase padre que representa todas las personas dentro del juego,
 * posteriormente la clase Jugador y Crupier la extenderán.
 * 
 * @author ACER NITRO
 */
public abstract class Persona {
    /**
     * Cadena que representa los nombres de todas las personas en el juego
     */
    private String nombre;
    /**
     * Cadena que representa el apellido de todas las personas en el juego
     */
    private String apellido;
    /**
     * Cadena que representa la cédula de todas las personas en el juego
     */
    private String cedula;
    /**
     * Número entero que representa el dinero que tiene cada persona
     */
    private int dinero;
    /**
     * Vector de 11 enteros (maxima cantidad de cartas que podrian formar 21),
     * cada posición del vector representa el valor de la carta
     */
    private int[] cartas;
    /**
     * Método constructor de la clase que solamente inicializa los atributos
     */
    public Persona(){
        nombre = "";
        apellido = "";
        cedula = "";
        dinero = 0;
        cartas = new int[11];
    }
    
    /**
    * Método constructor con los valores proporcionados.
    * 
    * @param nombre El nombre de la persona.
    * @param apellido El apellido de la persona.
    * @param cedula La cédula de identidad de la persona.
    * @param dinero El dinero disponible de la persona.
    * @param carta El valor de la carta asignado a una posicion del vector cartas.
    * @param numCarta La posición del vector de cartas,
    * es decir en que orden le salió la carta a la persona.
    */
    public Persona(String nombre, String apellido, String cedula, int dinero, int carta, int numCarta){
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.dinero = dinero;
        this.cartas[numCarta] = carta;
    }
    
    /**
     * Método abstracto que calcula el dinero de la persona despues de un movimiento
     * que llamaremos transacción (apuesta, doblar, dividir, etc).
     * Se heredará en clase Jugador y Crupier.
     * 
     * @param transaccion monto de la transaccion para sumarse al dinero                
     */
    public abstract void calcularDinero(int transaccion);
    
    /**
     * Método abstracto para que los jugadores y el crupier pidan carta.
     * Se heredará en clase Persona y Crupier.
     * 
     * @return valor de la carta que recibió
     */
    public abstract int pedirCarta();
    
    /**
     * Método que retorna el nombre del ganador de la ronda
     * 
     * @return nombre del ganador de la ronda
     */
    public String hallarGanador(){
        String ganador;
        ganador = "";
        return ganador;
    }
    
}
