/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.model;

/**
 *
 * @author ACER NITRO
 */
public class Jugador extends Persona {

    @Override
    public void calcularDinero(int transaccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int pedirCarta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //retorna la cantidad que va a postar cada jugador
    public int apostar(){
        int cantidadAApostar;
        cantidadAApostar = 0;
        return cantidadAApostar;
    }
    
    //dobla la apuesta pero solo recibe una carta
    public void doblar(){
        
    }
    
    //si tiene el mismo valor en las dos cartas primeras, puede dividir en dos manos y generar otra apuesta con la nueva mano
    public void dividir(){
        
    }
    
    //puede asegurar apostando a que le salga blackjack al crupier, si su primera carta es un as. se paga 2 a 1
    //puede apostar como maximo, la mitad de lo que aposto inicialmente
    public void asegurar(){
        
    }
    
    //recibe ganancias de 3 a 2, si en las primeras cartas le sale blackjack
    public void blackjack(){
        
    }
    
    //el jugador se planta cuando crea que no necesita mas cartas
    public void plantarse(){
        
    }
    
}
