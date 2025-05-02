/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.model;

import java.util.ArrayList;

/**
 * Clase hija de Persona que representa todos los jugadores dentro del juego.
 * 
 * @author ACER NITRO
 */
public class Jugador extends Persona {

    /**
     * direccion del jugador
     */
    private String direccion;
    /**
     * Telefono del jugador;
     */
    private String telefono;
    /**
     * Apuesta inicial que realizará el jugador
     */
    private int apuesta;
    /**
     * Método constructor que solamente inicializa los atributos
     */
    public Jugador(){
        super();
        direccion = "";
        telefono = "";
        apuesta = 0;
    }
    /**
     * Método constructor completo de la clase
     * @param nombre    nombre del jugador
     * @param apellido  apellido del jugador
     * @param cedula    cedula del jugador
     * @param dinero    dinero del jugador
     * @param direccion direccion del jugador
     * @param telefono  telefono del jugador
     * @param apuesta   apuesta inicial del jugador
     */
    public Jugador(String nombre, String apellido, String cedula, int dinero, String direccion, String telefono, int apuesta){
        super(nombre, apellido, cedula, dinero);
        this.direccion = direccion;
        this.telefono = telefono;
        this.apuesta = apuesta;
    }
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
     * Método para dividir la mano del jugador. Instancia el atributo manoDividida
     * y crea 2 arrayList los cuales son agregados para dividir la mano
     */
    public void dividirMano() {
        manoDividida = new ArrayList<>();
        
        ArrayList<Carta> manoDivivida1 = new ArrayList<>();
        ArrayList<Carta> manoDivivida2 = new ArrayList<>();
        
        manoDivivida1.add(getMano().get(0));
        manoDivivida2.add(getMano().get(1));
        
        getManoDividida().add(manoDivivida1);
        getManoDividida().add(manoDivivida2);
    }
}
