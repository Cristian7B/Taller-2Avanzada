package edu.progavud.model;

public class Carta {
    private String tipo;
    private int valorInterno;

    public Carta(String tipo){
            this.tipo = tipo;
            valorInterno = 0;
    }
      
    public Carta(String tipo, int valorInterno){
            this.tipo = tipo;
            this.valorInterno = valorInterno;
    }
    
    public String getTipo() {
            return tipo;
    }
      
    public int getValorInterno() {
        return valorInterno;
    }

    public void setValorInterno(int valorInterno) {
        this.valorInterno = valorInterno;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


}
