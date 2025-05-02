/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author crisc
 */
public class Mesa {
    private HashMap<String, Integer> apuestasDeLaMesa;
    private Persona[] personas;
    
    
    public Mesa() {
        personas = new Persona[3];
        apuestasDeLaMesa = new HashMap<>();
    }
    

    public HashMap<String, Integer> getApuestasDeLaMesa() {
        return apuestasDeLaMesa;
    }

    public void setApuestasDeLaMesa(HashMap<String, Integer> apuestasDeLaMesa) {
        this.apuestasDeLaMesa = apuestasDeLaMesa;
    }

    public Persona[] getPersonas() {
        return personas;
    }

    public void setPersonas(Persona[] personas) {
        this.personas = personas;
    }
    
    
    
}
