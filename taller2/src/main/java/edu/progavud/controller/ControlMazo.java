/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.controller;

import edu.progavud.model.Carta;
import java.util.ArrayList;
import java.util.Collections;

/**
 * En esta clase se revolverá el mazo para crear un
 * mazo jugable y luego llamarlo en el control del juego
 * @author Nicolas Velasco
 */
public class ControlMazo {
    /**
     * Arreglo de objetos Carta para crear el mazo revuelto
     */
    private ArrayList<Carta> mazoRevuelto;
    
    /**
     * Método constructor de la clase que asigna el mazo revuelto
     */
    public ControlMazo(){
        mazoRevuelto = revolverMazo();
    }
    
    /**
     * Este método crea el mazo ordenado y luego lo revuelve y lo retorna
     * @return mazo revuelto
     */
    public ArrayList<Carta> revolverMazo(){
        ArrayList<Carta> baraja = new ArrayList<>();

        for (Mazo tipo : Mazo.values()){
            for (int i = 1; i<=13;i++){
                if (i>10){
                    baraja.add(new Carta(tipo.toString(),10));
                }else{
                    baraja.add(new Carta(tipo.toString(),i));
                }
            }
        }

        Collections.shuffle(baraja);
        return baraja;
    }

    /**
     * Obtiene el mazo revuelto
     * @return mazo revuelto 
     */
    public ArrayList<Carta> getMazoRevuelto() {
        return mazoRevuelto;
    }

    /**
     * Modifica el mazo de la clase que debería estar revuelto
     * @param mazoRevuelto arreglo de cartas
     */
    public void setMazoRevuelto(ArrayList<Carta> mazoRevuelto) {
        this.mazoRevuelto = mazoRevuelto;
    }
    
}
