/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.model;

import edu.progavud.controller.ControlPersona;

/**
 *
 * @author ACER NITRO
 */
public abstract class Persona {
    private String nombre;
    private String apellido;
    private String cedula;
    private int dinero;
    private int[] cartas;
    private ControlPersona controlPersona;
    public Persona(){
        nombre = "";
        apellido = "";
        cedula = "";
        dinero = 0;
        cartas = new int[10];
    }
    
    public Persona(String nombre, String apellido, String cedula, int dinero, int carta, int numCarta){
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.dinero = dinero;
        this.cartas[numCarta] = carta;
    }
    
    public Persona(ControlPersona controlPersona){
        this.controlPersona = controlPersona;
    }
    
    public abstract void calcularDinero(int transaccion);
    public abstract int pedirCarta();
    
    public String hallarGanador(){
        String ganador;
        ganador = controlPersona.hallarGanador();
        return ganador;
    }
    
}
