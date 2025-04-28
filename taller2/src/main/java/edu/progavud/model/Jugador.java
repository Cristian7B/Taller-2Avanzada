/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.model;

/**
 * Clase hija de Persona que representa todos los jugadores dentro del juego.
 * 
 * @author ACER NITRO
 */
public class Jugador extends Persona {

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
     * Método heredado de la clase Persona, sirve para que los
     * jugadores hagan la apuesta inicial.
     * 
     * @return cantidad que va a apostar cada jugador
     */ 
    public int apostar(){
        int cantidadAApostar;
        cantidadAApostar = 0;
        return cantidadAApostar;
    }
    
    /**
     * Método heredado de la clase Persona, dobla el valor de la
     * apuesta pero solo recibe una carta
     */
    public void doblar(){
        
    }
    
    /**
     * Método heredado de la clase Persona,si tiene el mismo 
     * valor en las dos cartas primeras, puede dividir sus cartas
     * en dos manos y generar otra apuesta con la nueva mano
     */
    public void dividir(){
        
    }
    
    /**
     * Método heredado de la clase Persona, puede asegurar 
     * apostando a que le salga blackjack al crupier,
     * si su primera carta es un as. se paga 2 a 1.
     * Se puede apostar como maximo, la mitad de lo que aposto 
     * en la apuesta inicial.
     */
    public void asegurar(){
        
    }
    
    /**
     * Método heredado de la clase Persona, se paga 
     * 3 a 2, si en las primeras dos cartas le sale blackjack,
     * es decir que suman 21.
     */
    public void blackjack(){
        
    }
    
    /**
     * Método heredado de la clase Persona, el jugador se 
     * planta cuando crea que no necesita mas cartas.
     */
    public void plantarse(){
        
    }
    
}
