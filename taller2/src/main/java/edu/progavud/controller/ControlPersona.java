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
     * Objeto de clase Persona, el cual será controlado por esta clase.
     */
    private Persona persona;
    /**
     * Objeto de clase ControlPrincipal, para mantener la comunicación con este objeto.
     */
    private ControlPrincipal controlPrincipal;
    
    /**
     * Método constructor para crear un control de Personas.
     * Si el entero tipo persona es 0, significa que la persona es 
     * crupier; si es 1, significa que es jugador.
     * Usa sustitución de Liskov.
     * 
     * @param tipoPersona 0 o 1, 0 para crupier y 1 para jugador.
     * @param controlPrincipal control principal para la comunicación
     */
    public ControlPersona(ControlPrincipal controlPrincipal, int tipoPersona){
        if (tipoPersona == 0){
            persona = new Crupier();
        }else{
            persona = new Jugador();
        }
        this.controlPrincipal = controlPrincipal;
    } 
    
    /**
     * Método que retorna el ganador de cada ronda
     * @return cadena con el nombre del ganador de la ronda
     */
    public String hallarGanador(){
        String ganador;
        ganador = "";
        return ganador;
    }
}

