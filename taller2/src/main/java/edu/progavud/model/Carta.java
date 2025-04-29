package edu.progavud.model;

public class Carta {
      private String tipo;
      private String jerarquia;
      private int valorInterno;

      public Carta(String tipo, String jerarquia){
            this.tipo = tipo;
            this.jerarquia = jerarquia;
      }
      
      public Carta(String tipo, String jerarquia,int valorInterno){
            this.tipo = tipo;
            this.jerarquia = jerarquia;
            this.valorInterno = valorInterno;
      }
      public String getTipo() {
            return tipo;
      }
      
      public String getJerarquia() {
            return jerarquia;
      }

      public int getValorInterno() {
            return valorInterno;
      }

      public void setValorInterno(int valorInterno) {
            this.valorInterno = valorInterno;
      }

}
