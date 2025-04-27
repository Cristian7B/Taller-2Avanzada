/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.controller;

import edu.progavud.model.Persona;

/**
 *
 * @author ACER NITRO
 */
public class ControlPersona {
    private Persona persona;
    private ControlPrincipal controlPrincipal;
    public ControlPersona(Persona persona, ControlPrincipal controlPrincipal){
        this.persona = persona;
    } 
    
    public ControlPersona(ControlPrincipal controlPrincipal){
        this.controlPrincipal = controlPrincipal;
        //persona = new Persona(this);
    }
    
    public String hallarGanador(){
        String ganador;
        ganador = "";
        return ganador;
    }
}

