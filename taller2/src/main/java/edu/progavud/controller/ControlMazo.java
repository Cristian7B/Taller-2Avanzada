/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.controller;

import edu.progavud.model.Carta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * En esta clase se revolverá el mazo para crear un
 * mazo jugable y luego llamarlo en el control del juego
 * @author Nicolas Velasco
 */
public class ControlMazo {
    //como Persona no se puede incluir dentro de este Control
    //por SOLID, el método creado generarMano se usará
    //para asignar la mano a los jugadores dentro de ControlPrincipal
    /**
     * Arreglo de objetos Carta para crear el mazo revuelto
     */
    private ArrayList<Carta> mazoRevuelto;
    /**
     * Objeto que establece la comunicación con controlPrincipal
     */
    private ControlPrincipal controlPrincipal;
    /**
     * Método constructor de la clase que asigna el mazo revuelto
     */
    public ControlMazo(ControlPrincipal controlPrincipal){
        this.controlPrincipal = controlPrincipal;
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
    
    /**
     * Método que genera la mano en cada ronda, en la primera ronda
     * le da una carta a los dos jugadores y una al crupier y así sucesivamente en cada ronda, 
     * este método únicamente genera la mano inicial de las partidas, no sirve
     * para pedir cartas.
     * @param ronda ronda de repartición de la mano inicial, 
     *              jamás existirán dos rondas con el mismo número
     * @return un arreglo de Cartas de dos posiciones, la primera
     *         posición es para el primer jugador, la segunda posición
     *         para el segundo jugador.
     */
    public ArrayList<Carta> generarMano(int ronda){
        ArrayList<Carta> mano = new ArrayList<>();
        mano.add(mazoRevuelto.get((ronda*3)-2)); //jugador 1
        mano.add(mazoRevuelto.get((ronda*3)-1)); //jugador 2
        mano.add(mazoRevuelto.get(ronda*3)); //crupier
        return mano;    
    }
    public Carta getRandomCarta(){
        Carta carta;
        Random ran = new Random();
        int numero = ran.nextInt(52);
        carta = mazoRevuelto.get(numero);
        return carta;
    }
}
