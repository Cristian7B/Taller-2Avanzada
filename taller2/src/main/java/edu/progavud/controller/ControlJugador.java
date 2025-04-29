package edu.progavud.controller;

import java.util.ArrayList;

import edu.progavud.model.Carta;

public class ControlJugador {
      private ControlPrincipal controlPrincipal;
      private ArrayList<Carta> mazo;
      public ControlJugador(ControlPrincipal controlPrincipal){
            this.controlPrincipal = controlPrincipal;
      }

      public void crearMazo(){
            Carta aux;
            String[] tipo = {"PICA","DIAMANTE","TREBOL","CORAZON"};
            String[] jerarquia = {"AS","DOS","TRES","CUATRO","CINCO","SEIS","SIETE","OCHO","NUEVE","DIEZ","JACK","QUEEN","KING"};
            for (String aux1: tipo) {
                  for (String aux2 : jerarquia) {
                        switch(aux2) {
                              case "AS":
                                    aux = new Carta(aux1,aux2);
                                    mazo.add(aux);
                                    break;
                              case "DOS":
                                    aux  = new Carta(aux1,aux2,2);
                                    mazo.add(aux);
                                    break;
                              case "TRES":
                                    aux  = new Carta(aux1,aux2,3);
                                    mazo.add(aux);
                                    break;
                              case "CUATRO":
                                    aux  = new Carta(aux1,aux2,4);
                                    mazo.add(aux);
                                    break;
                              case "CINCO":
                                    aux  = new Carta(aux1,aux2,5);
                                    mazo.add(aux);
                                    break;
                              case "SEIS":
                                    aux  = new Carta(aux1,aux2,6);
                                    mazo.add(aux);
                                    break;
                              case "SIETE":
                                    aux  = new Carta(aux1,aux2,7);
                                    mazo.add(aux);
                                    break;
                              case "OCHO":
                                    aux  = new Carta(aux1,aux2,8);
                                    mazo.add(aux);
                                    break;
                              case "NUEVE":
                                    aux  = new Carta(aux1,aux2,9);
                                    mazo.add(aux);
                                    break;
                              case "DIEZ":
                                    aux  = new Carta(aux1,aux2,10);
                                    mazo.add(aux);
                                    break;
                              case "JACK":
                                    aux  = new Carta(aux1,aux2,10);
                                    mazo.add(aux);
                                    break;
                              case "QUEEN":
                                    aux  = new Carta(aux1,aux2,10);
                                    mazo.add(aux);
                                    break;
                              case "KING":
                                    aux  = new Carta(aux1,aux2,10);
                                    mazo.add(aux);
                                    break;
                        }
                  }
            }
      }
      
      public void rebolverMazo(){

      }

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
